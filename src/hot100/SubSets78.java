package hot100;

import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            // n个数
            int n = sc.nextInt();
            // 间隔m，m是知道的，他这里也是自己输入的
            int m = sc.nextInt();
            int sum = 0;
            boolean a = true;
            int b = n % m;
            System.out.println("b=" + b);
            // n个数
            // --------从这里开始讲-------------
            for (int i = 1; i <= n; i++) {
                // sum保存每一段的总和，直接抄
                sum = sum + (2 * i);
                // 如果到了分界点，我们就把结果保存到当前的数组中
                if (i % m == 0) {
                    if (a) {
                        System.out.print(sum / m);
                        a = false;
                    } else {
                        System.out.print(" " + sum / m);
                    }
                    // 保存完毕后，我们开始下一段的遍历，把 sum 还原为 0
                    sum = 0;
                }

                // 这里我们处理最后的尾端部分，用了两个if来判断是否到尾端
                // b = n % m，是最后剩的部分，
                if (b != 0) {
                    // 如果到了最后那个部分了，计算方式要改变，直接算出平均后输出到结果
                    if (i == (n - b)) {
                        sum = 0;
                        for (i = n - b + 1; i <= n; i++) {
                            sum += i * 2;
                            System.out.println("i=" + i + ",sum=" + sum);
                        }
                        System.out.print(" " + sum / b);
                    }
                }
            }
            System.out.println();
            // 把前面能整除的和最后不能整除的分开算了
            //
        }
    }
}
