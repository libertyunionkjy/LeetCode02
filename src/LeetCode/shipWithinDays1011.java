package LeetCode;

public class shipWithinDays1011 {
    public int shipWithinDays(int[] weights, int D) {
        int[] sumAndMax = getWeightSumAndMax(weights);
        int loCap = sumAndMax[1], hiCap = sumAndMax[0];
        while (loCap <= hiCap){
            int midCap = loCap + (hiCap - loCap) / 2;
            //System.out.println(midCap);
            if(capToDay(weights,midCap) < D){
                hiCap = midCap - 1;
            }else if(capToDay(weights,midCap) > D){
                loCap = midCap + 1;
            }else if(capToDay(weights,midCap) == D){
                hiCap = midCap - 1;
            }
        }
        return loCap;
    }


    int[] getWeightSumAndMax(int[] weight){
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < weight.length; i++) {
            max = weight[i] > max ? weight[i] : max;
            sum += weight[i];
        }
        return new int[]{sum,max};
    }

    //已知船的装载能力，返回最少需要多少天才能运输完所有的货物
    int capToDay(int[] weights, int cap) {
        int days = 0;
        int loaded = 0;
        int i = 0;
        while (i < weights.length) {
            if ((loaded + weights[i]) <= cap) {
                loaded += weights[i];
                i++;
            } else {
                days++;
                loaded = 0;
            }
        }
        return days + 1;
    }

    public static void main(String[] args) {
        int[] weight = {3,2,2,4,1,4};
        System.out.println(new shipWithinDays1011().shipWithinDays(weight,3));
    }
}
