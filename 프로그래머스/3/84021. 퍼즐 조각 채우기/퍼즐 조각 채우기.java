
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class Solution {
	class Block {
		public int rLen;
		public int cLen;
		public int[][] blockTiles;
		public int size;

		Block(List<int[]> tiles, int maxR, int maxC, int minR, int minC) {
			rLen = maxR - minR + 1;
			cLen = maxC - minC + 1;

			blockTiles = new int[rLen][cLen];

			for (int[] tile : tiles) {
				int r = tile[0] - minR;
				int c = tile[1] - minC;
				blockTiles[r][c] = 1;
				size++;
			}
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Block other = (Block) obj;

			boolean answer = false;

			if (rLen == other.rLen && cLen == other.cLen) {
				boolean same1 = true;// 0도 회전
				boolean same2 = true;// 180도 회전
				for (int r = 0; r < rLen; r++) {
					for (int c = 0; c < cLen; c++) {
						if (blockTiles[r][c] != other.blockTiles[r][c]) {
							same1 = false;
						}
						if (blockTiles[r][c] != other.blockTiles[rLen - 1 - r][cLen - 1 - c]) {
							same2 = false;
						}
					}
				}

				answer = (answer || (same1 || same2));
			}

			if (rLen == other.cLen && cLen == other.rLen) {
				boolean same1 = true;// 90도 회전
				boolean same2 = true;// 270도 회전
				for (int r = 0; r < rLen; r++) {
					for (int c = 0; c < cLen; c++) {
						if (blockTiles[r][c] != other.blockTiles[c][rLen - 1 - r]) {
							same1 = false;
						}
						if (blockTiles[r][c] != other.blockTiles[cLen - 1 - c][r]) {
							same2 = false;
						}
					}
				}
				answer = (answer || (same1 || same2));
			}

			return answer;
		}

	}

	int[] dr = { -1, 1, 0, 0 };
	int[] dc = { 0, 0, -1, 1 };

	public Block getBlock(int[][] board, int initR, int initC, int blockVal) {
		List<int[]> tiles = new ArrayList<>();
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		int[] initTile = new int[] { initR, initC };

		queue.offer(initTile);
		board[initR][initC] = blockVal - 1;
		tiles.add(initTile);
		int minR = initR;
		int minC = initC;

		int maxR = initR;
		int maxC = initC;

		while (!queue.isEmpty()) {
			int[] pollTile = queue.poll();
			int pr = pollTile[0];
			int pc = pollTile[1];

			for (int d = 0; d < 4; d++) {
				int rr = pr + dr[d];
				int cc = pc + dc[d];

				if (rr >= 0 && cc >= 0 && rr < board.length && cc < board[0].length && board[rr][cc] == blockVal) {
					int[] nextTile = new int[] { rr, cc };
					queue.offer(nextTile);
					board[rr][cc] = blockVal - 1;
					tiles.add(nextTile);

					minR = Math.min(minR, rr);
					minC = Math.min(minC, cc);
					maxR = Math.max(maxR, rr);
					maxC = Math.max(maxC, cc);

				}
			}
		}

		Block t1 = new Block(tiles, maxR, maxC, minR, minC);

		return new Block(tiles, maxR, maxC, minR, minC);
	}

	public int solution(int[][] game_board, int[][] table) {
		List<Block> boardBlocks = new ArrayList<>();
		List<Block> tableBlocks = new ArrayList<>();

		for (int r = 0; r < game_board.length; r++) {
			for (int c = 0; c < game_board[0].length; c++) {
				if (game_board[r][c] == 0) {
					boardBlocks.add(getBlock(game_board, r, c, 0));
				}
			}
		}

		for (int r = 0; r < table.length; r++) {
			for (int c = 0; c < table[0].length; c++) {
				if (table[r][c] == 1) {
					tableBlocks.add(getBlock(table, r, c, 1));
				}
			}
		}

		int answer = 0;

		for (Block tb : tableBlocks) {
			for (int i = 0; i < boardBlocks.size(); i++) {
				if (tb.equals(boardBlocks.get(i))) {
					answer += tb.size;
					boardBlocks.remove(i);
					break;
				}
			}
		}

		return answer;
	}
}