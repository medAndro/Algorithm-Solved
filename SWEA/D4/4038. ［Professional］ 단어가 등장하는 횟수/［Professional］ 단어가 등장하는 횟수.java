
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			String B = br.readLine();
			String S = br.readLine();

			sb.append("#").append(tc).append(" ").append(kmp(B, S)).append("\n");
		}

		System.out.print(sb);
	}

	static int kmp(String text, String pattern) {
		int[] pi = makePi(pattern);

		int index = 0; // 책에서 현재 검사할 위치
		int matchedLength = 0; // 현재까지 일치한 패턴의 길이
		int count = 0;

		while (index < text.length()) {

			char current = text.charAt(index);
			char expected = pattern.charAt(matchedLength);

			// 문자가 일치하는 경우
			if (current == expected) {
				matchedLength++;
				index++;

				// 패턴 전체가 일치했는지 확인
				if (matchedLength == pattern.length()) {
					count++;

					// 중첩된 패턴을 추가로 찾기 위해 재설정
					matchedLength = pi[matchedLength - 1];
				}
			}

			// 불일치하지만 이전에 일치한 부분이 있는 경우
			else if (matchedLength > 0) {
				matchedLength = pi[matchedLength - 1];
				// index를 증가시키지 않고 다시 비교
			}

			// 불일치하고 이전에 일치한 부분도 없는 경우
			else {
				index++;
			}
		}

		return count;
	}

	static int[] makePi(String pattern) {
		int[] pi = new int[pattern.length()];

		int index = 1; // 현재 검사할 문자 위치
		int matchedLength = 0; // 현재까지 일치한 접두사의 길이

		while (index < pattern.length()) {
			char current = pattern.charAt(index);
			char expected = pattern.charAt(matchedLength);

			// 문자가 일치하는 경우 - 일치하는 접두사/접미사 길이가 늘어남
			if (current == expected) {
				matchedLength++;

				pi[index] = matchedLength;
				index++;
			}

			// 불일치하지만 이전에 일치한 부분이 있는 경우
			else if (matchedLength > 0) {
				matchedLength = pi[matchedLength - 1];
				// index를 증가시키지 않고 같은 문자를 더 짧은 접두사와 다시 비교
			}

			// 불일치하고 이전에 일치한 부분도 없는 경우
			else {
				pi[index] = 0;
				index++;
			}
		}

		return pi;
	}

}
