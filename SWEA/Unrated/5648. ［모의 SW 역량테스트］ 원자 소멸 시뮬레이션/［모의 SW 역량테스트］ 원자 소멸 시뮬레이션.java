import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
	static int N;
	static Atom[][] map;
	static ArrayList<Atom> atoms; // {r, c, direction, energy}
	static final int UP = 0;
	static final int DOWN = 1;
	static final int LEFT = 2;
	static final int RIGHT = 3;
	static int headCollision[] = { 1, 0, 3, 2 }; // 정면 충돌 방향
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	static int answerEnergy;

	static class Atom {
		int r;
		int c;
		int direction;
		int energy;

		public Atom(int r, int c, int direction, int energy) {
			super();
			this.r = r;
			this.c = c;
			this.direction = direction;
			this.energy = energy;
		}

	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			map = new Atom[2001][2001];
			atoms = new ArrayList<>();
			answerEnergy = 0;
			// 원자 정보 입력
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				int direction = Integer.parseInt(st.nextToken());
				int energy = Integer.parseInt(st.nextToken());

				if (r > 0) {
					r = 1000 - r;
				} else {
					r = -r + 1000;
				}
				c += 1000;

				Atom a = new Atom(r, c, direction, energy);
				atoms.add(a);
				map[r][c] = a;
			}
			for (int i = 0; i <= 2000; i++) {
				moveSecond();
			}
			sb.append("#" + test_case + " " + answerEnergy + "\n");
		}
		System.out.println(sb.toString());
	}

	static int[][] movedPosChk = new int[2001][2001]; // 이동할 위치에 몇개가 도착한지 메모

	public static boolean isSafePos(int r, int c) {
		if (r >= 0 && c >= 0 && r <= 2000 && c <= 2000) {
			return true;
		}
		return false;
	}

	public static void moveSecond() {
		// 매 초간 동시 이동 과정
		// 원자를 순차적으로 순회하며 정면충돌이 아닌 겨우 이동한 위치를 기록한다
		List<int[]> movePos = new LinkedList<>();
		for (int i = 0; i < atoms.size(); i++) {
			Atom a = atoms.get(i);
			int nextR = a.r + dr[a.direction];
			int nextC = a.c + dc[a.direction];

			// 좌표계를 벗어난 원소 제거하기
			if (!isSafePos(nextR, nextC)) {
				i--;
				atoms.remove(a);
				continue;
			}

			if ((map[nextR][nextC] != null) && (headCollision[a.direction] == map[nextR][nextC].direction)) {
				// 정면충돌인 경우 바로 제거처리하고 기록하지 않는다.
				i--;
				answerEnergy += a.energy;
				atoms.remove(a);
				map[a.r][a.c] = null;

				answerEnergy += map[nextR][nextC].energy;
				atoms.remove(map[nextR][nextC]);
				map[nextR][nextC] = null;

			} else {
				movedPosChk[nextR][nextC]++;
				movePos.add(new int[] { nextR, nextC });
			}
		}
		// 재순회한다
		for (int i = 0; i < atoms.size(); i++) {
			Atom a = atoms.get(i);
			int nextR = a.r + dr[a.direction];
			int nextC = a.c + dc[a.direction];

			if (movedPosChk[nextR][nextC] >= 2) {
//				충돌이 발생한 경우 제거처리한다
				i--;
				answerEnergy += a.energy;
				atoms.remove(a);
				map[a.r][a.c] = null;
			} else {
//				충돌이 발생하지 않은경우 이동처리한다
				map[a.r][a.c] = null;
				a.r = nextR;
				a.c = nextC;
				map[nextR][nextC] = a;
			}
		}
//		이동된 위치를 기록하던 메모를 초기화
		for (int[] pos : movePos) {
			movedPosChk[pos[0]][pos[1]] = 0;
		}
	}
}
