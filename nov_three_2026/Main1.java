package nov_three_2026;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int maxLocation=1,maxNum = -1;
        for(int i=1;i<=n;i++){
            int num = sc.nextInt();
            if(num>maxNum){
                maxLocation= i;
                maxNum= num;
            }
        }
        System.out.println(maxLocation);
    }
}
