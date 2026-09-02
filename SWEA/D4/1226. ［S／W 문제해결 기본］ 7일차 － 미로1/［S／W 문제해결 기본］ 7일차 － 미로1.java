import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		StringBuilder sb = new StringBuilder();

		int[] dr = { 0, 0, 1, -1 };
		int[] dc = { 1, -1, 0, 0 };

		for (int test_case = 1; test_case <= T; test_case++) {
			br.readLine();// 테케번호 버리기
			char maze[][] = new char[16][16];
			int[] startPos = new int[1];
			int[] endPos = new int[1];

			for (int r = 0; r < 16; r++) {
				String lineStr = br.readLine();
				for (int c = 0; c < 16; c++) {
					maze[r][c] = lineStr.charAt(c);
					if (maze[r][c] == '2') {
						startPos = new int[] { r, c };
					}
					if (maze[r][c] == '3') {
						endPos = new int[] { r, c };
					}
				}
			}

			final char WALL = '1';
			final char VISIT = 'v';

			ArrayDeque<int[]> dq = new ArrayDeque<>();
			dq.add(startPos);
			int startR = startPos[0];
			int startC = startPos[1];
			int endR = endPos[0];
			int endC = endPos[1];
			maze[startR][startC] = VISIT;

			int answer = 0;

			while (!dq.isEmpty()) {
				int[] poll = dq.poll();
				int pR = poll[0];
				int pC = poll[1];

				if (pR == endR && pC == endC) {
					answer = 1;
					break;
				}

				for (int dIdx = 0; dIdx < 4; dIdx++) {
					int newR = pR + dr[dIdx];
					int newC = pC + dc[dIdx];

					// 장외인 경우 skip
					if (newR < 0 || newC < 0 || newR >= 16 || newC >= 16) {
						continue;
					}
					// 벽이나 방문한 곳의경우 skip
					if (maze[newR][newC] == WALL || maze[newR][newC] == VISIT) {
						continue;
					}
					maze[newR][newC] = VISIT;
					dq.add(new int[] { newR, newC });
				}

			}

			sb.append("#");
			sb.append(test_case);
			sb.append(" ");
			sb.append(answer);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
