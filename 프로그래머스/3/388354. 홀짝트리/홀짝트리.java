import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
	Map<Integer, List<Integer>> nodeMapList;
	int[] isOddEvenNode = new int[1000001];

	public int[] solution(int[] nodes, int[][] edges) {
		nodeMapList = new HashMap<>(nodes.length);
		for (int node : nodes) {
			if (!nodeMapList.containsKey(node)) {
				nodeMapList.put(node, new ArrayList<>());
			}
		}
		for (int[] edge : edges) {
			nodeMapList.get(edge[0]).add(edge[1]);
			nodeMapList.get(edge[1]).add(edge[0]);
		}

		int[] answer = { 0, 0 };

		for (int node : nodes) {
			setIsOddEven(node);
		}

		int[] visited = new int[1000001];
		for (int rootNode : nodes) {
			if (visited[rootNode] == 1) {
				continue;
			}

			// 각 노드가 루트가 아닐떄의 역홀짝노드수, 홀짝노드수 배열
			int[] oddevenCnt = new int[2];
			oddevenCnt[isOddEvenNode[rootNode]]++;
			visited[rootNode] = 1;

			ArrayDeque<int[]> deque = new ArrayDeque<>();
			for (int childNode : nodeMapList.get(rootNode)) {
				deque.offer(new int[] { childNode, rootNode });
				oddevenCnt[isOddEvenNode[childNode]]++;
				visited[childNode] = 1;
			}

			while (!deque.isEmpty()) {
				int[] pollNode = deque.poll();
				for (int childNode : nodeMapList.get(pollNode[0])) {
					if (pollNode[1] != childNode) {
						deque.offer(new int[] { childNode, pollNode[0] });
						oddevenCnt[isOddEvenNode[childNode]]++;
						visited[childNode] = 1;
					}
				}

			}

			// 루트가 아닌 역홀짝노드수가 1일떄 -> 해당노드가 루트가 되면 모두 홀짝노드
			if (oddevenCnt[0] == 1) {
				answer[0]++;
			}

			// 루트가 아닌 홀짝노드수가 1일떄 -> 해당노드가 루트가 되면 모두 역홀짝노드
			if (oddevenCnt[1] == 1) {
				answer[1]++;
			}

		}

		return answer;
	}

	// 1: 루트 아닐떄 홀짝노드 , 0: 루트 아닐떄 역홀짝노드
	public void setIsOddEven(int node) {
		int childLen = nodeMapList.get(node).size();
		childLen--;
		if (node % 2 != 0) {
			if (childLen % 2 != 0) {
				isOddEvenNode[node] = 1; // 홀수 홀짝노드
			}
		} else {
			if (childLen % 2 == 0) {
				isOddEvenNode[node] = 1; // 짝수 홀짝노드
			}
		}
	}
}