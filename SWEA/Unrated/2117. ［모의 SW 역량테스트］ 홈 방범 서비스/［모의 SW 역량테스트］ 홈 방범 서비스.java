import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution {
	static int[][] Area;
	static int N, M, MaxK, HomeCnt;
	static int Answer;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			N = Integer.parseInt(tk.nextToken());
			M = Integer.parseInt(tk.nextToken());
			MaxK = 1;
			HomeCnt = 0;
			Answer = 0;

			Area = new int[N][N];

			for (int r = 0; r < N; r++) {
				tk = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					Area[r][c] = Integer.parseInt(tk.nextToken());
					if (Area[r][c] == 1)
						HomeCnt++;
				}
			}

			int maxPossibleCost = HomeCnt * M;

			while (true) {
				if (getCost(MaxK) > maxPossibleCost) {
					MaxK--;
					break;
				}
				MaxK++;
			}

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					bfs(r, c);
				}
			}

			sb.append("#" + test_case + " " + Answer + "\n");
		}
		System.out.println(sb.toString());
	}

	static int getCost(int K) {
		return K * K + (K - 1) * (K - 1);
	}

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static boolean isSafePos(int r, int c) {
		if (r < 0 || c < 0 || r >= N || c >= N) {
			return false;
		}
		return true;
	}

	static int[][] visit = new int[20][20];
	static int visitChk = 0;

	public static void bfs(int r, int c) {
		visitChk++;
		int homeCnt = 0;
		int checkedDepth = 0;

		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] { r, c, 1 });
		if (Area[r][c] == 1) {
			homeCnt++;
		}
		visit[r][c] = visitChk;

		while (!queue.isEmpty()) {
			int[] poll = queue.poll();
			int pr = poll[0];
			int pc = poll[1];
			int pDepth = poll[2];

			if (checkedDepth < pDepth) {
				// 현재 k 순회완료
				if (getCost(pDepth) <= homeCnt * M) {
					Answer = Math.max(Answer, homeCnt);
				}
				checkedDepth = pDepth;
			}

			if (pDepth > MaxK) {
				return;
			}

			for (int di = 0; di < 4; di++) {
				int nr = pr + dr[di];
				int nc = pc + dc[di];

				if (!isSafePos(nr, nc)) {
					continue;
				}
				if (visit[nr][nc] == visitChk) {
					continue;
				}

				visit[nr][nc] = visitChk;
				int nDepth = pDepth + 1;

				if (Area[nr][nc] == 1) {
					homeCnt++;
				}

				queue.offer(new int[] { nr, nc, nDepth });
			}

		}
	}
}