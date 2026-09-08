import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

	class Edge {
		int to;
		int fare;

		public Edge(int to, int fare) {
			super();
			this.to = to;
			this.fare = fare;
		}

	}

	int graph[][];
	int n;
	final int INF = 100000000;
	int[] dist;

	int graphAtoP[][];
	int graphBtoP[][];
	int graphStoP[][];

	public int solution(int n, int s, int a, int b, int[][] fares) {

		this.n = n;
		dist = new int[n + 1];
		graph = new int[n + 1][n + 1];
		graphAtoP = new int[n + 1][n + 1];
		graphBtoP = new int[n + 1][n + 1];
		graphStoP = new int[n + 1][n + 1];

		for (int[] fare : fares) {
			int x = fare[0];
			int y = fare[1];
			graph[x][y] = fare[2];
			graph[y][x] = fare[2];
		}

		int answer = INF;

		dijkstraDraw(a, graphAtoP);
		dijkstraDraw(b, graphBtoP);
		dijkstraDraw(s, graphStoP);

		for (int pNode = 1; pNode <= n; pNode++) {
			if (graphStoP[s][pNode] == 0 && s != pNode) {
				continue;
			}
			if (graphAtoP[a][pNode] == 0 && a != pNode) {
				continue;
			}
			if (graphBtoP[b][pNode] == 0 && b != pNode) {
				continue;
			}

			answer = Math.min(answer, graphStoP[s][pNode] + graphAtoP[a][pNode] + graphBtoP[b][pNode]);

		}

		return answer;
	}

	void dijkstraDraw(int start, int[][] drawGraph) {
		Arrays.fill(dist, INF);
		dist[start] = 0;

		// {노드번호, 시작점부터의 요금} // 요금 작은순
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
		pq.offer(new int[] { start, 0 });

		while (!pq.isEmpty()) {

			int[] poll = pq.poll();
			int pNo = poll[0];
			int pFare = poll[1];

			if (dist[pNo] < pFare) {
				continue;
			}

			drawGraph[start][pNo] = pFare;
			drawGraph[pNo][start] = pFare;

			for (int toNo = 1; toNo <= n; toNo++) {
				if (graph[pNo][toNo] == 0)
					continue;

				int nextNo = toNo;
				int nextFare = pFare + graph[pNo][toNo];

				if (dist[nextNo] > nextFare) {
					dist[nextNo] = nextFare;
					pq.offer(new int[] { nextNo, nextFare });
				}
			}
		}
	}
}