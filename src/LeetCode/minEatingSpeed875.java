package LeetCode;

public class minEatingSpeed875 {
    public int minEatingSpeed(int[] piles, int h) {
        int loK = 1, hiK = maxPiles(piles);
        while(loK <= hiK){
            int midK = loK + (hiK - loK) /2;
            System.out.println("midK=" + midK+",  lok="+ loK +",  hik=" + hiK);
            if(kToH(piles,midK) < h){
                //eat speed fast
                hiK = midK - 1;
            }else if(kToH(piles,midK) > h){
                //eat speed slow
                loK = midK + 1;
            }else if(kToH(piles,midK) == h){
                //find the slowest speed
                hiK = midK - 1;
            }
        }
        System.out.println("lok="+ loK +",  hik=" + hiK);
        return loK;
    }

    int maxPiles(int[] piles){
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++) {
            res = piles[i] > res ? piles[i] : res;
        }
        return res;
    }

    int kToH(int[] piles,int k){
        int res = 0;
        for (int i = 0; i < piles.length; i++) {
            res += ((piles[i] - 1) / k + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] piles = {30,11,23,4,20};
        //System.out.println(new minEatingSpeed875().minEatingSpeed(piles,5));
        System.out.println(new minEatingSpeed875().kToH(piles,30));
    }
}
