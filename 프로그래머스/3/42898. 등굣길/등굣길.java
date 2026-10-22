class Solution {
	static int colN, rowN;
	static boolean[][] area;
	static int[][] visitCnt;

	public int solution(int m, int n, int[][] puddles) {
		colN = m;
		rowN = n;

		area = new boolean[rowN][colN];
		visitCnt = new int[rowN][colN];
		visitCnt[0][0] = 1;
		for (int[] p : puddles) {
			int c = p[0] - 1;
			int r = p[1] - 1;
			area[r][c] = true;
		}

		for (int r = 0; r < rowN; r++) {
			for (int c = 0; c < colN; c++) {
				if (r == 0 && c == 0)
					continue;
				int lR = r;
				int lC = c - 1;
				int uR = r - 1;
				int uC = c;
				int leftVal = isSafePos(lR, lC) ? visitCnt[lR][lC] : 0;
				int upVal = isSafePos(uR, uC) ? visitCnt[uR][uC] : 0;
				visitCnt[r][c] = (leftVal + upVal) % 1_000_000_007;
			}
		}

		return visitCnt[rowN - 1][colN - 1];
	}

	static boolean isSafePos(int r, int c) {
		if (r < 0 || c < 0 || r >= rowN || c >= colN || area[r][c]) {
			return false;
		}
		return true;
	}
}