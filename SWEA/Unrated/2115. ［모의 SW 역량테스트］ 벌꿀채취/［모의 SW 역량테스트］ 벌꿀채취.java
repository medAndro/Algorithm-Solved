import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
	static int N, M, C;
	static int[][] honeyPots; // 원본 벌통 정보
	static int[][] bestCosts; // 각 row의 [인덱스]이상 (인덱스 + M-1)이하까지의 벌통을 수확했을때 최대 판매가 저장
	static int brN; // bestCosts의 Row의 길이

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			N = Integer.parseInt(tk.nextToken());
			M = Integer.parseInt(tk.nextToken());
			partM = new int[M];

			C = Integer.parseInt(tk.nextToken());
			bags = new int[C + 1];
			honeyPots = new int[N][N];
			brN = N - M + 1;
			bestCosts = new int[N][brN];

			for (int r = 0; r < N; r++) {
				tk = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					honeyPots[r][c] = Integer.parseInt(tk.nextToken());
				}
			}

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < brN; c++) {
					bestCosts[r][c] = getCostByKnapsack(r, c);
				}
			}

			int answer = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < brN; c++) {
					int localAns = bestCosts[r][c];
					for (int rr = r; rr < N; rr++) {
						for (int cc = 0; cc < brN; cc++) {
							if (rr == r && cc < c + M) {
								continue;
							}
							localAns = Math.max(localAns, (bestCosts[r][c] + bestCosts[rr][cc]));
						}
					}
					answer = Math.max(answer, localAns);

				}
			}
			sb.append("#" + test_case + " " + answer + "\n");
		}
		System.out.println(sb.toString());
	}

	static int[] bags;
	static int[] partM; // M개의 벌통의 일부분을 추출

//	honeyPots[r][c] 부터  M개의 벌통을 조사해서 최대 판매가반환
	static int getCostByKnapsack(int r, int c) {
		Arrays.fill(bags, 0);

		for (int cc = c; cc < c + M; cc++) {
			int hVal = honeyPots[r][cc];
			for (int cIdx = C; cIdx >= hVal; cIdx--) {
				int bagVal = bags[cIdx - hVal] + (hVal * hVal);
				if (bagVal > bags[cIdx]) {
					bags[cIdx] = bagVal;
				}
			}
		}

		return bags[C];
	}
}