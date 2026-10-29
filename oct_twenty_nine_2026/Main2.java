package oct_twenty_nine_2026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

        对于一个字符串来说，定义一次循环移位操作为：将字符串的第一个字符移动到末尾形成新的字符串。
        给定两个字符串s1和s2，要求判定其中一个字符串是否是
        另一字符串通过若干次循环移位后的新字符串的子串。
        例如CDAA是由AABCD两次移位后产生的新串BCDAA的子串，
        而ABCD与ACBD则不能通过多次移位来得到其中一个字符串是新串的子串。

        输入格式
        一行，包含两个字符串，中间由单个空格隔开。字符串只包含字母和数字，长度不超过30。

        输出格式
        如果一个字符串是另一字符串通过若干次循环移位产生的新串的子串，则输出true，否则输出false。

        样例输入
        AABCD CDAA

        样例输出
        true

        思路：   在数学上，只有“短串（或等长串）”才可能成为“长串”的子串
                ，因此拿到输入的第一步，先比较两串长度：如果 s1.length() < s2.length()，
                直接将两者交换，确保接下来的逻辑中 s1 永远代表较长的母串，s2 永远代表较短的模式串。
 */
public class Main2 {
    //破环成链（字符串倍增） + Java 内置子串查找
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String line =br.readLine();
        if(line==null)return;

        StringTokenizer st = new StringTokenizer(line);
        String s1 = st.nextToken();
        String s2 = st.nextToken();

        // 确保 s1 始终是较长（或等长）的母串，s2 是较短的模式串
        if(s1.length()<s2.length()){
            String temp =s1;
            s1 =s2;
            s2 =temp;
        }

        // 破环成链：将母串自身拼接一次，即可包含所有循环移位的结果
        String doubles = s1+s1;

        // 判断 s2 是否包含在拼接后字符串的子串
        System.out.println(doubles.contains(s2)?"true":"false");

    }
}
