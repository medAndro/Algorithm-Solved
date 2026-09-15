import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Solution {
	static int N;
	static int cheese[][];
	static boolean visit[][];
	static int answer;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			cheese = new int[N][N];

			answer = 0;

			for (int r = 0; r < N; r++) {
				StringTokenizer tk = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					cheese[r][c] = Integer.parseInt(tk.nextToken());
				}
			}

			for (int day = 0; day <= 100; day++) {
				visit = new boolean[N][N];
				int dayAns = 0;
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						if (!visit[r][c] && cheese[r][c] > day) {
							bfs(day, r, c);
							dayAns++;
						}
					}
				}
				answer = Math.max(answer, dayAns);
			}
			sb.append("#" + test_case + " " + answer + "\n");
		}
		System.out.println(sb.toString());
	}

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static void bfs(int day, int r, int c) {

		ArrayDeque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] { r, c });
		visit[r][c] = true;

		while (!dq.isEmpty()) {
			int[] poll = dq.poll();
			int pr = poll[0];
			int pc = poll[1];

			for (int dIdx = 0; dIdx < 4; dIdx++) {
				int nextR = pr + dr[dIdx];
				int nextC = pc + dc[dIdx];

				if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= N) {
					continue;
				}

				if (cheese[nextR][nextC] <= day) {
					continue;
				}
				if (visit[nextR][nextC]) {
					continue;
				}

				visit[nextR][nextC] = true;
				dq.offer(new int[] { nextR, nextC });
			}
		}

	}
}