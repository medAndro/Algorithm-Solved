import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
	static long BASE = 313L;
	static long MOD = 1_000_000_007L;

	static String B, S;
	static int n, m;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			B = br.readLine();
			S = br.readLine();
			n = B.length();
			m = S.length();

			if (n < m) {
				sb.append("#").append(test_case).append(" 0\n");
				continue;
			}

			long power = 1;

			for (int i = 0; i < m - 1; i++) {
				power = (power * BASE) % MOD;
			}

			long targetHash = 0;
			long windowHash = 0;

			for (int i = 0; i < m; i++) {
				targetHash = (targetHash * BASE + S.charAt(i)) % MOD;
				windowHash = (windowHash * BASE + B.charAt(i)) % MOD;
			}

			long cnt = 0;
			if (targetHash == windowHash) {
				cnt++;
			}

			for (int i = 0; i < n - m; i++) {
				windowHash = (windowHash - power * B.charAt(i)) % MOD;
				if (windowHash < 0) {
					windowHash += MOD;
				}

				windowHash = (windowHash * BASE + B.charAt(i + m)) % MOD;
				if (targetHash == windowHash) {
					cnt++;
				}
			}

			sb.append("#" + test_case + " " + cnt + "\n");
		}
		System.out.println(sb.toString());
	}

}