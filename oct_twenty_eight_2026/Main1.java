package oct_twenty_eight_2026;

import java.util.Scanner;

public class Main1 {

/*
        题目描述
        德国数学家哥德巴赫曾猜测：任何大于6的偶数都可以分解成两个素数（素数对）的和。
        但有些偶数可以分解成多种素数对的和，如： 10=3+7，10=5+5，即10可以分解成两种不同的素数对

        输入格式
        输入任意的>6的正偶数(<32767)

        输出格式
        试求给出的偶数可以分解成多少种不同的素数对（注： A+B与B+A认为是相同素数对）

        样例输入
        1234
        样例输出
        25
 */


      //第一时间想到  列表+双重循环
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int count =0;
//
//
//        ArrayList<Integer> list = new ArrayList<>();
//        for(int i=2;i<n;i++){
//            if(ps(i))list.add(i);
//        }
//        for(int i=0;i<list.size();i++){
//            for(int j=i;j<list.size();j++){
//                if(list.get(i)+list.get(j)==n)count++;
//            }
//        }
//        System.out.println(count);
//
//    }
//    public static boolean ps(int n){
//        if(n<=1)return false;
//        if(n==2)return true;
//        if(n%2==0)return false;
//        for(int i=3;i<=Math.sqrt(n);i+=2){
//            if(n%i==0)return false;
//        }
//        return true;
//    }


    //空间最优 & 极简写法（枚举减法 + 奇偶剪枝，复杂度 $O(n\sqrt{n})$ 时间 / $O(1)$ 空间）
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;

        // 1. 偶素数 2 不可能与另一个素数凑成大于 6 的偶数，直接从 3 开始且只看奇数
        // 2. 只遍历到 n / 2，既能包含 i == n - i 的情况（如 5+5），又能避免 A+B 与 B+A 重复统计
        for (int i = 3; i <= n / 2; i += 2) {
            if (ps(i) && ps(n - i)) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean ps(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        // 用 i * i <= n 替代 Math.sqrt(n)，避免每次循环调用浮点函数
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
