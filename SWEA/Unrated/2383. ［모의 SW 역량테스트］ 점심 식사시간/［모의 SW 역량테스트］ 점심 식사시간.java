import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[][] Area = new int[10][10];
	static int[][] stair = new int[2][2]; // [계단인덱스][좌표]
	static int[][] people = new int[10][2]; // [사람인덱스][좌표]
	static int[][] manhatan; // [계단인덱스][사람인덱스]
	static int peopleCnt;
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			answer = (int) 1e9;
			peopleCnt = 0;
			int stairIdx = 0;
			for (int r = 0; r < N; r++) {
				StringTokenizer tk = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					int num = Integer.parseInt(tk.nextToken());
					Area[r][c] = num;
					if (num > 1) {
						stair[stairIdx][0] = r;
						stair[stairIdx++][1] = c;
					} else if (num == 1) {
						people[peopleCnt][0] = r;
						people[peopleCnt++][1] = c;
					}
				}
			}

			manhatan = new int[2][peopleCnt];
			for (int i = 0; i < peopleCnt; i++) {
				manhatan[0][i] = Math.abs(people[i][0] - stair[0][0]) + Math.abs(people[i][1] - stair[0][1]);
				manhatan[1][i] = Math.abs(people[i][0] - stair[1][0]) + Math.abs(people[i][1] - stair[1][1]);
			}

			dfs(0, new boolean[peopleCnt]);

			sb.append("#" + test_case + " " + (answer + 1) + "\n");
		}
		System.out.println(sb.toString());
	}

	public static void dfs(int depth, boolean[] isStair1Sel) {
		if (depth >= peopleCnt) {
			answer = Math.min(answer, getTime(isStair1Sel));
			return;
		}
		isStair1Sel[depth] = true;
		dfs(depth + 1, isStair1Sel);
		isStair1Sel[depth] = false;
		dfs(depth + 1, isStair1Sel);

	}

	// 선택한 계단 정보로 두 계단 이용시 걸리는 총 시간
	public static int getTime(boolean[] isStair1Sel) {
		int s1Len = 0;
		for (boolean b : isStair1Sel) {
			if (b)
				s1Len++;
		}
		int s2Len = peopleCnt - s1Len;

		int[] s1 = new int[s1Len];
		int[] s2 = new int[s2Len];

		int s1Idx = 0;
		int s2Idx = 0;
		for (int i = 0; i < peopleCnt; i++) {
			if (isStair1Sel[i]) {
				s1[s1Idx++] = manhatan[0][i];
			} else {
				s2[s2Idx++] = manhatan[1][i];
			}
		}

		int t1 = getSingleTime(s1, Area[stair[0][0]][stair[0][1]]);
		int t2 = getSingleTime(s2, Area[stair[1][0]][stair[1][1]]);
		return Math.max(t1, t2);
	}

	// 계단 하나 기준 걸리는 시간 구하기
	public static int getSingleTime(int[] manhatan, int stairVal) {
		Arrays.sort(manhatan);
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
		int ans = 0;
		for (int i = 0; i < manhatan.length; i++) {
			if (pq.size() == 3) {
				int before = pq.poll();
				int delay = (before - manhatan[i]) > 0 ? (before - manhatan[i]) : 0;
				manhatan[i] += delay;
			}
			manhatan[i] += stairVal;
			pq.offer(manhatan[i]);
			ans = manhatan[i];
		}

		return ans;
	}
}
