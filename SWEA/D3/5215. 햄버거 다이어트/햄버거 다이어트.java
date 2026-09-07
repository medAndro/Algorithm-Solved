import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//같은 재료를 여러번 사용할 수 없으므로 0/1 kanpsack 문제
class Solution {
	public static class 재료정보 {
		int 맛_점수;
		int 칼로리;

		public 재료정보(int 맛_점수, int 칼로리) {
			super();
			this.맛_점수 = 맛_점수;
			this.칼로리 = 칼로리;
		}

	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());

			int 재료의_수 = Integer.parseInt(tk.nextToken());
			int 제한_칼로리 = Integer.parseInt(tk.nextToken());
			재료정보[] 재료들 = new 재료정보[재료의_수];

			// 이번 테스트 케이스의 재료 정보들 입력받기
			for (int idx = 0; idx < 재료의_수; idx++) {
				tk = new StringTokenizer(br.readLine());
				int 맛_점수 = Integer.parseInt(tk.nextToken());
				int 칼로리 = Integer.parseInt(tk.nextToken());
				재료들[idx] = new 재료정보(맛_점수, 칼로리);
			}

			// 인덱스 == 칼로리, 값1 == 합산 맛 점수
			int[] dp = new int[제한_칼로리 + 1];

			for (재료정보 재료 : 재료들) {
				for (int kcal = 제한_칼로리; kcal >= 재료.칼로리; kcal--) {
					int 기존_칼로리 = dp[kcal];
					int 새로운_칼로리 = dp[kcal - 재료.칼로리] + 재료.맛_점수;
					dp[kcal] = Math.max(기존_칼로리, 새로운_칼로리);
				}
			}

			int answer = dp[제한_칼로리];
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
}