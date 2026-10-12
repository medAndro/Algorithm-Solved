import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	static int[] Memo;
	static int day, month, triple, year;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			day = Integer.parseInt(tk.nextToken());
			month = Integer.parseInt(tk.nextToken());
			triple = Integer.parseInt(tk.nextToken());
			year = Integer.parseInt(tk.nextToken());
			Memo = new int[13];

			tk = new StringTokenizer(br.readLine());
			for (int i = 1; i <= 12; i++) {
				int plan = Integer.parseInt(tk.nextToken());
				Memo[i] = Memo[i - 1] + Math.min(plan * day, month);
				int safeIdx = i - 3 < 0 ? 0 : i - 3;
				int tripleSum = Memo[i] - Memo[safeIdx];
				if (tripleSum > triple) {
					Memo[i] = Memo[i] - tripleSum + triple;
				}
			}

			Memo[12] = Math.min(Memo[12], year);
			sb.append("#" + test_case + " " + Memo[12] + "\n");
		}
		System.out.println(sb.toString());
	}
}
