class Solution {
	public int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = new int[queries.length];

		int[][] board = new int[rows][columns];

		int cnt = 0;
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < columns; c++) {
				board[r][c] = ++cnt;
			}
		}

		for (int i = 0; i < queries.length; i++) {
			int[] query = queries[i];
			int r1 = query[0] - 1;// 2
			int c1 = query[1] - 1;// 2
			int r2 = query[2] - 1;// 5
			int c2 = query[3] - 1;// 4
			answer[i] = rotate(board, r1, c1, r2, c2);
		}

		return answer;
	}

	private int rotate(int[][] board, int r1, int c1, int r2, int c2) {
		int min = Integer.MAX_VALUE;

		int temp1 = board[r1][c2];
		for (int c = c2; c > c1; c--) {
			board[r1][c] = board[r1][c - 1];
			min = Math.min(min, board[r1][c]);
		}

		int temp2 = board[r2][c2];
		for (int r = r2; r > r1; r--) {
			if (r == r1 + 1) {
				board[r][c2] = temp1;
			} else {
				board[r][c2] = board[r - 1][c2];
			}
			min = Math.min(min, board[r][c2]);
		}

		int temp3 = board[r2][c1];
		for (int c = c1; c < c2; c++) {
			if (c == c2 - 1) {
				board[r2][c] = temp2;
			} else {
				board[r2][c] = board[r2][c + 1];
			}
			min = Math.min(min, board[r2][c]);
		}

		for (int r = r1; r < r2; r++) {
			if (r == r2 - 1) {
				board[r][c1] = temp3;
			} else {
				board[r][c1] = board[r + 1][c1];
			}
			min = Math.min(min, board[r][c1]);
		}

		return min;
	}
}