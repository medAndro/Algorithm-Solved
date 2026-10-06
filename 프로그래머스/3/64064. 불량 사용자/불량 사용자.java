import java.util.HashSet;
import java.util.Set;

class Solution {
	static String[] banned_id;
	static String[] user_id;
	static boolean[] visited;
	static boolean[][] candidate;
	static Set<Integer> answer;

	public int solution(String[] user_id, String[] banned_id) {
		this.user_id = user_id;
		this.banned_id = banned_id;
		this.visited = new boolean[user_id.length];
		candidate = new boolean[banned_id.length][user_id.length];
		answer = new HashSet<>();
		for (int i = 0; i < banned_id.length; i++) {
			String regex = banned_id[i].replace('*', '.');

			for (int j = 0; j < user_id.length; j++) {
				String id = user_id[j];
				if (id.matches(regex)) {
					candidate[i][j] = true;
				}

			}

		}
		dfs(0, 0);
		return answer.size();
	}

	static void dfs(int depth, int selected) {
		if (depth == banned_id.length) {
			answer.add(selected);
			return;
		}

		for (int i = 0; i < user_id.length; i++) {
			if (visited[i]) {
				continue;
			}

			if (candidate[depth][i]) {
				visited[i] = true;

				dfs(depth + 1, selected | 1 << i);
				visited[i] = false;
			}
		}
	}
}
