import java.util.Arrays;

class UserSolution {
	static int N; // 어항의 수
	static int mWidth; // 어항의 가로 길이 최대 500
	static int mHeight; // 어항의 세로 길이 최대 1500
	static int mids[]; // 어항의 id
	// 결합판 종류는 +1해서 사용할것! (1,2,3)

	Aquarium[] aquas;

	final static int 구조물 = -8;

	static class Aquarium {
		int id;
		int map[][];
		int mLengths[];
		int mUpShapes[];

		public Aquarium(int id, int mLengths[], int mUpShapes[]) {
			this.id = id;
			this.mLengths = mLengths;
			this.mUpShapes = mUpShapes;
			this.map = new int[mHeight][mWidth];

			for (int c = 0; c < mWidth; c++) {
				for (int r = mHeight - 1; r > mHeight - 1 - mLengths[c]; r--) {
					map[r][c] = -8;
				}
				map[mHeight - mLengths[c]][c] = mUpShapes[c];
			}
		}

		int getAvailableCnt(int lengths[], int downShapes[]) {

			int cnt = 0;
			for (int c = 0; c < mWidth - 2; c++) {
				if (isAvailable(c, lengths, downShapes)) {
					cnt++;
				}
			}

//			if (lengths[2] == 1) {
//				System.out.println();
//			}
			return cnt;
		}

		int setNewPeaces(int lengths[], int upShapes[], int downShapes[]) {
			int ans = -1;
			for (int c = 0; c < mWidth - 2; c++) {
				if (isAvailable(c, lengths, downShapes)) {

					for (int i = 0; i < 3; i++) {
						int nc = c + i;

						for (int r = 0; r < lengths[i]; r++) {
							map[mHeight - mLengths[nc] - r][nc] = 구조물;
						}

						mLengths[nc] += lengths[i];
						mUpShapes[nc] = upShapes[i];

						map[mHeight - mLengths[nc]][nc] = mUpShapes[nc];

					}

					ans = id * 1000 + c + 1;
					break;
				}
			}

			return ans;
		}

		// 한 지점에서 오른쪽으로 총 3개 범위가 가능한지 검사
		boolean isAvailable(int c, int lengths[], int downShapes[]) {
			for (int i = 0; i < 3; i++) {
				int nc = c + i;
				if (mUpShapes[nc] != downShapes[i] || (lengths[i] + this.mLengths[nc]) > mHeight) {
					return false;
				}
				// 두번쨰부터 왼쪽결합판 붙어있는지 검사
				if (i > 0) {
					if (this.mLengths[nc - 1] >= (lengths[i] + this.mLengths[nc])) {
						return false;
					}

					if (this.mLengths[nc] >= (this.mLengths[nc - 1] + lengths[i - 1])) {
						return false;
					}

				}
			}
			return true;
		}

		// 높이, 사용된 양 (높이가 -1이면 안되는것)
		int[] poor(int water) {
			int wHeight = -1;
			int wAmount = 0;

			for (int r = mHeight - 1; r >= 0; r--) {
				int emptyCnt = 0;
				for (int c = 0; c < mWidth; c++) {
					if (map[r][c] == 0) {
						emptyCnt++;
					}
				}

				if (emptyCnt == 0) {
					continue;
				}
				if (water >= emptyCnt) {
					water -= emptyCnt;
					wAmount += emptyCnt;
					wHeight = mHeight - r;
				} else {
					break;
				}
			}

			return new int[] { wHeight, wAmount };
		}
	}

	public void init(int N, int mWidth, int mHeight, int mIDs[], int mLengths[][], int mUpShapes[][]) {
		UserSolution.N = N;
		UserSolution.mWidth = mWidth;
		UserSolution.mHeight = mHeight;
		this.aquas = new Aquarium[N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < mUpShapes[i].length; j++) {
				mUpShapes[i][j]++; // 결합판 1Based 번호맞추기
			}
			aquas[i] = new Aquarium(mIDs[i], mLengths[i], mUpShapes[i]);
		}

		Arrays.sort(aquas, (a, b) -> Integer.compare(a.id, b.id));
	}

	public int checkStructures(int mLengths[], int mUpShapes[], int mDownShapes[]) {
		for (int i = 0; i < 3; i++) {
			mUpShapes[i]++;
			mDownShapes[i]++; // 결합판 1Based 번호맞추기
		}

		int sum = 0;

		for (Aquarium a : aquas) {
			sum += a.getAvailableCnt(mLengths, mDownShapes);
		}

//		System.out.println(sum);
		return sum;
	}

	public int addStructures(int mLengths[], int mUpShapes[], int mDownShapes[]) {
		for (int i = 0; i < 3; i++) {
			mUpShapes[i]++;
			mDownShapes[i]++; // 결합판 1Based 번호맞추기
		}
		for (Aquarium a : aquas) {
			int ans = a.setNewPeaces(mLengths, mUpShapes, mDownShapes);

			if (ans != -1) {
//				System.out.println(ans);
				return ans;
			}
		}

//		System.out.println(0);
		return 0;
	}

	public Solution.Result pourIn(int mWater) {
		Solution.Result ret = new Solution.Result();

		ret.ID = ret.height = ret.used = 0;
		int maxHeight = 0;
		int maxUsed = 0;
		for (Aquarium a : aquas) {
			int[] h_u = a.poor(mWater);

			int height = h_u[0];
			int used = h_u[1];

			if (height == -1) {
				continue;
			}

			if (maxHeight < height) {
				maxHeight = height;
				maxUsed = used;
				ret.ID = a.id;
				ret.height = height;
				ret.used = used;
			} else if (maxHeight == height) {
				if (maxUsed < used) {
					maxHeight = height;
					maxUsed = used;
					ret.ID = a.id;
					ret.height = height;
					ret.used = used;
				}
			}
		}

//		System.out.println(ret);
		return ret;
	}
}