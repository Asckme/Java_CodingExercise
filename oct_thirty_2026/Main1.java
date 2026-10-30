package oct_thirty_2026;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main1 {
    /*
    给定一个非负整数数组，统计里面每一个数的出现次数。我们只统计到数组里最大的数。
    假设 Fmax （Fmax < 10000）是数组里最大的数，那么我们只统计 {0,1,2.....Fmax} 里每个数出现的次数。

    输入格式

    第一行n是数组的大小。1 <= n <= 10000。
    紧接着一行是数组的n个元素。

    输出格式

    按顺序输出每个数的出现次数，一行一个数。如果没有出现过，则输出0。
    对于例子中的数组，最大的数是3，因此我们只统计{0,1,2,3}的出现频数。

    样例输入

    5
    1 1 2 3 1

    样例输出

    0
    3
    1
    1

     */

    public static void main(String[] args) throws IOException {

//        //法一：双重暴力循环法：
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int M=-1;
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            int num =sc.nextInt();
//            arr[i]=num;
//            if(num>M)M=num;
//        }
//        for(int i=0;i<=M;i++){
//            int count=0;
//
//            for(int j=0;j<n;j++){
//                if(arr[j]==i)count++;
//            }
//
//            System.out.println(count);
//        }

        //法二：桶计数法+IO流拼接快速输出：

        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        /*
        1.InputStreamReader：把底层的字节流转换成字符流（因为我们要读的是数字和文字，不是纯粹的字节）。

        2.System.in：最底层的标准输入，它是一个字节流。

        3.BufferedReader：带缓冲的字符流。它的作用是把数据先读到内存缓冲区里。
        相比于 Scanner 读一个查一个，BufferedReader 是一次性抓一大把放在内存里慢慢用，极大地提升了读取速度

        4.StreamTokenizer：分词器。它负责从 BufferedReader 中
        把数据按照空格、换行等分隔符切开，提取出一个个“词（Token）”。

        */
        in.nextToken();
        int n= (int) in.nval;
        int[] count = new int[10000];//桶
        int maxVal = 0;
        for(int i=0;i<n;i++){
            in.nextToken();
            int num = (int)in.nval;
            //in.nval：全称是 number value。当 StreamTokenizer 发现当前读取到的词是一个数字时，它会把这个数字的值存放在 nval 中
            // 注意：nval 的类型是 double。因为题目要求是整数，所以我们用 (int) in.nval 把它强转为 int 类型赋给 n。
            count[num]++;//下标映射计数
            if(num>maxVal)maxVal= num;
        }

        StringBuilder sb = new StringBuilder( );
        for (int i = 0; i <=maxVal; i++) {
            sb.append(count[i]).append("\n");
        }
        System.out.println(sb);
    }
}
