package offer;

class maxProfit {
    public int maxProfit(int[] prices){
        if(prices.length == 0)
            return 0;
        int res = 0, minPrice = prices[0];
        for(int i = 1; i < prices.length; i++){
            res = (prices[i] - minPrice) > res ? (prices[i] - minPrice) : res;
            minPrice = prices[i] < minPrice ? prices[i] : minPrice;
        }
        return res;
    }
}
