import java.util.Arrays;
import java.util.PriorityQueue;

class UserSolution {
	int N;
	int maxStamina;
	int mMap[][]; // Row, Col로 길(0), 벽(1) 조회
	int activeGateMap[][]; // Row, Col로 현재 활성화된 Gate ID 조회 없으면 0
	int gateRow[] = new int[201]; // Gate ID로 게이트의 Row 조회 (삭제된 값과 이전 테케 값도 남음)
	int gateCol[] = new int[201]; // Gate ID로 게이트의 Col 조회 (삭제된 값도 이전 테케 값도 남음)
	int graph[][]; // ID, ID를 키로 게이트간 간선(이동거리)을 저장하는 그래프

	boolean isActiveGate(int mGateID) {
		return activeGateMap[gateRow[mGateID]][gateCol[mGateID]] > 0;
	}

	void init(int N, int mMaxStamina, int mMap[][]) {
		this.N = N;
		this.maxStamina = mMaxStamina;
		this.mMap = mMap;
		this.activeGateMap = new int[N][N];
		this.visitMap = new int[N][N];
		this.graph = new int[201][201];
		return;
	}

	void addGate(int mGateID, int mRow, int mCol) {
		// mGateID와 현재 활성화된 게이트들간의 간선부터 이어주기
		gateRow[mGateID] = mRow;
		gateCol[mGateID] = mCol;
		writeGraphByBFS(mGateID);
		activeGateMap[mRow][mCol] = mGateID;

		return;
	}

	int[] dr = { 0, 0, 1, -1 };
	int[] dc = { 1, -1, 0, 0 };

	int[][] visitMap;
	int visitChkVal = 0; // visitMap의 값이 visitChk와 같으면 방문한 것

	boolean isVisited(int Row, int Col) {
		return visitMap[Row][Col] == visitChkVal;
	}

	void setVisited(int Row, int Col) {
		visitMap[Row][Col] = visitChkVal;
	}

	int[][] deque = new int[350 * 350][3];

	void writeGraphByBFS(int mGateID) {
		// deque 초기화
		visitChkVal++;
		int dqFirst = 0;
		int dqLast = 0;

		int startR = gateRow[mGateID];
		int startC = gateCol[mGateID];

		// offer
		deque[dqLast][0] = startR;
		deque[dqLast][1] = startC;
		deque[dqLast++][2] = 0;
		setVisited(startR, startC);

		while (dqFirst != dqLast) {
			// poll
			int pollR = deque[dqFirst][0];
			int pollC = deque[dqFirst][1];
			int pollDist = deque[dqFirst++][2];

			// 다음 이동 불가(체력 고갈)
			if (pollDist >= maxStamina) {
				continue;
			}

			for (int dCnt = 0; dCnt < 4; dCnt++) {
				int nextR = pollR + dr[dCnt];
				int nextC = pollC + dc[dCnt];
				int nextDist = pollDist + 1;

				// 장외 or 벽 or 방문한곳 인 경우
				if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= N || mMap[nextR][nextC] == 1
						|| isVisited(nextR, nextC)) {
					continue;
				}

				// 도착한 곳이 게이트라면 그래프 기록
				if (activeGateMap[nextR][nextC] > 0) {
					int toGateID = activeGateMap[nextR][nextC];
					graph[mGateID][toGateID] = nextDist;
					graph[toGateID][mGateID] = nextDist;
				}

				// offer
				deque[dqLast][0] = nextR;
				deque[dqLast][1] = nextC;
				deque[dqLast++][2] = nextDist;
				setVisited(nextR, nextC);
			}
		}

	}

	void removeGate(int mGateID) {
		activeGateMap[gateRow[mGateID]][gateCol[mGateID]] = 0;
		return;
	}

	final int INFINITY = 100_000_000;

	int getMinTime(int mStartGateID, int mEndGateID) {
		int dist[] = new int[201]; // mStartGateID와의 거리를 기록
		Arrays.fill(dist, INFINITY);
		dist[mStartGateID] = 0;

		// 최소 거리가를 가진 게이트가 poll되는 우선순위 큐 {거리, ID}
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
		pq.offer(new int[] {0, mStartGateID});

		while (!pq.isEmpty()) {
			int[] polled = pq.poll();
			int polledID = polled[1];
			int polledDist = polled[0];

			// queue에 들어있는 값이 이미 기록된 값보다 큰 경우 스킵
			if (polledDist > dist[polledID]) {
				continue;
			}

			dist[polledID] = polledDist;

			if (polledID == mEndGateID) {
				return polledDist;
			}

			for (int nextID = 1; nextID < 201; nextID++) {
				// poll된 게이트와 간선으로 연결된 활성 게이트라면
				if (graph[polledID][nextID] > 0 && isActiveGate(nextID)) {
					// 간선 사이 거리
					int pollToNextdist = graph[polledID][nextID];
					pq.offer(new int[] {polledDist + pollToNextdist, nextID});

				}
			}
		}

		return -1;
	}
}
