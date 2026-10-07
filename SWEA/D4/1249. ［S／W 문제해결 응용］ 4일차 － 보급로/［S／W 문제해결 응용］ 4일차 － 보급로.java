import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
	static final int INF = (int) 1e9;
	static int N;
	static int[][] Area;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			Area = new int[N][N];

			for (int r = 0; r < N; r++) {
				String lineStr = br.readLine();
				for (int c = 0; c < N; c++) {
					Area[r][c] = Character.getNumericValue(lineStr.charAt(c));
				}
			}

			sb.append("#" + test_case + " " + dijkstra() + "\n");
		}
		System.out.println(sb.toString());
	}

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static boolean isSafePos(int r, int c) {
		if (r < 0 || c < 0 || r >= N || c >= N) {
			return false;
		}
		return true;
	}

	public static int dijkstra() {
		int dist[][] = new int[N][N];
		dist[0][0] = 0;
		for (int r = 0; r < N; r++) {
			Arrays.fill(dist[r], INF);
		}

		// {r, c, 시작점부터의 도로 깊이 합}
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
		pq.offer(new int[] { 0, 0, 0 });

		while (!pq.isEmpty()) {
			int[] poll = pq.poll();
			int pR = poll[0];
			int pC = poll[1];
			int pDist = poll[2];

			if (dist[pR][pC] < pDist) {
				continue;
			}

			if (pR == N - 1 && pC == N - 1) {
				return pDist;
			}

			for (int di = 0; di < 4; di++) {
				int nR = dr[di] + pR;
				int nC = dc[di] + pC;
				if (!isSafePos(nR, nC)) {
					continue;
				}

				int nDist = pDist + Area[nR][nC];

				if (dist[nR][nC] > nDist) {
					dist[nR][nC] = nDist;
					pq.offer(new int[] { nR, nC, nDist });
				}
			}
		}
		return -1;
	}
}