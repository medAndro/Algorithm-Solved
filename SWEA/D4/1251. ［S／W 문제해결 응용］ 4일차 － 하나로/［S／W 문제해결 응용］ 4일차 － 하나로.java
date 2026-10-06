import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Edge {
	int i, j;
	double len;

	public Edge(int i, int j, double[][] islands) {
		super();
		this.i = i;
		this.j = j;

		double x = islands[i][0] - islands[j][0];
		double y = islands[i][1] - islands[j][1];
		len = Math.hypot(x, y);

	}

}

class Solution {
	static int N;
	static double[][] islands;
	static int[] iUnion;
	static double cost;
	static double answer;
	static List<Edge> edges;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			islands = new double[N][2];
			iUnion = new int[N];

			StringTokenizer tk1 = new StringTokenizer(br.readLine());
			StringTokenizer tk2 = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				iUnion[i] = i;
				islands[i][0] = Double.parseDouble(tk1.nextToken());
				islands[i][1] = Double.parseDouble(tk2.nextToken());
			}
			cost = Double.parseDouble(br.readLine());
			answer = 0;
			edges = new ArrayList<Edge>();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (find(i) == find(j)) {
						continue;
					}
					edges.add(new Edge(i, j, islands));
				}
			}

			edges.sort((e1, e2) -> Double.compare(e1.len, e2.len));

			int cnt = 0;

			for (Edge e : edges) {
				if (cnt == N - 1) {
					break;
				}
				if (find(e.i) == find(e.j)) {
					continue;
				}
				union(e.i, e.j);
				answer += cost * e.len * e.len;

			}
			sb.append("#" + test_case + " " + Math.round(answer) + "\n");
		}
		System.out.println(sb.toString());
	}

	static int find(int i) {
		if (i == iUnion[i]) {
			return i;
		} else {
			iUnion[i] = find(iUnion[i]);
		}
		return iUnion[i];
	}

	static void union(int i, int j) {
		int ri = find(i);
		int rj = find(j);
		if (ri == rj) {
			return;
		}

		iUnion[ri] = rj;
	}
}