package LeetCode;

public class trailingZeroes172 {
    public int trailingZeroes(int n) {
        int res = 0;
        for (int i = 5; i <= n; i+=5) {
            int num = i;
            while(num % 5 == 0){
                num /= 5;
                res++;
            }
        }
        return res;
    }

    //labuladong
    public int trailingZeros(int n){
        int res = 0;
        long division = 5;
        while(division <= n){
            res += n / division;
            division *= 5;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new trailingZeroes172().trailingZeroes(30));
    }
}
