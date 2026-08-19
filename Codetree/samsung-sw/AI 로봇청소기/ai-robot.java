import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] dustMap;
    static int[][] robotMap;
    static Robot[] robots;

    public static class Robot {
        int r;
        int c;

        Robot(int r, int c) {
            this.r = r;
            this.c = c;
            robotMap[r][c] = 1;
        }

        void clean() {
            int[] dr = { 0, -1, 0, 0, 1 };
            int[] dc = { 0, 0, -1, 1, 0 };

            int sum = 0;
            for (int dIdx = 0; dIdx < 5; dIdx++) {
                int rr = r + dr[dIdx];
                int cc = c + dc[dIdx];

                if (rr >= 0 && cc >= 0 && rr < dustMap.length && cc < dustMap.length && dustMap[rr][cc] != -1) {
                    sum += Math.min(dustMap[rr][cc], 20);
                }
            }

            int[] rmdr = { 0, -1, 0, 1 };
            int[] rmdc = { -1, 0, 1, 0 };

            long maxDust = 0;
            int maxIdx = 0;
            for (int rmdIdx = 0; rmdIdx < 4; rmdIdx++) {
                int rr = r + rmdr[rmdIdx];
                int cc = c + rmdc[rmdIdx];

                int rmVal = 0;
                if (rr >= 0 && cc >= 0 && rr < dustMap.length && cc < dustMap.length && dustMap[rr][cc] != -1) {
                    rmVal = Math.min(dustMap[rr][cc], 20);
                }
                if (maxDust < sum - rmVal) {
                    maxDust = sum - rmVal;
                    maxIdx = rmdIdx;
                }
            }

            int rmr = r + rmdr[maxIdx];
            int rmc = c + rmdc[maxIdx];
            if (rmr >= 0 && rmc >= 0 && rmr < dustMap.length && rmc < dustMap.length && dustMap[rmr][rmc] != -1) {
                dustMap[rmr][rmc] += 20;
            }
            for (int dIdx = 0; dIdx < 5; dIdx++) {
                int rr = r + dr[dIdx];
                int cc = c + dc[dIdx];

                if (rr >= 0 && cc >= 0 && rr < dustMap.length && cc < dustMap.length && dustMap[rr][cc] != -1) {
                    dustMap[rr][cc] -= 20;
                    dustMap[rr][cc] = Math.max(dustMap[rr][cc], 0);
                }
            }

        }

        void move() {
            int[] dr = { -1, 0, 0, 1 };
            int[] dc = { 0, -1, 1, 0 };
            int[][] dist = new int[dustMap.length][dustMap.length];
            ArrayDeque<int[]> queue = new ArrayDeque<>();
            queue.offer(new int[] { r, c });
            dist[r][c] = 1;
            int foundDustLen = Integer.MAX_VALUE;
            ArrayList<int[]> candidate = new ArrayList<>();

            while (!queue.isEmpty()) {
                int[] poll = queue.poll();
                int rr = poll[0];
                int cc = poll[1];

                if (dustMap[rr][cc] > 0 && foundDustLen == Integer.MAX_VALUE) {
                    foundDustLen = dist[rr][cc];
                }

                if (dustMap[rr][cc] > 0 && dist[rr][cc] == foundDustLen) {
                    candidate.add(new int[] { rr, cc });
                }

                if (dist[rr][cc] + 1 > foundDustLen) {
                    continue;
                }

                for (int dIdx = 0; dIdx < 4; dIdx++) {
                    int rrr = rr + dr[dIdx];
                    int ccc = cc + dc[dIdx];

                    if (rrr >= 0 && ccc >= 0 && rrr < dustMap.length && ccc < dustMap.length && dustMap[rrr][ccc] != -1
                            && dist[rrr][ccc] == 0 && robotMap[rrr][ccc] == 0) {
                        dist[rrr][ccc] = dist[rr][cc] + 1;

                        queue.offer(new int[] { rrr, ccc });
                    }
                }

            }

            if (candidate.isEmpty()) {
                return;
            }

            int minr = Integer.MAX_VALUE;
            int minc = Integer.MAX_VALUE;
            for (int[] c : candidate) {
                minr = Math.min(minr, c[0]);
            }
            for (int[] c : candidate) {
                if (c[0] == minr) {
                    minc = Math.min(minc, c[1]);
                }
            }

            robotMap[r][c] = 0;
            r = minr;
            c = minc;
            robotMap[r][c] = 1;
        }
    }

    static void addDust() {
        for (int r = 0; r < dustMap.length; r++) {
            for (int c = 0; c < dustMap.length; c++) {
                if (dustMap[r][c] > 0) {
                    dustMap[r][c] += 5;
                }
            }
        }
    }

    static void extraDust() {
        int[] dr = { -1, 0, 0, 1 };
        int[] dc = { 0, -1, 1, 0 };

        ArrayList<int[]> temp = new ArrayList<>();

        for (int r = 0; r < dustMap.length; r++) {
            for (int c = 0; c < dustMap.length; c++) {
                if (dustMap[r][c] == 0) {
                    int localSum = 0;
                    for (int dIdx = 0; dIdx < 4; dIdx++) {
                        int rr = r + dr[dIdx];
                        int cc = c + dc[dIdx];

                        if (rr >= 0 && cc >= 0 && rr < dustMap.length && cc < dustMap.length && dustMap[rr][cc] != -1) {
                            localSum += dustMap[rr][cc];
                        }
                    }

                    temp.add(new int[] { r, c, localSum / 10 });
                }
            }
        }

        for (int[] t : temp) {
            dustMap[t[0]][t[1]] = t[2];
        }
    }

    static int totalDust() {
        int total = 0;
        for (int r = 0; r < dustMap.length; r++) {
            for (int c = 0; c < dustMap.length; c++) {
                if (dustMap[r][c] > 0) {
                    total += dustMap[r][c];
                }
            }
        }

        return total;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tk.nextToken());
        int k = Integer.parseInt(tk.nextToken());
        int l = Integer.parseInt(tk.nextToken());
        dustMap = new int[n][n];
        robotMap = new int[n][n];
        robots = new Robot[k];

        for (int r = 0; r < n; r++) {
            tk = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                dustMap[r][c] = Integer.parseInt(tk.nextToken());
            }
        }
        for (int i = 0; i < k; i++) {
            tk = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(tk.nextToken()) - 1;
            int c = Integer.parseInt(tk.nextToken()) - 1;
            robots[i] = new Robot(r, c);
        }

        for (int cnt = 0; cnt < l; cnt++) {
            for (Robot r : robots) {
                r.move();
            }

            for (Robot r : robots) {
                r.clean();
            }

            addDust();
            extraDust();
            System.out.println(totalDust());

        }

    }
}