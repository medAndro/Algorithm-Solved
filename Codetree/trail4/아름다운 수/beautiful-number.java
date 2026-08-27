import java.util.Scanner;

public class Main {
    static int ans;
    static int[] arr;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main.n = sc.nextInt();
        arr = new int[n];
        ans = 0;

        permu(0);
        System.out.println(ans);
    }

    static void permu(int idx) {
        if (idx == n) {
            if (isBeautifulNum(arr)) {
                ans++;
            }

            return;
        }

        for (int i = 1; i <= 4; i++) {
            arr[idx] = i;
            permu(idx + 1);
        }
    }

    static boolean isBeautifulNum(int[] arr) {
        int chain = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] != arr[i]) {
                if (chain % arr[i - 1] != 0) {
                    return false;
                }
                chain = 1;
            } else {
                chain++;
            }
        }

        if (chain % arr[n - 1] != 0) {
            return false;
        }
        return true;
    }
}