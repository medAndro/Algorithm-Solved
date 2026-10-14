import java.io.*;
import java.util.*;

public class Main {
	static int V, E;
	static List<Edge>[] graph;
	static boolean[] isSelectedV;

	static class Edge {
		int to, dist;

		public Edge(int to, int dist) {
			super();
			this.to = to;
			this.dist = dist;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		V = Integer.parseInt(tk.nextToken());
		E = Integer.parseInt(tk.nextToken());
		isSelectedV = new boolean[V + 1];
		graph = new ArrayList[V + 1];

		for (int i = 1; i <= V; i++) {
			graph[i] = new ArrayList<>();
		}

		PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.dist, b.dist));

		for (int i = 0; i < E; i++) {
			tk = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(tk.nextToken());
			int B = Integer.parseInt(tk.nextToken());
			int C = Integer.parseInt(tk.nextToken());

			graph[A].add(new Edge(B, C));
			graph[B].add(new Edge(A, C));
		}

		isSelectedV[1] = true;
		int cnt = 1;
		Long answer = 0l;
		for (Edge e : graph[1]) {
			pq.add(e);
		}

		while (cnt < V) {
			Edge pE = pq.poll();
			if (isSelectedV[pE.to]) {
				continue;
			}

			isSelectedV[pE.to] = true;
			answer += pE.dist;
			cnt++;

			for (Edge e : graph[pE.to]) {
				pq.add(e);
			}
		}

		System.out.println(answer);
	}
}