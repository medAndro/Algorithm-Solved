import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;
    static int sumArr;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        selectedArr = new int[n];
        arr = new int[n * 2];
        StringTokenizer tk = new StringTokenizer(br.readLine());

        for (int i = 0; i < n * 2; i++) {
            arr[i] = Integer.parseInt(tk.nextToken());
            sumArr += arr[i];
        }
        combi(0, 0);
        System.out.println(answer);
    }

    static int[] selectedArr;

    public static void combi(int depth, int start) {

        if (depth == n) {
            int s = 0;
            for (int a : selectedArr) {
                s += a;
            }
            answer = Math.min(answer, Math.abs((sumArr - s) - s));
            return;
        }

        for (int i = start; i < 2 * n; i++) {
            selectedArr[depth] = arr[i];
            combi(depth + 1, i + 1);
        }
    }

}