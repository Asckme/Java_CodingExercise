package oct_twenty_nine_2026;

import java.util.Scanner;

public class Main1 {

    /*
        试写一个算法，识别字符序列是否为形如‘子序列1&子序列2’模式的字符序列，其中子序列2是子序列1的逆序列，
        0＜子序列字符串长度＜1000，且都为小写字母。输出YES或者NO。

        输入格式
        一行字符序列

        输出格式
        YES或NO

        样例输入
        hello&ollhe
        样例输出
        NO
     */

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()) {
            // 读取并去除所有可能存在的空格，防止隐藏字符干扰
            String s = sc.nextLine().trim().replace(" ","");
            if(s.isEmpty())continue;
        /*
        错误点：
        如果测试用例的输入根本不包含 & 符号（比如直接输入了 hello），
        那么 s.split("&") 返回的数组长度只有 1（只有索引 [0]）。
        此时强行去取 [1]，就会报 ArrayIndexOutOfBoundsException 异常，导致程序崩溃

        String s1 = s.split("&")[0];
        StringBuilder sb = new StringBuilder(s.split("&")[1]).reverse();
        System.out.println(s1.equals(sb.toString())?"YES":"NO");
         */

            //所以用subString截取
            int index = s.indexOf("&");
            if (index == -1||index==0||index==s.length()-1) {
                System.out.println("NO");
                continue;
            }
            String s1 = s.substring(0, index);
            String s2 = s.substring(index + 1);
            StringBuilder sb = new StringBuilder(s2).reverse();
            System.out.println(s1.contentEquals(sb) ? "YES" : "NO");
        }
    }
}
