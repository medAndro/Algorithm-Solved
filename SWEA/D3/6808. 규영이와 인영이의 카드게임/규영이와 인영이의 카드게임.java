import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
	public static int[] kyuYoung = new int[9];
	public static int[] innyoung = new int[9];
	public static int NOT_PICK = 0;
	public static int kyuYoungWinCase = 0;
	public static int kyuYoungLoseCase = 0;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테케수
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			kyuYoungWinCase = 0;
			kyuYoungLoseCase = 0;

			StringTokenizer tk = new StringTokenizer(br.readLine());

			boolean[] kyuYoungUsed = new boolean[19];
			for (int i = 0; i < 9; i++) {
				kyuYoung[i] = Integer.parseInt(tk.nextToken());
				kyuYoungUsed[kyuYoung[i]] = true;
			}

			int idx = 0;
			for (int i = 1; i <= 18; i++) {
				if (kyuYoungUsed[i]) {
					continue;
				}
				innyoung[idx++] = i;
			}

			int[] picked = new int[9];
			boolean[] visited = new boolean[9];

			permute(picked, visited, 0);

			sb.append("#").append(test_case).append(" ").append(kyuYoungWinCase).append(" ").append(kyuYoungLoseCase)
					.append("\n");
		}
		System.out.println(sb.toString());
	}

	public static void permute(int[] picked, boolean[] visited, int depth) {
		if (depth == 9) {
			int kyuYoungSum = 0;
			int innyoungSum = 0;

			for (int i = 0; i < 9; i++) {
				if (kyuYoung[i] > picked[i]) {
					kyuYoungSum += kyuYoung[i] + picked[i];
				} else {
					innyoungSum += kyuYoung[i] + picked[i];
				}
			}

			if (innyoungSum < kyuYoungSum) {
				kyuYoungWinCase++;
			} else {
				kyuYoungLoseCase++;
			}
			return;
		}
		for (int i = 0; i < 9; i++) {
			if (!visited[i]) {
				visited[i] = true;
				picked[depth] = innyoung[i];
				permute(picked, visited, depth + 1);
				visited[i] = false;
			}
		}
	}
}