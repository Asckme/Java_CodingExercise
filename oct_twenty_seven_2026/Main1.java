package oct_twenty_seven_2026;

import java.util.Scanner;
/*
        n控制行数，打印三角形：
        如：n=4;
           *
          ***
         *****
        *******

 */
public class Main1 {
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        int n =sc.nextInt();
        for(int i=1;i<=n;i++){
            for (int j = 1; j <=n-i ; j++) {
                System.out.print(" ");
            }
            for(int j=1;j<=2*i-1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        sc.close();

    }
}
