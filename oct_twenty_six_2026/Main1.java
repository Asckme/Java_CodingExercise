package oct_twenty_six_2026;

import java.util.Scanner;
/*
    题目：
    用 x $  来买三种东西，物品A:6$,  物品B:5$   ,物品C:4$,
    要求打印出所有购买方案，最好要给出购买数量最多的方案
 */

public class Main1 {
    public static void main(String[] args){


        Scanner sc =new Scanner(System.in);
        int x = sc.nextInt();
        int result =-1;
        int[] endResult = new int[3];
        System.out.println("所有方案：");
        for(int i=0;i<=x/6;i++){
            // 改动1：上限剪枝为 (x - i * 6) / 5，保证剩余金额 >= 0，省去 k >= 0 的判断
            for(int j=0;j<=(x - i * 6) / 5;j++){
                // 改动2：直接用取模判断是否能被 4 整除
                int rem =x-i*6-j*5;
                if (rem % 4 == 0) {
                    int k = rem / 4;
                    System.out.println(i + " " + j + " " + k);
                    if (i + j + k > result) {
                        result = i + j + k;
                        endResult[0] = i;
                        endResult[1] = j;
                        endResult[2] = k;
                    }
                }
            }
        }
        System.out.println("最终结果：");
        for (int i : endResult) {
            System.out.print(i+" ");
        }
    }

}
