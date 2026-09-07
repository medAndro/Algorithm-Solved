import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//조합 완탐 풀이
class Solution {
	public static class 재료정보 {
		int 맛_점수;
		int 칼로리;

		public 재료정보(int 맛_점수, int 칼로리) {
			super();
			this.맛_점수 = 맛_점수;
			this.칼로리 = 칼로리;
		}

	}

	static int answer;
	static int 재료의_수;
	static int 제한_칼로리;
	static 재료정보[] 재료들;
	static int[] selected = new int[20];

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			answer = 0; // 테케별 초기화
			StringTokenizer tk = new StringTokenizer(br.readLine());

			재료의_수 = Integer.parseInt(tk.nextToken());
			제한_칼로리 = Integer.parseInt(tk.nextToken());
			재료들 = new 재료정보[재료의_수];

			// 이번 테스트 케이스의 재료 정보들 입력받기
			for (int idx = 0; idx < 재료의_수; idx++) {
				tk = new StringTokenizer(br.readLine());
				int 맛_점수 = Integer.parseInt(tk.nextToken());
				int 칼로리 = Integer.parseInt(tk.nextToken());
				재료들[idx] = new 재료정보(맛_점수, 칼로리);
			}

			for (int r = 1; r <= 재료의_수; r++) {
				combi(r, 0, 0);
			}

			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}

	// 모든 재료중 r개 재료의 조합(nCr)을 구하여 answer에 최대 칼로리 갱신하는 함수
	static void combi(int r, int depth, int start) {
		if (depth == r) {
			int 칼로리합 = 0;
			int 점수합 = 0;
			for (int i = 0; i < r; i++) {
				점수합 += 재료들[selected[i]].맛_점수;
				칼로리합 += 재료들[selected[i]].칼로리;
				if (칼로리합 > 제한_칼로리) {
					return;
				}
			}
			answer = Math.max(answer, 점수합);
			return;
		}

		for (int i = start; i < 재료의_수; i++) {
			selected[depth] = i;
			combi(r, depth + 1, i + 1);
		}
	}
}
