import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
	static int n;
	static int[][] pos;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			n = Integer.parseInt(br.readLine());

			pos = new int[n][2];
			for (int i = 0; i < n; i++) {
				tk = new StringTokenizer(br.readLine());
				pos[i][0] = Integer.parseInt(tk.nextToken());
				pos[i][1] = Integer.parseInt(tk.nextToken());
			}
			long answer = Long.MAX_VALUE;
			for (int mask = 0; mask < (1 << n); mask++) {
				if (Integer.bitCount(mask) != n / 2) {
					continue;
				}

				long sumX = 0;
				long sumY = 0;

				for (int i = 0; i < n; i++) {
					if ((mask & (1 << i)) != 0) {
						// 선택한 지렁이
						sumX += pos[i][0];
						sumY += pos[i][1];
					} else {
						// 선택하지 않은 지렁이
						sumX -= pos[i][0];
						sumY -= pos[i][1];
					}
				}
				long m = sumX * sumX + sumY * sumY;
				answer = Math.min(answer, m);
			}
			sb.append("#" + test_case + " " + answer + "\n");
		}
		System.out.println(sb.toString());
	}
}
