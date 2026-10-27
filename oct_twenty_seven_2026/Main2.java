package oct_twenty_seven_2026;

import java.util.Scanner;

public class Main2 {
    /*
    反码问题：
    定义一个字符的反码。如果这是一个小写字符，则它和字符'a’的距离与它的反码和字符'z’
    的距离相同；如果是一个大写字符，则它和字符'A’的距离与它的反码和字符'Z’的距离相同；
    如果不是上面两种情况，它的反码就是它自身。

    输入格式：
    输入每行都是一个字符串，字符串长度不超过 80 个字符。如果输入只有!，表示输入结束

    样例输入:

    Hello
    JLU-CCST-2011
    !

    样例输出:

    Svool
    QOF-XXHG-2011

     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s= sc.nextLine();
            if(s.equals("!"))break;
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(c>='a'&&c<='z')c= (char)('z'-(c-'a'));
                else if(c>='A'&&c<='Z')c=(char)('Z'-(c-'A'));
                sb.append(c);
            }
            System.out.println(sb);
        }
        sc.close();
    }
}
