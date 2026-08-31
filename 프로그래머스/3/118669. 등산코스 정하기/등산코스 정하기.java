import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {

	static class Node {
		int to, weight;

		public Node(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

	}

	int n;

	int[] summits;

	List<List<Node>> graph;

	final int INFINITY = 20_000_000;

	boolean isSummit[];

	public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
		this.graph = new ArrayList<>();
		Arrays.sort(summits);
		this.summits = summits;

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		this.n = n;

		isSummit = new boolean[n + 1];
		for (int summit : summits) {
			isSummit[summit] = true;
		}

		for (int[] path : paths) {
			graph.get(path[0]).add(new Node(path[1], path[2]));
			graph.get(path[1]).add(new Node(path[0], path[2]));
		}

		int[] answer = dijkstra(gates);

		return answer;
	}

	int[] dijkstra(int[] gates) {
		int[] dist = new int[n + 1];
		Arrays.fill(dist, INFINITY);

		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> Integer.compare(a[0], b[0]));

		for (int gate : gates) {
			pq.offer(new int[] { 0, gate });
			dist[gate] = 0;
		}

		while (!pq.isEmpty()) {
			int[] pollNode = pq.poll();
			int pVal = pollNode[0];
			int pIdx = pollNode[1];

			if (dist[pIdx] < pVal) {
				continue;
			}

			if (isSummit[pIdx]) {
				continue;
			}
			dist[pIdx] = pVal;

			List<Node> nextNodes = graph.get(pIdx);
			for (Node nextNode : nextNodes) {
				int nextIdx = nextNode.to;

				int nextVal = Math.max(pVal, nextNode.weight);

				if (dist[nextIdx] > nextVal) {
					dist[nextIdx] = nextVal;
					pq.offer(new int[] { nextVal, nextIdx });
				}
			}

		}

		int answerSummit = 0;
		int answerWeight = Integer.MAX_VALUE;

		for (int summit : summits) {
			if (dist[summit] < answerWeight) {
				answerSummit = summit;
				answerWeight = dist[summit];
			}
		}

		return new int[] { answerSummit, answerWeight };

	}
}
