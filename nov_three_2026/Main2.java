package nov_three_2026;

import java.io.*;
import java.util.*;

public class Main2 {
    // 计算直角三角形斜边长：sqrt(dx^2 + dy^2)
    static double dist(double dx, double dy) {
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static void main(String[] args) throws IOException {
        // 使用 BufferedReader 提高读取速度
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        double d = Double.parseDouble(st.nextToken());
        double w = Double.parseDouble(st.nextToken());

        double[] u = new double[L + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= L; i++) {
            u[i] = Double.parseDouble(st.nextToken());
        }

        double[] v = new double[R + 1];
        st = new StringTokenizer(br.readLine());
        for (int j = 1; j <= R; j++) {
            v[j] = Double.parseDouble(st.nextToken());
        }

        // dp[i][j][0] 表示停在左边第 i 幅，dp[i][j][1] 表示停在右边第 j 幅
        double[][][] dp = new double[L + 1][R + 1][2];
        double INF = 1e18; // 定义无穷大

        // 1. 初始化所有状态为无穷大
        for (int i = 0; i <= L; i++) {
            for (int j = 0; j <= R; j++) {
                dp[i][j][0] = INF;
                dp[i][j][1] = INF;
            }
        }

        // 2. 起点出发的边界状态（第一步只能去左1，或者去右1）
        double halfW = w / 2.0;
        dp[1][0][0] = dist(u[1], halfW);
        dp[0][1][1] = dist(v[1], halfW);

        // 3. 状态转移
        for (int i = 0; i <= L; i++) {
            for (int j = 0; j <= R; j++) {
                // 转移到左边第 i 幅画
                if (i > 0) {
                    // 从左边第 i-1 幅走过来 (要求 i >= 2)
                    if (i > 1) {
                        dp[i][j][0] = Math.min(dp[i][j][0], dp[i - 1][j][0] + (u[i] - u[i - 1]));
                    }
                    // 从右边第 j 幅斜跨过来 (要求 j >= 1)
                    if (j > 0) {
                        dp[i][j][0] = Math.min(dp[i][j][0], dp[i - 1][j][1] + dist(u[i] - v[j], w));
                    }
                }

                // 转移到右边第 j 幅画
                if (j > 0) {
                    // 从右边第 j-1 幅走过来 (要求 j >= 2)
                    if (j > 1) {
                        dp[i][j][1] = Math.min(dp[i][j][1], dp[i][j - 1][1] + (v[j] - v[j - 1]));
                    }
                    // 从左边第 i 幅斜跨过来 (要求 i >= 1)
                    if (i > 0) {
                        dp[i][j][1] = Math.min(dp[i][j][1], dp[i][j - 1][0] + dist(v[j] - u[i], w));
                    }
                }
            }
        }

        // 4. 汇总终点：从左L到终点，或者从右R到终点
        double ansLeft = dp[L][R][0] + dist(d - u[L], halfW);
        double ansRight = dp[L][R][1] + dist(d - v[R], halfW);
        double ans = Math.min(ansLeft, ansRight);

        System.out.printf("%.2f\n", ans);
    }
}