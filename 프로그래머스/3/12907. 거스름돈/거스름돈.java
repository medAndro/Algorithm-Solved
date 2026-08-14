import java.util.Arrays;

class Solution {
	public int solution(int n, int[] money) {
		Arrays.sort(money);
		long[] dp = new long[n + 1];

		for (int m : money) {
			for (int dpNo = 0; dpNo <= n; dpNo++) {
				int pocket = m;
				if (pocket > dpNo) {
					continue;
				} else if (pocket == dpNo) {
					dp[dpNo]++;
				} else {
					int dpCapacity = (dpNo - pocket);
					if (dp[dpCapacity] > 0) {
						dp[dpNo] += dp[dpCapacity];
					}
				}
			}
		}
		return (int) (dp[n] % 1000000007);
	}
}
