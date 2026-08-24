import java.util.ArrayDeque;

class Solution {
	char[][] storageChar;
	int rowN;
	int colN;
	final char WALL = '#';
	final char ISOLATE = '%';
	final char TEMP_CHK = '@';

	int[] dr = { 0, 0, 1, -1 };
	int[] dc = { 1, -1, 0, 0 };

	public int solution(String[] storage, String[] requests) {
		rowN = storage.length;
		colN = storage[0].length();
		storageChar = new char[rowN][colN];
		for (int r = 0; r < storage.length; r++) {
			for (int c = 0; c < storage[0].length(); c++) {
				storageChar[r][c] = storage[r].charAt(c);
			}

		}

		for (String req : requests) {
			char reqAlpha = req.charAt(0);
			switch (req.length()) {
			case 1: // 지게차

				ArrayDeque<int[]> queue = new ArrayDeque<int[]>();
				for (int r = 0; r < storage.length; r++) {
					for (int c = 0; c < storage[0].length(); c++) {
						if (storageChar[r][c] == reqAlpha) {
							for (int dIdx = 0; dIdx < 4; dIdx++) {
								int nr = r + dr[dIdx];
								int nc = c + dc[dIdx];
								if (nr < 0 || nc < 0 || nr >= rowN || nc >= colN) {
									queue.offer(new int[] { r, c });
									break;
								} else if (!Character.isAlphabetic(storageChar[nr][nc])) {
									if (isWallByBFS(nr, nc)) {
										queue.offer(new int[] { r, c });
										break;
									}
								}
							}
						}
					}
				}

				while (!queue.isEmpty()) {
					int[] poll = queue.poll();
					storageChar[poll[0]][poll[1]] = TEMP_CHK;
				}
				break;
			case 2: // 크레인
				for (int r = 0; r < storage.length; r++) {
					for (int c = 0; c < storage[0].length(); c++) {
						if (storageChar[r][c] == reqAlpha) {
							storageChar[r][c] = TEMP_CHK;
						}
					}
				}
				break;
			}

		}

		int answer = 0;

		for (int r = 0; r < storageChar.length; r++) {
			for (int c = 0; c < storageChar[0].length; c++) {
				if (Character.isAlphabetic(storageChar[r][c])) {
					answer++;
				}
			}
		}
		return answer;
	}

	boolean isWallByBFS(int r, int c) {
		int[][] visit = new int[rowN][colN];
		ArrayDeque<int[]> queue = new ArrayDeque<int[]>();
		queue.offer(new int[] { r, c });
		visit[r][c] = 1;

		while (!queue.isEmpty()) {
			int[] poll = queue.poll();
			int rr = poll[0];
			int cc = poll[1];

			for (int dIdx = 0; dIdx < 4; dIdx++) {
				int nr = rr + dr[dIdx];
				int nc = cc + dc[dIdx];
				if (nr < 0 || nc < 0 || nr >= rowN || nc >= colN) {
					return true;
				}
				if (Character.isAlphabetic(storageChar[nr][nc]) || visit[nr][nc] == 1) {
					continue;
				}

				queue.offer(new int[] { nr, nc });
				visit[nr][nc] = 1;
			}

		}

		return false;

	}
}