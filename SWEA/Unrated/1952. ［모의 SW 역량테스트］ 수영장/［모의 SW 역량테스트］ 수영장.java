import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	static int answer;
	static int day, month, threeMonth;
	static int[] plan = new int[12];

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테케수
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());

			day = Integer.parseInt(tk.nextToken());
			month = Integer.parseInt(tk.nextToken());
			threeMonth = Integer.parseInt(tk.nextToken());
			answer = Integer.parseInt(tk.nextToken()); // 정답은 1년 이용권보다 비싸질 수 없음

			tk = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				plan[i] = Integer.parseInt(tk.nextToken());
			}
			dfs(0, 0);
			sb.append("#" + test_case + " " + answer + "\n");
		}

		System.out.println(sb.toString());
	}

	static void dfs(int monthIdx, int totalPay) {
		if (monthIdx >= 12) {
			answer = Math.min(answer, totalPay);
			return;
		}
		// 현재까지 가능한 최소 비용인 answer보다 비싸지는 순간 가지치기
		if (answer <= totalPay) {
			return;
		}

		if (plan[monthIdx] == 0) {
			dfs(monthIdx + 1, totalPay);
		} else {
			int currentMonth = Math.min(plan[monthIdx] * day, month);
			dfs(monthIdx + 1, totalPay + currentMonth);
			dfs(monthIdx + 3, totalPay + threeMonth);
		}
	}
}