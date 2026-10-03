import java.util.Arrays;

class Solution {
	static int[][] graph;
	static final int INF = (int) 2e7;

	public int solution(int n, int[][] results) {
		int answer = 0;

		graph = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			Arrays.fill(graph[i], INF);
		}

		for (int i = 0; i < results.length; i++) {
			graph[results[i][0]][results[i][1]] = 1;
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			int cnt = 0;
			for (int j = 1; j <= n; j++) {
				if (graph[i][j] != INF) {
					cnt++;
				}
				if (graph[j][i] != INF) {
					cnt++;
				}
			}
			if (cnt == n - 1) {
				answer++;
			}
		}

		return answer;
	}

}