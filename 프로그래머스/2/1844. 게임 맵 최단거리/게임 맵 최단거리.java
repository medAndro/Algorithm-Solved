import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collector;

class Solution {
	public int solution(int[][] maps) {
		int[][] dist = new int[maps.length][maps[0].length];
		dist[0][0] = 1;
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] { 0, 0 });

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		while (!queue.isEmpty() && dist[maps.length - 1][maps[0].length - 1] == 0) {
			int[] polled = queue.poll();
			int r = polled[0];
			int c = polled[1];

			for (int i = 0; i < 4; i++) {
				int rr = r + dr[i];
				int cc = c + dc[i];
				if (rr >= 0 && cc >= 0 && rr < maps.length && cc < maps[0].length && maps[rr][cc] == 1
						&& dist[rr][cc] == 0) {
					dist[rr][cc] = dist[r][c] + 1;
					queue.offer(new int[] { rr, cc });
				}
			}
		}
		int answer = dist[maps.length - 1][maps[0].length - 1];
		answer = (answer == 0) ? -1 : answer;
		return answer;
	}
}