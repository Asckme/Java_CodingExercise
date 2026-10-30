package oct_thirty_2026;

import java.util.Scanner;

public class Main2 {

    /*
    假设maxn是单词中出现次数最多的字母的出现次数，minn是单词中出现次数最少的字母的出现次数，
    如果maxn-minn是一个质数，那么笨小猴就认为这是个Lucky Word，这样的单词很可能就是正确的答案。

    输入格式

    只有一行，是一个单词，其中只可能出现小写字母，并且长度小于100。

    输出格式

    共两行，第一行是一个字符串，假设输入的的单词是Lucky Word，那么输出“Lucky Word”，否则输出“No Answer”；
    第二行是一个整数，如果输入单词是Lucky Word，输出maxn-minn的值，否则输出0。

    样例输入

    error

    样例输出

    Lucky Word
    2
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s= sc.next();
        int[] ch = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ch[s.charAt(i)-'a']++;
        }

        int maxn = 0;
        int minn = Integer.MAX_VALUE;
        for(int i=0;i<26;i++){
            if(ch[i]>0){
                maxn = Math.max(maxn,ch[i]);
                minn = Math.min(minn,ch[i]);
            }
        }
        if(isPrime(maxn-minn)){
            System.out.println("Lucky Word");
            System.out.println(maxn-minn);
        }
        else {
            System.out.println("NO Answer");
            System.out.println(0);
        }
    }

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
