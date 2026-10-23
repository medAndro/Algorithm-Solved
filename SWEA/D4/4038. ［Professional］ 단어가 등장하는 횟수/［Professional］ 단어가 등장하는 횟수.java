import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static final long MOD = 1_000_000_007;
	static final long BASE = 307;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			String book = br.readLine();
			String pattern = br.readLine();
			sb.append("#" + test_case + " " + rabinKarf(book, pattern) + "\n");
		}

		System.out.println(sb.toString());
	}

	static int rabinKarf(String book, String pattern) {
		int bn = book.length();
		int pn = pattern.length();

		if (bn < pn) {
			return 0;
		}

		// 초기 해시 구하기
		long bookHash = 0, patternHash = 0;
		for (int i = 0; i < pn; i++) {
			bookHash = (bookHash * BASE + book.charAt(i)) % MOD;
			patternHash = (patternHash * BASE + pattern.charAt(i)) % MOD;
		}

		// 최고 자릿값 구하기
		long pos = 1;
		for (int i = 0; i < pn - 1; i++) {
			pos = (pos * BASE) % MOD;
		}

		int answer = 0;
		for (int i = 0; i <= bn - pn; i++) {
			if (bookHash == patternHash) {
				answer++;
			}

			if (i < (bn - pn)) {
				bookHash = (bookHash - pos * book.charAt(i)) % MOD;
				if (bookHash < 0) {
					bookHash += MOD;
				}
				bookHash = ((bookHash * BASE) + book.charAt(i + pn)) % MOD;
			}
		}
		return answer;
	}
}