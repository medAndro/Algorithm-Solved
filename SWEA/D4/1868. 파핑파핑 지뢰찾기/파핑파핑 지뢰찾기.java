import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

class Solution {
	static int N;
	static boolean minesweeper[][];
	static boolean opened[][];
	static int answer;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			minesweeper = new boolean[N][N];
			opened = new boolean[N][N];
			answer = 0;

			for (int r = 0; r < N; r++) {
				String line = br.readLine();
				for (int c = 0; c < N; c++) {
					switch (line.charAt(c)) {
					case '*':
						minesweeper[r][c] = true;
					}
				}
			}

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (!minesweeper[r][c] && !opened[r][c] && getMineCnt(r, c) == 0) {
						bfs(r, c);
						answer++;
					}
				}
			}

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (!minesweeper[r][c] && !opened[r][c]) {
						answer++;
					}
				}
			}
			sb.append("#" + test_case + " " + answer + "\n");
		}
		System.out.println(sb.toString());
	}

	static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

	static int getMineCnt(int r, int c) {
		int cnt = 0;
		for (int dIdx = 0; dIdx < 8; dIdx++) {
			int nr = r + dr[dIdx];
			int nc = c + dc[dIdx];

			if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
				continue;
			}
			if (minesweeper[nr][nc]) {
				cnt++;
			}
		}
		return cnt;
	}

	static void bfs(int r, int c) {

		ArrayDeque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] { r, c });
		opened[r][c] = true;

		while (!dq.isEmpty()) {
			int[] poll = dq.poll();
			int pr = poll[0];
			int pc = poll[1];

			for (int dIdx = 0; dIdx < 8; dIdx++) {
				int nr = pr + dr[dIdx];
				int nc = pc + dc[dIdx];

				if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
					continue;
				}

				if (minesweeper[nr][nc]) {
					continue;
				}

				if (opened[nr][nc]) {
					continue;
				}

				opened[nr][nc] = true;
				if (getMineCnt(nr, nc) == 0) {
					dq.offer(new int[] { nr, nc });
				}
			}
		}

	}
}