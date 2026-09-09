import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Solution {
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, -1, 0, 1 };

	static final int DOWN = 0;
	static final int LEFT = 1;
	static final int UP = 2;
	static final int RIGHT = 3;
	static final int INF = 10_000_000;

	static class Core {
		int r;
		int c;
		int[] connectInfo;
		int wireCnt;
		List<Integer> connectWallDir;

		public Core(int r, int c) {
			super();
			this.r = r;
			this.c = c;
			this.connectWallDir = new ArrayList<>();
		}

		@Override
		public String toString() {
			return "Chip [r=" + r + ", c=" + c + "]";
		}

		// 연결이 될경우 그려진 라인의 길이, 막힌경우 INF
		int connect(int wireDir) {
			int nR = r;
			int nC = c;
			int drawCnt = 0;
			boolean isBlocked = false;

			// 벽까지 wireDir방향으로 긋기
			while (true) {
				nR += dr[wireDir];
				nC += dc[wireDir];
				if (nR < 0 || nC < 0 || nR >= N || nC >= N) {
					break;
				}

				if (wireMap[nR][nC]) {
					isBlocked = true;
					break;
				} else {
					wireMap[nR][nC] = true;
					drawCnt++;
				}

			}

			// 라인이 막혔을경우 원복시키기
			if (isBlocked) {
				nR = r;
				nC = c;
				while (drawCnt > 0) {
					nR += dr[wireDir];
					nC += dc[wireDir];

					wireMap[nR][nC] = false;
					drawCnt--;
				}
				return INF;
			}
			return drawCnt;
		}

		// 벽까지 원복하기
		void removeLine(int wireDir) {
			int nR = r;
			int nC = c;

			// 벽까지 wireDir방향으로 지우기
			while (true) {
				nR += dr[wireDir];
				nC += dc[wireDir];
				if (nR < 0 || nC < 0 || nR >= N || nC >= N) {
					break;
				}
				wireMap[nR][nC] = false;
			}
		}

	}

	static Core[][] coreMap;
	static boolean[][] wireMap;
	static int N;
	static boolean[] isChipsetInRow;
	static boolean[] isChipsetInCol;

	static List<Core> cores;
	static int coresLen;
	static int answerCoreCnt;
	static int answerWireLen;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테케수
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine().trim());
			coreMap = new Core[N][N];
			wireMap = new boolean[N][N];
			isChipsetInRow = new boolean[N];
			isChipsetInCol = new boolean[N];
			cores = new ArrayList<>();

			answerCoreCnt = 0;
			answerWireLen = INF;

			for (int r = 0; r < N; r++) {
				String line = br.readLine();
				for (int c = 0; c < N; c++) {
					if (line.charAt(c * 2) == '1') {
						coreMap[r][c] = new Core(r, c);

						isChipsetInRow[r] = true;
						isChipsetInCol[c] = true;

						if (r != 0 && c != 0) {
							cores.add(coreMap[r][c]);
						}
					}
				}
			}

			coresLen = cores.size();

			int chkPosR = 0;
			int chkPosC = 0;
			int chkPosDidx = UP; // 테두리 좌표 이동방향
			int wireIndex = RIGHT; // 해당 테두리에서 맵 안쪽으로 전선을 시험삼아 깔아볼 방향
			for (int outlineIdx = 0; outlineIdx < N * 4; outlineIdx++) {
				chkConnectDir(chkPosR, chkPosC, wireIndex);// (0, 0) 부터 테두리 시계방향 순회
				if (outlineIdx % N == 0) {
					chkPosDidx = (chkPosDidx + 1) % 4;
					wireIndex = (wireIndex + 1) % 4;
					chkConnectDir(chkPosR, chkPosC, wireIndex); // 꼭짓점은 방향 바꿔서 한번 더 순회
					outlineIdx++;
				}
				chkPosR += dr[chkPosDidx % 4];
				chkPosC += dc[chkPosDidx % 4];
			}

			dfs(0, 0, 0);
			sb.append("#" + test_case + " " + answerWireLen + "\n");
		}

		System.out.println(sb.toString());
	}

	static void dfs(int index, int connectedCount, int totalWireLength) {
		if (index == coresLen) {
			if (answerCoreCnt < connectedCount) {
				answerCoreCnt = connectedCount;
				answerWireLen = totalWireLength;

			} else if (answerCoreCnt == connectedCount && answerWireLen > totalWireLength) {
				answerWireLen = totalWireLength;
			}
			return;
		}

		// 남은 코어를 모두 연결해도 현재 최대 연결 수에 못 미치면 가지치기
		if (connectedCount + (coresLen - index) < answerCoreCnt) {
			return;
		}

		Core selectedCore = cores.get(index);
		for (int dir : selectedCore.connectWallDir) {
			int wireLen = selectedCore.connect(dir);

			// 벽까지 연결된 경우
			if (wireLen != INF) {
				dfs(index + 1, connectedCount + 1, totalWireLength + wireLen);
				selectedCore.removeLine(dir);
			}
		}

		dfs(index + 1, connectedCount, totalWireLength);

	}

	// 벽에서 안쪽으로 확인했을때 칩셋과 연결이 가능한지 확인
	static void chkConnectDir(int outlineR, int outlineC, int writeDir) {
		// 위아래 방향을 보는데 해당 컬럼에 칩셋이 없으면 스킵
		if ((writeDir == UP || writeDir == DOWN) && isChipsetInCol[outlineC] == false) {
			return;
		}

		// 좌우 방향을 보는데 해당 컬럼에 칩셋이 없으면 스킵
		if ((writeDir == LEFT || writeDir == RIGHT) && isChipsetInRow[outlineR] == false) {
			return;
		}

		int drawPointR = outlineR;
		int drawPointC = outlineC;
		for (int drawIdx = 0; drawIdx < N; drawIdx++) {
			if (coreMap[drawPointR][drawPointC] != null) {
				coreMap[drawPointR][drawPointC].connectWallDir.add((writeDir + 2) % 4);
				return;
			}
			drawPointR += dr[writeDir];
			drawPointC += dc[writeDir];
		}
	}
}