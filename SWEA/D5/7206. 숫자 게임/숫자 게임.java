import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			answer = 0;
			int N = Integer.parseInt(br.readLine());
			dfs(N, 0);

			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.print(sb);
	}

	static void dfs(int number, int depth) {
		if (number < 10) {
			answer = Math.max(answer, depth);
			return;
		}

		int bitLen = getNumberLen(number) - 1;

		// 모든 비트 조합을 만드는 for문
		// 1부터 (1 << bitLen) - 1 까지 모든 조합 탐색 (최소 1번 이상 자르는 경우)
		for (int selectedBit = 1; selectedBit < (1 << bitLen); selectedBit++) {
			int nextNumber = cutNumberMultiply(number, selectedBit);
			dfs(nextNumber, depth + 1);
		}
	}

	static int getNumberLen(int number) {
		return (number == 0) ? 1 : (int) (Math.log10(Math.abs(number)) + 1);
	}

	static int cutNumberMultiply(int number, int selectedBit) {
		String s = String.valueOf(number);
		int bitLen = s.length() - 1; // 자를 수 있는 경계 개수
		int product = 1;
		int currentChunk = 0;

		for (int i = 0; i < s.length(); i++) {
			// 자릿수를 순차적으로 누적하여 조각 생성 (1234 -> 1, 12, 123, 1234 을 for문 순회마다 누적하여 구함)
			currentChunk = currentChunk * 10 + (s.charAt(i) - '0');

			// 경계 위치(0 ~ bitLen-1)에서 비트 검사
			if (i < bitLen) {
				int bitIndex = bitLen - 1 - i; // 왼쪽 경계부터 상위 비트 매핑
				if ((selectedBit & (1 << bitIndex)) != 0) {
					product *= currentChunk; // 비트가 1이면 현재 조각을 곱함
					currentChunk = 0; // 다음 조각을 위해 초기화
										// ex) 12까지 쌓여 있었을 경우 초기화되어
										// 34 -> 3, 34가 for문 순회마다 누적하여 구해짐
				}
			}
		}
		// 마지막 조각 곱하기
		product *= currentChunk;

		return product;
	}
}