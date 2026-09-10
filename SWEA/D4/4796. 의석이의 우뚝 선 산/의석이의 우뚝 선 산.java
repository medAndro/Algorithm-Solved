import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

class Solution {
	static long[] mountains;
	static int N, answer;

	// 우뚝 선 산 : 구간에서 단조 증가하다 정상을 만나면 단조 감소하는 형태
	public static void main(String args[]) throws Exception {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		st.nextToken();
		int T = (int) st.nval; // 테케수
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			st.nextToken();
			N = (int) st.nval;
			mountains = new long[N];
			for (int i = 0; i < N; i++) {
				st.nextToken();
				mountains[i] = (int) st.nval;
			}
			answer = 0;
			for (int i = 1; i < N - 1; i++) {
				if (mountains[i - 1] < mountains[i] && mountains[i] > mountains[i + 1]) {
					// 자신의 좌우보다 높은 구간내 정상일 경우
					answer += getLocalTopMountainCnt(i);
				}
			}
			sb.append("#" + test_case + " " + answer + "\n");
		}

		System.out.println(sb.toString());
	}

	static int getLocalTopMountainCnt(int topIdx) {
		int leftCnt = 0; // 정상으로부터 왼쪽으로 낮아지는 개수
		for (int i = topIdx - 1; i >= 0; i--) {
			if (mountains[i + 1] > mountains[i]) {
				leftCnt++;
			} else {
				break;
			}
		}

		int rightCnt = 0; // 정상으로부터 오른쪽으로 낮아지는 개수
		for (int i = topIdx + 1; i < N; i++) {
			if (mountains[i - 1] > mountains[i]) {
				rightCnt++;
			} else {
				break;
			}
		}

		return leftCnt * rightCnt;
	}
}