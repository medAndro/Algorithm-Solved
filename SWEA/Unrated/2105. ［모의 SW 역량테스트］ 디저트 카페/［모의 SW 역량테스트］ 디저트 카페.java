import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
	static int N;
	static int cafe[][];
	static int cafeN;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			cafeN = N * 2 - 1;
			cafe = new int[cafeN][cafeN];
			int answer = -1;

			// 주어진 카페들을 시계방향으로 45도 회전
			int rStart = 0;
			int cStart = N - 1;
			for (int i = 0; i < N; i++) {
				StringTokenizer tk = new StringTokenizer(br.readLine());
				int r = rStart;
				int c = cStart;
				for (int j = 0; j < N; j++) {
					cafe[r + j][c + j] = Integer.parseInt(tk.nextToken());
				}
				rStart++;
				cStart--;
			}

			// 둘레 순회하며 최대값 찾기
			for (int r = 0; r < cafeN; r++) {
				for (int c = 0; c < cafeN; c++) {
					if (cafe[r][c] == 0) {
						continue;
					}
					for (int w = 2; w <= N; w++) {
						for (int h = 2; h <= N; h++) {
							answer = Math.max(answer, isSafeRoute(r, c, w, h));
						}
					}
				}
			}
			sb.append("#" + test_case + " " + answer + "\n");
		}
		System.out.println(sb.toString());
	}

	static int[] dr = { 0, 2, 0, -2 };
	static int[] dc = { 2, 0, -2, 0 };

	static boolean[] visit = new boolean[101];

	// 특정 위치rc를 왼쪽 위 꼭지점으로 두고 아래쪽 직사각형 둘에 영역을 가로 세로 길이로 순회하는게 가능하면 둘레 길이 불가하면 -1
	public static int isSafeRoute(int r, int c, int width, int height) {
		Arrays.fill(visit, false);

		for (int dIdx = 0; dIdx < 4; dIdx++) {

			if (dIdx == 0 || dIdx == 2) {
				for (int i = 1; i < width; i++) {
					r += dr[dIdx];
					c += dc[dIdx];

					if (!isSafeCafePos(r, c) || cafe[r][c] == 0) {
						return -1;
					}

					if (visit[cafe[r][c]]) {
						return -1;
					} else {
						visit[cafe[r][c]] = true;
					}
				}
			} else if (dIdx == 1 || dIdx == 3) {
				for (int i = 1; i < height; i++) {
					r += dr[dIdx];
					c += dc[dIdx];

					if (!isSafeCafePos(r, c) || cafe[r][c] == 0) {
						return -1;
					}

					if (visit[cafe[r][c]]) {
						return -1;
					} else {
						visit[cafe[r][c]] = true;
					}
				}
			}

		}

		return ((width - 1) * 2) + ((height - 1) * 2);
	}

	public static boolean isSafeCafePos(int r, int c) {
		if (r >= 0 && c >= 0 && r < cafeN && c < cafeN) {
			return true;
		}
		return false;
	}
}
