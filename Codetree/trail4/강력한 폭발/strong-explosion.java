
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int answer;
    static int bombCnt;
    static int n;
    static List<int[]> bombLoc = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if (grid[i][j] == 1) {
                    bombLoc.add(new int[] { i, j });
                }
            }
        }

        bombCnt = bombLoc.size();
        permu(new int[bombLoc.size()], 0);

        System.out.println(answer);
    }

    static boolean isSafePos(int r, int c) {
        if (r >= 0 && c >= 0 && r < n && c < n) {
            return true;
        }
        return false;
    }

    static int[] dr1 = { -2, -1, 0, 1, 2 };
    static int[] dc1 = { 0, 0, 0, 0, 0 };

    static int[] dr2 = { -1, 0, 0, 0, 1 };
    static int[] dc2 = { 0, -1, 0, 1, 0 };

    static int[] dr3 = { -1, -1, 0, 1, 1 };
    static int[] dc3 = { -1, 1, 0, -1, 1 };

    static void permu(int[] visit, int idx) {
        if (idx == bombCnt) {
            boolean[][] bombMap = new boolean[n][n];

            for (int bombIdx = 0; bombIdx < bombCnt; bombIdx++) {
                int bombType = visit[bombIdx];
                int[] bomb = bombLoc.get(bombIdx);
                int bombR = bomb[0];
                int bombC = bomb[1];

                int[] dr = {};
                int[] dc = {};
                switch (bombType) {
                case 1:
                    dr = dr1;
                    dc = dc1;
                    break;
                case 2:
                    dr = dr2;
                    dc = dc2;
                    break;
                case 3:
                    dr = dr3;
                    dc = dc3;
                    break;
                }

                for (int i = 0; i < 5; i++) {
                    int rr = bombR + dr[i];
                    int cc = bombC + dc[i];

                    if (isSafePos(rr, cc)) {
                        bombMap[rr][cc] = true;
                    }
                }

                int localAns = 0;

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (bombMap[i][j] == true) {
                            localAns++;
                        }
                    }
                }
                answer = Math.max(localAns, answer);

            }
            return;
        }
        for (int bombType = 1; bombType <= 3; bombType++) {
            visit[idx] = bombType;
            permu(visit, idx + 1);
        }
    }
}