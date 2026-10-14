import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, X;
	static int[][] area;
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			N = Integer.parseInt(tk.nextToken());
			X = Integer.parseInt(tk.nextToken());
			area = new int[N * 2][N];
			answer = 0;

			for (int r = 0; r < N; r++) {
				tk = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					area[r][c] = Integer.parseInt(tk.nextToken());
					area[c + N][r] = area[r][c];
				}
			}

			for (int r = 0; r < N * 2; r++) {
				if (chkLine(area[r]))
					answer++;
			}

			sb.append("#" + test_case + " " + answer + "\n");
		}
		System.out.println(sb.toString());
	}

	static boolean chkLine(int[] line) {
		int sameCnt = 1;
		for (int i = 1; i < N; i++) {
			int diff = line[i] - line[i - 1];
			if (diff == 0) {
				sameCnt++;
			} else if (diff == 1) {
				// 1칸 오르막
				if (sameCnt >= X) {
					sameCnt = 1;
				} else {
					return false;
				}
			} else if (diff == -1) {
				// 1칸 내리막
				if (sameCnt >= 0) {
					sameCnt = 1 - X;
				} else {
					return false;
				}
			} else {
				return false;
			}
		}

		return sameCnt >= 0;
	}
}