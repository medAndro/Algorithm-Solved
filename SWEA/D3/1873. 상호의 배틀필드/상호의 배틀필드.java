import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
//	.	평지(전차가 들어갈 수 있다.)
//	*	벽돌로 만들어진 벽
//	#	강철로 만들어진 벽
//	-	물(전차는 들어갈 수 없다.)
//	^	위쪽을 바라보는 전차(아래는 평지이다.)
//	v	아래쪽을 바라보는 전차(아래는 평지이다.)
//	<	왼쪽을 바라보는 전차(아래는 평지이다.)
//	>	오른쪽을 바라보는 전차(아래는 평지이다.)

	public static char field[][];
	public static int rLen;
	public static int cLen;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테케수
		StringBuilder sb = new StringBuilder();

		// 상하좌우
		int dr[] = { -1, 1, 0, 0 };
		int dc[] = { 0, 0, -1, 1 };

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());

			rLen = Integer.parseInt(tk.nextToken()); // 높이
			cLen = Integer.parseInt(tk.nextToken()); // 너비

			field = new char[rLen][cLen];

			int carPosR = -1;
			int carPosC = -1;

			for (int r = 0; r < rLen; r++) {
				String lineStr = br.readLine();
				for (int c = 0; c < cLen; c++) {
					field[r][c] = lineStr.charAt(c);

					if (isCar(field[r][c])) {
						carPosR = r;
						carPosC = c;
					}
				}
			}

			int caseN = Integer.parseInt(br.readLine());
			String caseStr = br.readLine();

			for (int caseIdx = 0; caseIdx < caseN; caseIdx++) {
				char caseChar = caseStr.charAt(caseIdx);
				int casePosIdx = -1;
				int carPosIdx = carToCarPosIdx(field[carPosR][carPosC]);

				switch (caseChar) {
				case 'U':
					casePosIdx = 0;
					break;
				case 'D':
					casePosIdx = 1;
					break;
				case 'L':
					casePosIdx = 2;
					break;
				case 'R':
					casePosIdx = 3;
					break;
				}

				if (casePosIdx == -1) {
					// shoot
					int nextR = carPosR;
					int nextC = carPosC;
					while (true) {
						nextR += dr[carPosIdx];
						nextC += dc[carPosIdx];

						if (isSafePos(nextR, nextC)) {
							// 필드 안쪽
							if (field[nextR][nextC] == '#') {
								// 강철벽
								break;
							} else if (field[nextR][nextC] == '*') {
								// 벽돌벽
								field[nextR][nextC] = '.';
								break;
							}
						} else {
							// 필드 바깥쪽
							break;
						}

					}

				} else {
					// 회전과 한칸 이동
					int caseDr = dr[casePosIdx];
					int caseDc = dc[casePosIdx];

					int nextR = carPosR + caseDr;
					int nextC = carPosC + caseDc;
					char nextCar = carPosIdxToCar(casePosIdx);
					if (isSafePos(nextR, nextC) && field[nextR][nextC] == '.') {
						// 다음 길이 평지일경우 회전 및 이동
						field[carPosR][carPosC] = '.';
						field[nextR][nextC] = nextCar;
						carPosR = nextR;
						carPosC = nextC;
					} else {
						// 회전만
						field[carPosR][carPosC] = nextCar;
					}

				}
//				중간과정 로그
//				System.out.println(caseChar);
//				for (int r = 0; r < rLen; r++) {
//					for (int c = 0; c < cLen; c++) {
//						System.out.print(field[r][c]);
//					}
//					System.out.println(" ");
//				}

			}

			sb.append("#");
			sb.append(test_case);
			sb.append(" ");

			for (int r = 0; r < rLen; r++) {
				for (int c = 0; c < cLen; c++) {
					sb.append(field[r][c]);
				}
				sb.append("\n");
			}

		}

		System.out.println(sb.toString());

	}

	public static boolean isSafePos(int r, int c) {
		if (r >= 0 && c >= 0 && r < rLen && c < cLen) {
			return true;
		}
		return false;

	}

	public static boolean isCar(char car) {
		if (carToCarPosIdx(car) != -1) {
			return true;
		}
		return false;
	}

	public static int carToCarPosIdx(char car) {
		switch (car) {
		case '^':
			return 0;
		case 'v':
			return 1;
		case '<':
			return 2;
		case '>':
			return 3;
		default:
			return -1;
		}
	}

	public static char carPosIdxToCar(int carIdx) {
		switch (carIdx) {
		case 0:
			return '^';
		case 1:
			return 'v';
		case 2:
			return '<';
		case 3:
			return '>';
		default:
			return 'x';
		}
	}
}