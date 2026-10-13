import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, K;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			N = Integer.parseInt(tk.nextToken());
			K = Integer.parseInt(tk.nextToken());
			int[] knapsack = new int[K + 1];
			for (int i = 0; i < N; i++) {
				tk = new StringTokenizer(br.readLine());
				int v = Integer.parseInt(tk.nextToken());
				int c = Integer.parseInt(tk.nextToken());
				for (int j = K; j >= v; j--) {
					if (knapsack[j] < (c + knapsack[j - v])) {
						knapsack[j] = c + knapsack[j - v];
					}
				}
			}
			sb.append("#" + test_case + " " + knapsack[K] + "\n");
		}
		System.out.println(sb.toString());
	}
}
