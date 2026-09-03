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

			permute(0);

			sb.append("#").append(test_case).append(" ").append(kyuYoungWinCase).append(" ").append(kyuYoungLoseCase)
					.append("\n");
		}
		System.out.println(sb.toString());
	}

	public static void permute(int depth) {
		if (depth == 9) {
			int kyuYoungSum = 0;
			int innyoungSum = 0;

			for (int i = 0; i < 9; i++) {
				if (kyuYoung[i] > innyoung[i]) {
					kyuYoungSum += kyuYoung[i] + innyoung[i];
				} else {
					innyoungSum += kyuYoung[i] + innyoung[i];
				}
			}

			if (innyoungSum < kyuYoungSum) {
				kyuYoungWinCase++;
			} else {
				kyuYoungLoseCase++;
			}
			return;
		}
		for (int i = depth; i < 9; i++) {
			swap(innyoung, depth, i);
			permute(depth + 1);
			swap(innyoung, i, depth);
		}
	}

	public static void swap(int[] arr, int idxFrom, int idxTo) {
		int to = arr[idxTo];
		arr[idxTo] = arr[idxFrom];
		arr[idxFrom] = to;

	}
}