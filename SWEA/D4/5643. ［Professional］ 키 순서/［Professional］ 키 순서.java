import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	static int N, M;
	static boolean[][] graph;
	static int answer;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			graph = new boolean[N + 1][N + 1];
			answer = 0;

			for (int i = 0; i < M; i++) {
				StringTokenizer tk = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(tk.nextToken());
				int b = Integer.parseInt(tk.nextToken());
				graph[a][b] = true;
			}

			for (int k = 1; k <= N; k++) {
				for (int s = 1; s <= N; s++) {
					for (int e = 1; e <= N; e++) {
						graph[s][e] = graph[s][e] || (graph[s][k] && graph[k][e]);
					}
				}
			}

			
			for (int r = 1; r <= N; r++) {
				int cnt = 0;
				for (int c = 1; c <= N; c++) {
					if (graph[r][c] || graph[c][r])
						cnt++;
				}
				if (cnt == N - 1)
					answer++;
			}

			sb.append("#" + test_case + " " + answer + "\n");
		}
		System.out.println(sb.toString());
	}

}