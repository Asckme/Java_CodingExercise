package oct_thirty_2026;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    //正则过滤+排序比较法
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<t;i++){
            String s1= sc.nextLine();
            String s2 = sc.nextLine();
            s1 = s1.replaceAll("[^a-zA-Z]","");
            s2 = s2.replaceAll("[^a-zA-Z]","");
            if(s1.length()!=s2.length()){
                System.out.println("No");
                continue;
            }
            char[] ch1 = s1.toCharArray();
            char[] ch2 = s2.toCharArray();
            Arrays.sort(ch1);
            Arrays.sort(ch2);

            if(Arrays.equals(ch1,ch2)){
                System.out.println("Yes");
            }
            else System.out.println("No");
        }
    }

    //单桶抵消法 + 高速 I/O
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//
//        // 读取组数 t（trim() 可以防止数字后面紧跟多余空格报错）
//        int t = Integer.parseInt(br.readLine().trim());
//
//        for (int i = 0; i < t; i++) {
//            String s1 = br.readLine();
//            String s2 = br.readLine();
//
//            // ASCII 码表前 128 个位置足够覆盖 'A'-'Z'(65-90) 和 'a'-'z'(97-122)
//            int[] count = new int[128];
//
//            // 第一句话：遇到英文字母，对应桶计数 +1
//            for (int j = 0, len = s1.length(); j < len; j++) {
//                char c = s1.charAt(j);
//                if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
//                    count[c]++;
//                }
//            }
//
//            // 第二句话：遇到英文字母，对应桶计数 -1
//            for (int j = 0, len = s2.length(); j < len; j++) {
//                char c = s2.charAt(j);
//                if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
//                    count[c]--;
//                }
//            }
//
//            // 检查所有大小写字母的桶是否全部抵消为 0
//            boolean isSame = true;
//            for (int j = 'A'; j <= 'z'; j++) {
//                if (count[j] != 0) {
//                    isSame = false;
//                    break; // 一旦发现有字母数量未抵消，立即提前结束检查
//                }
//            }
//
//            sb.append(isSame ? "Yes\n" : "No\n");
//        }
//
//        System.out.print(sb);
//    }
}
