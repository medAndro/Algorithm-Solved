import java.util.ArrayDeque;

class Solution {
	int[] robot = new int[2];
	int[] goal = new int[2];
	boolean[][] board;
	int[][] visit;

	public int solution(String[] rawBoard) {
		board = new boolean[rawBoard.length][rawBoard[0].length()];
		visit = new int[rawBoard.length][rawBoard[0].length()];

		for (int r = 0; r < rawBoard.length; r++) {
			for (int cIdx = 0; cIdx < rawBoard[r].length(); cIdx++) {
				char chr = rawBoard[r].charAt(cIdx);
				switch (chr) {
				case 'D':
					board[r][cIdx] = true;
					break;
				case 'R':
					robot[0] = r;
					robot[1] = cIdx;
					break;
				case 'G':
					goal[0] = r;
					goal[1] = cIdx;
					break;
				}
			}
		}

		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.offer(robot);

		int[] dr = { 0, 0, 1, -1 };
		int[] dc = { 1, -1, 0, 0 };
		while (!queue.isEmpty()) {
			int[] curRobot = queue.poll();
			int r = curRobot[0]; // 로봇 현재위치
			int c = curRobot[1];

			for (int i = 0; i < 4; i++) {
				int rr = r; // 로봇 다음위치 후보
				int cc = c;
				int rrr = rr; // 같은 방향으로 반복 이동 테스트용
				int ccc = cc;

				while (true) {
					rrr += dr[i]; // 후보를 한칸 이동
					ccc += dc[i];
					if (rrr < 0 || ccc < 0 || rrr >= board.length || ccc >= board[0].length || board[rrr][ccc]) {
						break; // 로봇이 보드를 벗어났거나 D에 있을경우 업데이트 안하고 중단
					} else {
						rr = rrr; // 이동 가능하면 다음 위치 후보를 업데이트
						cc = ccc;
					}
				}

				if (rr == r && cc == c) {
					continue; // 로봇 바로옆 벽이라 이동 불가
				}

				// 방문했던곳이 아니거나, 초기로봇위칙 아닌경우
				if (visit[rr][cc] == 0 && !(rr == robot[0] && cc == robot[1])) {
					visit[rr][cc] = visit[r][c] + 1;
					queue.offer(new int[] { rr, cc });
				}
			}
			if (visit[goal[0]][goal[1]] > 0) {
				break;
			}
		}

		if (visit[goal[0]][goal[1]] == 0) {
			visit[goal[0]][goal[1]] = -1;
		}

		return visit[goal[0]][goal[1]];
	}
}
