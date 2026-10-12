import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class Solution {
	static List<Integer> graph[];
	static int[] info;
	static int N;
	static int answer;
	static int full_visit_bit;
	static int MaxDepth;

	public int solution(int[] info, int[][] edges) {
		Solution.info = info;
		N = info.length;
		MaxDepth = edges.length * 2;
		full_visit_bit = (1 << N) - 1;
		// 양이면 1, 늑대면 -1로 info 변환
		for (int i = 0; i < N; i++) {
			info[i] = info[i] == 0 ? 1 : -1;
		}
		graph = new ArrayList[info.length];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList();
		}

		// 가중치가 1인 그래프 작성
		for (int[] edge : edges) {
			graph[edge[0]].add(edge[1]);
			graph[edge[1]].add(edge[0]);
		}
		answer = 1;
		findAns();
		return answer;
	}

	static void findAns() {
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		// 현재까지의 양+늑대 합, 노드 방문 비트, 양 마릿수
		dq.offer(new int[] { 1, 0b1, 1, 1 });

		while (!dq.isEmpty()) {
			int[] poll = dq.poll();
			int pVal = poll[0];
			int pVisit = poll[1];
			int pCnt = poll[2];

			for (int i = 0; i < N; i++) {
				if ((pVisit & (1 << i)) != 0) {
					for (int nextIdx : graph[i]) {
						int nVal = pVal;
						int nCnt = pCnt;
						int nVisit = pVisit;

						if ((pVisit & (1 << nextIdx)) == 0) {
							// 해당 노드를 방문 안한경우
							nCnt += info[nextIdx] == 1 ? 1 : 0;
							nVal += info[nextIdx];
							nVisit = nVisit | 1 << nextIdx; // 방문 비트 체크
						} else {
							// 해당 노드를 방문 한경우
							continue;
						}

						if (nVal <= 0) {
							continue;
						}

						answer = Math.max(answer, nCnt);
						dq.offer(new int[] { nVal, nVisit, nCnt });
					}
				}
			}
		}
	}
}