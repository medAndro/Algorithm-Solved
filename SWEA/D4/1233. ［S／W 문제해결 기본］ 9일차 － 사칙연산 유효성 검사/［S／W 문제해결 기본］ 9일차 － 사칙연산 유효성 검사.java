import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Solution {

	public static class Val {
		int valNum;
		char valChar;
		boolean isNum;

		public Val(String val) {
			super();
			char valChar = val.charAt(0);

			if ('0' <= valChar && valChar <= '9') {
				isNum = true;
				valNum = Character.getNumericValue(valChar);
			} else {
				this.valChar = valChar;
			}
		}

		@Override
		public String toString() {
			return "Val [valNum=" + valNum + ", valChar=" + valChar + ", isNum=" + isNum + "]";
		}

	}

	public static class Node {
		int id;
		Val value;
		int leftId;
		int rightId;

		public Node(int id, Val value) {
			super();
			this.id = id;
			this.value = value;
		}

		public boolean isLeaf() {
			if (leftId == 0 && rightId == 0) {
				return true;
			}
			return false;
		}

		@Override
		public String toString() {
			return "Node [id=" + id + ", value=" + value + ", leftId=" + leftId + ", rightId=" + rightId + "]";
		}

	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine()); // 정점의 수
			Map<Integer, Node> nodes = new HashMap<>(N);

			for (int i = 1; i <= N; i++) {
				String readStr = br.readLine();
				StringTokenizer tk = new StringTokenizer(readStr);

				int nodeId = Integer.parseInt(tk.nextToken());
				Val value = new Val(tk.nextToken());
				Node node = new Node(nodeId, value);
				if (tk.hasMoreTokens()) {
					int leftId = Integer.parseInt(tk.nextToken());
					node.leftId = leftId;
				}

				if (tk.hasMoreTokens()) {
					int rightId = Integer.parseInt(tk.nextToken());
					node.rightId = rightId;
				}

				nodes.put(nodeId, node);
			}

			ArrayDeque<Val> postOrderVals = new ArrayDeque<>();
			postorder(nodes.get(1), nodes, postOrderVals);

			int answer = 1;

			ArrayDeque<Val> stack = new ArrayDeque<>();
			while (!postOrderVals.isEmpty()) {
				Val pop = postOrderVals.pollFirst();

				// 숫자
				if (pop.isNum) {
					stack.addFirst(pop);
				} else { // 연산자
					if (stack.size() < 2) {
						answer = 0;
						break;
					}

					Val left = stack.pollFirst();
					Val right = stack.pollFirst();
					if (left.isNum && right.isNum) { // 가능한 연산이라면
						stack.addFirst(left); // 진짜 연산대신 임의의 숫자
					} else { // 불가능한 연산일 경우
						answer = 0;
						break;
					}
				}
			}

			if (stack.size() != 1) {
				answer = 0;
			}
			sb.append("#");
			sb.append(test_case);
			sb.append(" ");
			sb.append(answer);
			sb.append("\n");

		}
		System.out.println(sb.toString());
	}

	public static void postorder(Node n, Map<Integer, Node> nodes, ArrayDeque<Val> postOrderVals) {
		if (n != null) {
			postorder(nodes.getOrDefault(n.leftId, null), nodes, postOrderVals);
			postorder(nodes.getOrDefault(n.rightId, null), nodes, postOrderVals);
			postOrderVals.addLast(n.value);
		}
	}
}
