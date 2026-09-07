import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());

			int snackLen = Integer.parseInt(tk.nextToken());
			int[] snacks = new int[snackLen];
			int maxAmount = Integer.parseInt(tk.nextToken());

			tk = new StringTokenizer(br.readLine());
			for (int snackIdx = 0; snackIdx < snackLen; snackIdx++) {
				snacks[snackIdx] = Integer.parseInt(tk.nextToken());
			}
			Arrays.sort(snacks);
			int answer = -1;
			int leftIdx = 0;
			int rightIdx = snackLen - 1;
			int maxSum = -1;

			while (leftIdx < rightIdx) {
				int localSum = snacks[leftIdx] + snacks[rightIdx];
				if (maxAmount < localSum) {
					rightIdx--;
				} else {
					maxSum = Math.max(maxSum, localSum);
					leftIdx += 1;
				}
			}

			if (maxSum > 0 && maxSum <= maxAmount) {
				answer = maxSum;
			}

			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
}