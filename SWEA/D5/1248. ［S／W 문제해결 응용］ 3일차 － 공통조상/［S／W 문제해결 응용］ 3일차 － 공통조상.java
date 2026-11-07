import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
	static int V, E, N, M;

	static int[] root; // 인덱스로 접근했을떄 해당 값의 루트 저장
	static List<Integer>[] graph; // 인덱스로 접근했을 떄, 해당 값의 자식들 저장

	static int treeSize; // 공통 조상을 root로 하는 트리의 크기

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			treeSize = 0;
			StringTokenizer tk = new StringTokenizer(br.readLine());
			V = Integer.parseInt(tk.nextToken());
			E = Integer.parseInt(tk.nextToken());
			N = Integer.parseInt(tk.nextToken());
			M = Integer.parseInt(tk.nextToken());

			root = new int[V + 1];
			graph = new ArrayList[V + 1];
			for (int i = 01; i <= V; i++) {
				graph[i] = new ArrayList<>();
			}

			tk = new StringTokenizer(br.readLine());

			for (int ei = 0; ei < E; ei++) {
				int r = Integer.parseInt(tk.nextToken());
				int c = Integer.parseInt(tk.nextToken());
				root[c] = r;
				graph[r].add(c);

			}

			boolean[] visited = new boolean[V + 1];
			visited[1] = true;

			int cur = N;
			while (cur > 1) {
				visited[cur] = true;
				cur = root[cur];
			}

			cur = M;
			while (cur > 1) {
				if (visited[cur])
					break;
				cur = root[cur];
			}

			// 공통 조상 번호
			int sameRoot = cur;
			bfs(sameRoot);

			sb.append("#" + test_case + " " + sameRoot + " " + treeSize + "\n");
		}
		System.out.println(sb.toString());
	}

	static void bfs(int root) {
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		dq.offer(root);

		while (!dq.isEmpty()) {
			treeSize++;
			int p = dq.poll();

			for (int n : graph[p]) {
				dq.offer(n);
			}
		}
	}
}
