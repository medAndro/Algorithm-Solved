import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

// BFS + DP 풀이
class Solution {
	static final int INF = (int) 1e8;
	static int N;
	static int[][] Pos; // Pos[0] == 회사, Pos[1] == 집 , Pos[2...N+1] == 고객
	static int[][] graph;
	static int answer;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			Pos = new int[N + 2][2];
			graph = new int[N + 2][N + 2];
			answer = Integer.MAX_VALUE;

			StringTokenizer tk = new StringTokenizer(br.readLine());
			for (int i = 0; i < N + 2; i++) {
				Pos[i][1] = Integer.parseInt(tk.nextToken());
				Pos[i][0] = Integer.parseInt(tk.nextToken());
			}

			for (int i = 0; i < N + 2; i++) {
				for (int j = i + 1; j < N + 2; j++) {
					int dist = getManhatanDist(Pos[i], Pos[j]);
					graph[i][j] = dist;
					graph[j][i] = dist;
				}
			}

			bfs();
			sb.append("#" + test_case + " " + answer + "\n");
		}
		System.out.println(sb.toString());
	}

	public static void bfs() {
		int dp[][] = new int[N][(int) Math.pow(2, N)];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], INF);
		}
		int fullVisitMask = (int) Math.pow(2, N) - 1;

		// {노드인덱스, 시작점부터의 거리, 방문한 고객 비트마스킹}
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] { 0, 0, 0 });

		while (!dq.isEmpty()) {
			int[] poll = dq.poll();
			int pId = poll[0];
			int pDist = poll[1];
			int pBit = poll[2];

			if (pBit == fullVisitMask) {
				answer = Math.min(answer, graph[1][pId] + pDist);
				continue;
			}

			for (int i = 0; i < N; i++) {
				if ((pBit & 1 << i) != 0) {
					continue; // 이미 방문
				}
				int nId = i + 2;
				int nDist = graph[nId][pId] + pDist;
				int nBit = pBit | 1 << i;

				if (dp[i][nBit] > nDist) {
					dp[i][nBit] = nDist;
					dq.offer(new int[] { nId, nDist, nBit });
				}
			}
		}
	}

	public static int getManhatanDist(int[] p1, int[] p2) {
		int r1 = p1[0];
		int c1 = p1[1];
		int r2 = p2[0];
		int c2 = p2[1];
		return Math.abs(r1 - r2) + Math.abs(c1 - c2);
	}
}