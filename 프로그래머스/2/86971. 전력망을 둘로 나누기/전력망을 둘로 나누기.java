import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
	Map<Integer, List<Integer>> network = new HashMap<>();

	public int solution(int n, int[][] wires) {

		for (int[] wire : wires) {
			network.computeIfAbsent(wire[0], k -> new ArrayList<>()).add(wire[1]);
			network.computeIfAbsent(wire[1], k -> new ArrayList<>()).add(wire[0]);
		}
		int answer = Integer.MAX_VALUE;
		for (int[] wire : wires) {
			int abs = Math.abs(cntNode(wire[0], wire[1]) - cntNode(wire[1], wire[0]));
			answer = Math.min(answer, abs);
		}

		return answer;
	}

	public int cntNode(int root, int except) {
		Set<Integer> visited = new HashSet<Integer>();
		visited.add(except);
		int cnt = 1;

		ArrayDeque<Integer> queue = new ArrayDeque<>();
		visited.add(root);
		queue.offer(root);

		while (!queue.isEmpty()) {
			int poll = queue.poll();

			List<Integer> nextNodes = network.get(poll);

			for (int node : nextNodes) {
				if (!visited.contains(node)) {
					cnt++;
					visited.add(node);
					queue.offer(node);
				}
			}

		}
		return cnt;
	}
}