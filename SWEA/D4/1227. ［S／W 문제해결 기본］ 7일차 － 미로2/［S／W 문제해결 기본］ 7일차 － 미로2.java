import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

class Solution {
	static boolean[][] maze = new boolean[100][100];
	static int[] start = new int[2];
	static int[] end = new int[2];

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			br.readLine(); // 테케 번호 버리기
			for (int r = 0; r < 100; r++) {
				String line = br.readLine();
				for (int c = 0; c < 100; c++) {
					switch (line.charAt(c)) {
					case '0':
						maze[r][c] = true;
						break;
					case '1':
						maze[r][c] = false;
						break;
					case '2':
						maze[r][c] = true;
						start[0] = r;
						start[1] = c;
						break;
					case '3':
						maze[r][c] = true;
						end[0] = r;
						end[1] = c;
						break;
					}
				}
			}
			System.out.println("#" + test_case + " " + bfs());
		}
	}

	static int[][] visited = new int[100][100];
	static int vChk = 0; // 방문 배열 체크용
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static int bfs() {
		vChk++;
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		visited[start[0]][start[1]] = vChk;
		dq.add(start);

		while (!dq.isEmpty()) {
			int[] poll = dq.poll();
			int pr = poll[0];
			int pc = poll[1];

			for (int dIdx = 0; dIdx < 4; dIdx++) {
				int nr = pr + dr[dIdx];
				int nc = pc + dc[dIdx];

				// 장외
				if (nr < 0 || nc < 0 || nr >= 100 || nc >= 100) {
					continue;
				}
				// 이미 방문
				if (visited[nr][nc] == vChk) {
					continue;
				}
				// 벽
				if (maze[nr][nc] == false) {
					continue;
				}
				// 도착점
				if (nr == end[0] && nc == end[1]) {
					return 1;
				}

				dq.add(new int[] { nr, nc });
				visited[nr][nc] = vChk;
			}

		}
		return 0;
	}
}