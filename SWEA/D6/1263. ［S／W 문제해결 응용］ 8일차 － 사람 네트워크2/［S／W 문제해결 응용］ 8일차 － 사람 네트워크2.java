import java.util.ArrayDeque;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
	static int n;
	static boolean[][] graph;
	static int minDist;
	static int minIdx;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			tk = new StringTokenizer(br.readLine());
			n = Integer.parseInt(tk.nextToken());

			minDist = (int) 1e9;
			minIdx = 0;

			graph = new boolean[n][n];

			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					graph[r][c] = tk.nextToken().equals("1") ? true : false;
				}
			}
			for (int r = 0; r < n; r++) {
				bfs(r);
			}

			sb.append("#" + test_case + " " + minDist + "\n");
		}
		System.out.println(sb.toString());
	}

	static int[] visit = new int[1001];
	static int visitChk = 0;

	static void bfs(int i) {
		visitChk++;

		ArrayDeque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] { i, 0 });
		visit[i] = visitChk;

		int localDist = 0;
		while (!dq.isEmpty()) {
			int[] poll = dq.poll();
			int pI = poll[0];
			int pLen = poll[1];

			for (int r = 0; r < n; r++) {
				int nI = r;
				if (!graph[pI][nI] || visit[nI] == visitChk) {
					continue;
				}
				int nLen = pLen + 1;
				visit[nI] = visitChk;

				localDist += nLen;
				dq.offer(new int[] { nI, nLen });

			}

		}

		if (minDist > localDist) {
			minDist = localDist;
			minIdx = i;
		}
	}
}