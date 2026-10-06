//Prim 풀이
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	static int N;
	static double[][] islands;
	static double cost;
	static double answer;
	static boolean visited[];
	static double[] minDist;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			islands = new double[N][2];
			visited = new boolean[N];
			minDist = new double[N];

			StringTokenizer tk1 = new StringTokenizer(br.readLine());
			StringTokenizer tk2 = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				islands[i][0] = Double.parseDouble(tk1.nextToken());
				islands[i][1] = Double.parseDouble(tk2.nextToken());
			}
			cost = Double.parseDouble(br.readLine());
			answer = 0;
			visited[0] = true;

			for (int i = 1; i < N; i++) {
				double x = islands[i][0] - islands[0][0];
				double y = islands[i][1] - islands[0][1];
				double dist = x * x + y * y;
				minDist[i] = dist;
			}
			for (int i = 1; i < N; i++) {
				double minVal = Double.POSITIVE_INFINITY;
				int minIdx = 0;
				for (int v = 1; v < N; v++) {
					if (visited[v]) {
						continue;
					}

					if (minVal > minDist[v]) {
						minIdx = v;
						minVal = minDist[v];
					}

				}
				visited[minIdx] = true;
				answer += cost * minVal;
				for (int v = 0; v < N; v++) {
				    if (visited[v]) {
				        continue;
				    }
				    double x = islands[minIdx][0] - islands[v][0];
				    double y = islands[minIdx][1] - islands[v][1];
				    double dist = x * x + y * y;

				    minDist[v] = Math.min(minDist[v], dist);
				}
			}

			sb.append("#" + test_case + " " + Math.round(answer) + "\n");
		}
		System.out.println(sb.toString());
	}
}