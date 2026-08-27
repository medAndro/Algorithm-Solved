import java.util.Scanner;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        permu(new int[n], 0, n, k);

        System.out.println(sb.toString());

    }

    static void permu(int[] arr, int idx, int n, int k) {
        if (idx == n) {
            for (int a : arr) {
                sb.append(a);
                sb.append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= k; i++) {
            arr[idx] = i;
            permu(arr, idx + 1, n, k);
        }

    }
}