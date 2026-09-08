import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 햄스터 순열 풀이
class Solution {
	static int[] answer; // 정답의 햄스터 우리
	static int answerHamCnt; // 정답의 햄스터 마리수

	static int 우리수;
	static int 우리당_최대수;
	static int 경근이_기록수;
	static int[][] 경근이조사값; // x우리부터 y우리까지 z햄스터수

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테케수
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());

			answerHamCnt = -1;
			우리수 = Integer.parseInt(tk.nextToken());
			우리당_최대수 = Integer.parseInt(tk.nextToken());
			경근이_기록수 = Integer.parseInt(tk.nextToken());

			경근이조사값 = new int[경근이_기록수][3];
			for (int i = 0; i < 경근이_기록수; i++) {
				tk = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(tk.nextToken());
				int y = Integer.parseInt(tk.nextToken());
				int z = Integer.parseInt(tk.nextToken());

				경근이조사값[i] = new int[] { x, y, z };
			}

			permu(new int[우리수], 0);

			sb.append("#" + test_case + " ");
			if (answerHamCnt == -1) {
				sb.append("-1");
			} else {
				for (int ans : answer) {
					sb.append(ans + " ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	static void permu(int[] 우리별_햄스터수, int depth) {

		if (depth == 우리수) {
			return;
		}

		for (int i = 0; i <= 우리당_최대수; i++) {
			우리별_햄스터수[depth] = i;
			int locaSum = 0;
			for (int j = 0; j < 우리수; j++) {
				locaSum += 우리별_햄스터수[j];
			}

			if (answerHamCnt < locaSum) {

				boolean 경근이_조사값_일치 = true;
				for (int[] 조사값 : 경근이조사값) {
					int x = 조사값[0];
					int y = 조사값[1];
					int z = 조사값[2];

					int 조사합 = 0;
					for (int h = x - 1; h < y; h++) {
						조사합 += 우리별_햄스터수[h];
					}

					if (조사합 != z) {
						경근이_조사값_일치 = false;
						break;
					}

				}

				if (경근이_조사값_일치) {
					answerHamCnt = locaSum;
					answer = 우리별_햄스터수.clone();
				}
			}

			permu(우리별_햄스터수, depth + 1);
		}
	}

}