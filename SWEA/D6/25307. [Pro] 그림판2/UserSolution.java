import java.util.ArrayDeque;

class UserSolution {
	int[][] paper;
	int N;

	public void init(int N, int L, char[] mCode) {
		paper = new int[N][N];
		this.N = N;
		decode(mCode, 1, 0, 0, N / 2);
		return;
	}

	public int decode(char[] mCode, int mCodeIdx, int tR, int tC, int partSize) {
		for (int i = 1; i <= 4; i++) {
			char c = mCode[mCodeIdx];

			int[] nextTrTc = getNextTrTc(tR, tC, i, partSize);
			int nextTr = nextTrTc[0];
			int nextTc = nextTrTc[1];

			if (c == '(') {
				mCodeIdx = decode(mCode, mCodeIdx + 1, nextTr, nextTc, partSize / 2) - 1;
			} else {

				int fillVal = Character.getNumericValue(c);

				// 1인 패치 채우기
				if (fillVal == 1) {
					for (int rr = nextTr; rr < nextTr + partSize; rr++) {
						for (int cc = nextTc; cc < nextTc + partSize; cc++) {
							paper[rr][cc] = fillVal;
						}
					}
				}
			}

			mCodeIdx++;
		}
		return mCodeIdx + 1;
	}

	int[] getNextTrTc(int tR, int tC, int partIdx, int partSize) {

		int nextTr = tR;
		int nextTc = tC;
		switch (partIdx) {
		case 2:
			nextTc = tC + partSize;
			break;
		case 3:
			nextTr = tR + partSize;
			break;
		case 4:
			nextTr = tR + partSize;
			nextTc = tC + partSize;
			break;
		}

		return new int[] { nextTr, nextTc };

	}

	char encodeAns[];

	public int encode(char[] mCode) {
		encodeAns = mCode;
		int len = encode(0, 0, 0, N / 2);
		if (len == 6) {
			len = 1;
			mCode[0] = encodeAns[1];
		}

		return len;
	}

	public int encode(int codeLen, int tR, int tC, int partSize) {
		encodeAns[codeLen++] = '(';

		for (int i = 1; i <= 4; i++) {
			int[] nextTrTc = getNextTrTc(tR, tC, i, partSize);
			int nextTr = nextTrTc[0];
			int nextTc = nextTrTc[1];

			// 현재 파츠가 전부 같은지 검사
			boolean isPartAllSame = true;
			int partVal = paper[nextTr][nextTc];
			for (int rr = nextTr; rr < nextTr + partSize; rr++) {
				if (!isPartAllSame) {
					break;
				}
				for (int cc = nextTc; cc < nextTc + partSize; cc++) {
					if (paper[rr][cc] != partVal) {
						isPartAllSame = false;
						break;
					}
				}
			}

			if (isPartAllSame) {
				encodeAns[codeLen++] = partVal == 1 ? '1' : '0';
			} else {
				codeLen = encode(codeLen, nextTr, nextTc, partSize / 2);
			}
		}
		encodeAns[codeLen++] = ')';
		return codeLen;
	}

	public void makeDot(int mR, int mC, int mSize, int mColor) {
		int width = ((mSize - 1) * 2) + 1;

		int curWidth = 1;
		int curBlank = (mSize - 1);
		int delim = 1;

		// 시작 지점 이동 변위량
		int pointMoveR = -(mSize - 1) + mR;
		int pointMoveC = -(mSize - 1) + mC;

		for (int dr = pointMoveR; dr < width + pointMoveR; dr++) {

			for (int dc = curBlank + pointMoveC; dc < curBlank + curWidth + pointMoveC; dc++) {
				if (isSafePos(dr, dc)) {
					paper[dr][dc] = mColor;
				}

			}

			if (curBlank == 0) {
				delim = -1;
			}
			curWidth += delim * 2;
			curBlank -= delim;

		}

		return;
	}

	boolean isSafePos(int r, int c) {
		if (r >= 0 && c >= 0 && r < N && c < N) {
			return true;
		}
		return false;
	}

	int[] dr = new int[] { 0, 0, 1, -1 };
	int[] dc = new int[] { 1, -1, 0, 0 };

	public void paint(int mR, int mC, int mColor) {
		if (paper[mR][mC] == mColor) {
			return;
		}

		ArrayDeque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] { mR, mC });
		paper[mR][mC] = mColor;

		int reverseC = mColor == 1 ? 0 : 1;

		while (!dq.isEmpty()) {
			int[] poll = dq.poll();
			int pR = poll[0];
			int pC = poll[1];

			for (int dIdx = 0; dIdx < 4; dIdx++) {
				int newR = pR + dr[dIdx];
				int newC = pC + dc[dIdx];

				if (isSafePos(newR, newC) && paper[newR][newC] == reverseC) {
					paper[newR][newC] = mColor;
					dq.offer(new int[] { newR, newC });
				}
			}
		}

		return;
	}

	public int getColor(int mR, int mC) {
		return paper[mR][mC];
	}
}