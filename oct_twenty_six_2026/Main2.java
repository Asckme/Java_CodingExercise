package oct_twenty_six_2026;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
/*
字符串先按长度大的排，在按字母a-z来排
 */
public class Main2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        String s3 = sc.next();

        ArrayList<String> list =new ArrayList<>(Arrays.asList(s1,s2,s3));
        //法一：

//        list.sort((o1,o2) -> {
//            return o1.length()!=o2.length() ? Integer.compare(o2.length(),o1.length()) : o1.compareTo(o2);
//        });
//        System.out.println(list);

        //法二：链式Comparator+方法引用

        list.sort(Comparator.comparingInt(String::length).reversed()
                .thenComparing(s->!Character.isUpperCase(s.charAt(0)))
                .thenComparing(String::compareToIgnoreCase));

        /*
        comparingInt(...)：告诉 Java 比较器，“请用这个提取出来的整数（长度）作为标准来比较两个字符串”。
        默认规则：comparingInt 默认是升序（从小到大）。所以这一步生成的是一个“长度短的排前面”的比较器。


         */
    }
}
