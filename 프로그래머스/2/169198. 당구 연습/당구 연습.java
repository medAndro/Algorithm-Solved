import java.util.Arrays;

class Solution {

	public static int startX;
	public static int startY;

	public int[] solution(int m, int n, int startX, int startY, int[][] balls) {

		Solution.startX = startX;
		Solution.startY = startY;

		int[] answer = new int[balls.length];
		int idx = 0;
		for (int[] ball : balls) {
			int ans = Integer.MAX_VALUE;
			int[] candidates = new int[4];
			Arrays.fill(candidates, Integer.MAX_VALUE);

			if (!(startY == ball[1] && ball[0] < startX)) {
				int xDist1 = -ball[0];
				int yDist1 = ball[1];
				candidates[0] = getAnsCandidate(xDist1, yDist1);
			}

			if (!(startY == ball[1] && ball[0] > startX)) {
				int xDist2 = ball[0] + (m - ball[0]) * 2;
				int yDist2 = ball[1];
				candidates[1] = getAnsCandidate(xDist2, yDist2);
			}

			if (!(startX == ball[0] && ball[1] < startY)) {
				int xDist3 = ball[0];
				int yDist3 = -ball[1];
				candidates[2] = getAnsCandidate(xDist3, yDist3);
			}
			if (!(startX == ball[0] && ball[1] > startY)) {
				int xDist4 = ball[0];
				int yDist4 = ball[1] + (n - ball[1]) * 2;
				candidates[3] = getAnsCandidate(xDist4, yDist4);
			}

			for (int candidate : candidates) {
				ans = Math.min(ans, candidate);
			}

			answer[idx++] = ans;
		}

		return answer;
	}

	int getAnsCandidate(int tX, int tY) {
		return (startX - tX) * (startX - tX) + (startY - tY) * (startY - tY);
	}
}