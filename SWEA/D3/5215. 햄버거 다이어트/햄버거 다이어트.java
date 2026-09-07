import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//조합 DFS 풀이
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

	static int answer;
	static int 재료의_수;
	static int 제한_칼로리;
	static 재료정보[] 재료들;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			answer = 0; // 테케별 초기화
			StringTokenizer tk = new StringTokenizer(br.readLine());

			재료의_수 = Integer.parseInt(tk.nextToken());
			제한_칼로리 = Integer.parseInt(tk.nextToken());
			재료들 = new 재료정보[재료의_수];

			// 이번 테스트 케이스의 재료 정보들 입력받기
			for (int idx = 0; idx < 재료의_수; idx++) {
				tk = new StringTokenizer(br.readLine());
				int 맛_점수 = Integer.parseInt(tk.nextToken());
				int 칼로리 = Integer.parseInt(tk.nextToken());
				재료들[idx] = new 재료정보(맛_점수, 칼로리);
			}

			combi(0, 0, 0);

			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}

	// 조합 DFS: 매개변수로 누적 값들을 들고 이동
	static void combi(int start, int currentScore, int currentCal) {
		// 1. 가지치기: 칼로리가 제한을 넘으면 즉시 중단
		if (currentCal > 제한_칼로리) {
			return;
		}

		// 2. 유효한 조합의 경우 정답 갱신
		if (currentScore > answer) {
			answer = currentScore;
		}

		// 3. 다음 재료를 하나씩 선택하며 재귀 호출
		for (int i = start; i < 재료의_수; i++) {
			combi(i + 1, currentScore + 재료들[i].맛_점수, currentCal + 재료들[i].칼로리);
		}
	}
}