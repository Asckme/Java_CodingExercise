package oct_twenty_eight_2026;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        String A = sc.nextLine();
        String B = sc.nextLine();

        int n =A.length();
        int m=B.length();

        char[] s1= A.toCharArray();
        char[] s2= B.toCharArray();

        // dp[i][j] 表示将 A 的前 i 个字符变为 B 的前 j 个字符的最少操作次数
        //多加1是因为第0行和第0列，是用来处理空串情况，所以一共有n+1行
        int[][] dp = new int[n+1][m+1];

        // 1. 初始化边界：变为空串或从空串变来
        //dp[0][j] 代表：空串变成长度为 j 的 B 字符串。
        //
        //dp[i][0] 代表：长度为 i 的 A 字符串变成空串。
        //
        //dp[i][j] 代表：长度为 i 的 A 字符串，变成长度为 j 的 B 字符串。
        for (int i = 0; i <=n; i++)dp[i][0] = i;
        for (int j = 0; j <=m; j++)dp[j][0] = j;


        // 2. 状态转移填表
        for(int i=1;i<=n;i++){//为什么从1开始，因为从0开始的边界情况已经初始化了
            for(int j=1;j<=m;j++){
                if(s1[i-1]==s2[j-1]){
                    dp[i][j] = dp[i-1][j-1];//字符相同，就不操作
                }
                else {
                    // 字符不同，在
                    // 删(dp[i-1][j]) ,i中删了一个元素，原列变短了，操作加1，就要看之前进行的操作次数
                    // 插(dp[i][j-1])、
                    // 改(dp[i-1][j-1])
                    // 中取最小值 + 1
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}
