import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 조합 DFS + 역방향 누적합 가지치기 결합 풀이
class Solution {
	public static class 재료정보 {
		int 맛_점수;
		int 칼로리;

		public 재료정보(int 맛_점수, int 칼로리) {
			this.맛_점수 = 맛_점수;
			this.칼로리 = 칼로리;
		}
	}

	static int answer;
	static int 재료의_수;
	static int 제한_칼로리;
	static 재료정보[] 재료들;
	static int[] 누적_맛_점수;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			answer = 0;
			StringTokenizer tk = new StringTokenizer(br.readLine());

			재료의_수 = Integer.parseInt(tk.nextToken());
			제한_칼로리 = Integer.parseInt(tk.nextToken());
			재료들 = new 재료정보[재료의_수];

			for (int idx = 0; idx < 재료의_수; idx++) {
				tk = new StringTokenizer(br.readLine());
				int 맛_점수 = Integer.parseInt(tk.nextToken());
				int 칼로리 = Integer.parseInt(tk.nextToken());
				재료들[idx] = new 재료정보(맛_점수, 칼로리);
			}

			// 뒤에서부터 맛 점수를 누적합(Suffix Sum)으로 계산해두기
			// 재료가 4개일 경우 (4), (3+4), (2+3+4), (1+2+3+4) 점수들의 값이 저장됨
			누적_맛_점수 = new int[재료의_수 + 1];
			for (int i = 재료의_수 - 1; i >= 0; i--) {
				누적_맛_점수[i] = 누적_맛_점수[i + 1] + 재료들[i].맛_점수;
			}

			combi(0, 0, 0);

			sb.append("#" + test_case + " " + answer + "\n");
		}
		System.out.println(sb.toString());
	}

	static void combi(int start, int currentScore, int currentCal) {
		// 1. 칼로리 제한 초과 시 가지치기
		if (currentCal > 제한_칼로리) {
			return;
		}

		// 2. 유효 칼로리 내에서 최댓값 정답 갱신
		if (currentScore > answer) {
			answer = currentScore;
		}

		// 3. 현재 점수 + (start 인덱스부터 남은 모든 재료의 맛 점수) <= answer 라면
		// 앞으로 어떤 재료 조합을 선택하더라도 answer를 갱신할 수 없으므로 탐색 중단
		// 예: 1, 2번 재료(인덱스 0, 1)를 선택하여 start = 2 가 된 경우,
		// 남아있는 (3+4번) 재료의 누적합을 다 더해도 현재 answer보다 작거나 같을때 더 이상 탐색할 필요가 없음
		if (currentScore + 누적_맛_점수[start] <= answer) {
			return;
		}

		// 4. 다음 재료 선택 및 재귀 호출
		for (int i = start; i < 재료의_수; i++) {
			combi(i + 1, currentScore + 재료들[i].맛_점수, currentCal + 재료들[i].칼로리);
		}
	}
}