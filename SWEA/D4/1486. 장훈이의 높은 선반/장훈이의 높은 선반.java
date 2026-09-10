import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	static int jangHoonHight, N, makeAbleHight;
	static int[] hights = new int[12];

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테케수
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			N = Integer.parseInt(tk.nextToken());
			jangHoonHight = Integer.parseInt(tk.nextToken());
			hights = new int[N];

			makeAbleHight = 1000000000;
			tk = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				hights[i] = Integer.parseInt(tk.nextToken());
			}
			dfs(0, 0);

			sb.append("#" + test_case + " " + (makeAbleHight - jangHoonHight) + "\n");
		}

		System.out.println(sb.toString());
	}

	static void dfs(int depth, int hightSum) {
		if (makeAbleHight == jangHoonHight) {
			// 장훈이와 정확히 동일한 키가 가능하면 탐색 중단
			return;
		}

		if (hightSum > makeAbleHight) {
			// 지금까지 합한 키가 확인된 만들수 있는 높이보다 크면 가지치기
			return;
		}

		if (depth == N) {
			if (jangHoonHight <= hightSum) {
				makeAbleHight = Math.min(makeAbleHight, hightSum);
			}
			return;
		}

		dfs(depth + 1, hightSum);
		dfs(depth + 1, hightSum + hights[depth]);
	}
}