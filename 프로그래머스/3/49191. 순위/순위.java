import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

class Solution {
	Set<Integer>[] loses; // 인덱스 선수에게 진 선수의 인덱스들 set
	Set<Integer>[] wins; // 인덱스 선수에게 이긴 선수의 인덱스들 set
	int n;

	public int solution(int n, int[][] results) {
		loses = new HashSet[n + 1];
		wins = new HashSet[n + 1];
		for (int i = 1; i <= n; i++) {
			loses[i] = new HashSet<>();
			wins[i] = new HashSet<>();
		}
		this.n = n;
		int answer = 0;

		for (int r[] : results) {
			int loser = r[0];
			int winner = r[1];
			wins[winner].add(loser);
			loses[loser].add(winner);
		}

		for (int i = 1; i <= n; i++) {
			bfsWinCnt(i);
			bfsLoseCnt(i);

		}

		for (int i = 1; i <= n; i++) {
			int winLoseCnt = loses[i].size() + wins[i].size();
			if (winLoseCnt == n - 1) {
				answer++;
			}
		}

		return answer;
	}

	// 이긴 횟수를 재귀적 증가
	public void bfsWinCnt(int target) {
		boolean[] visited = new boolean[n + 1];
		ArrayDeque<Integer> winnerDq = new ArrayDeque<>();
		visited[target] = true;
		for (int winner : wins[target]) {
			winnerDq.add(winner);
		}
//		4,3,1 -> 2(타겟)를 이긴사람	
//		4,3,1을 이긴 사람은 2를 이긴것과 같다.

		while (!winnerDq.isEmpty()) {
			int pollWinner = winnerDq.poll();
			for (int winner : wins[pollWinner]) {

				if (visited[winner]) {
					continue;
				}

				// 431을 이긴 사람 -> 2를 이긴 사람
				wins[target].add(winner);
				winnerDq.add(winner);
				visited[winner] = true;
			}
		}
	}

	// 진 횟수를 재귀적 증가
	public void bfsLoseCnt(int target) {
		boolean[] visited = new boolean[n + 1];
		ArrayDeque<Integer> loserDq = new ArrayDeque<>();
		visited[target] = true;
		for (int loser : loses[target]) {
			loserDq.add(loser);
		}
//		5 -> 2(타겟)에게 진 사람	
//		5에게 진 사람은 2에게 진것과 같다.
		while (!loserDq.isEmpty()) {
			int pollLoser = loserDq.poll();

			for (int loser : loses[pollLoser]) {
				if (visited[loser]) {
					continue;
				}
//				5에게 진 사람들 -> 2에게 진 사람
				loses[target].add(loser);
				loserDq.add(loser);
				visited[loser] = true;
			}
		}
	}

}