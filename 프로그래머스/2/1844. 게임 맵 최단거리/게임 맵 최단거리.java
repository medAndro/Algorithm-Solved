import java.util.*;

class Solution {
	public int solution(int[][] maps) {
		int m = maps[0].length;
		int n = maps.length;
		if (m == 1 && n == 1)
			return 1;

		int answer = -1;
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.offerFirst(new int[] { 0, 0 });

		int[][] dist = new int[n][m];
		dist[0][0] = 1;

		int[] dy = { -1, 0, 0, 1 };
		int[] dx = { 0, -1, 1, 0 };

		while (!queue.isEmpty() && dist[n - 1][m - 1] == 0) {
			int[] q = queue.pollFirst();
			int len = dist[q[0]][q[1]];

			for (int i = 0; i < 4; i++) {
				int yy = dy[i] + q[0];
				int xx = dx[i] + q[1];

				if (yy >= 0 && xx >= 0 && yy < n && xx < m) {
					if (dist[yy][xx] == 0 && maps[yy][xx] == 1) {
						if (yy == n - 1 && xx == m - 1) {
							return len + 1;
						} else {
							queue.offerLast(new int[] { yy, xx });
							dist[yy][xx] = len + 1;
						}
					}
				}
			}
		}

		return answer;
	}
}