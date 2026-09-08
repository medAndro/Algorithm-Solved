import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 수제 버거 장인 조합 풀이
class Solution {
	static int answer;
	static int 재료수;
	static boolean[][] wrong_case; // 섞지 못하는 재료끼리의 인접행렬
	static int[] combiCase;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테케수
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());

			answer = 0;
			재료수 = Integer.parseInt(tk.nextToken());
			wrong_case = new boolean[401][401];
			combiCase = new int[재료수];
			int c = Integer.parseInt(tk.nextToken());
			for (int i = 0; i < c; i++) {
				tk = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(tk.nextToken());
				int b = Integer.parseInt(tk.nextToken());
				wrong_case[a][b] = true;
				wrong_case[b][a] = true;
			}

			combi(1, 0);

			sb.append("#" + test_case + " " + answer + "\n");
		}
		System.out.println(sb.toString());
	}

	static void combi(int start, int idx) {

		for (int i = 0; i < idx; i++) {
			for (int j = 0; j < idx; j++) {
				if (i == j) {
					continue;
				}
				if (wrong_case[combiCase[i]][combiCase[j]]) {
					return;
				}
			}
		}
		answer++;

		for (int i = start; i <= 재료수; i++) {
			combiCase[idx] = i;
			combi(i + 1, idx + 1);
			combiCase[idx] = 0;
		}
	}

}