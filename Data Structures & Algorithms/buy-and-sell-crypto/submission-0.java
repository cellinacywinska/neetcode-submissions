class Solution {
    public int maxProfit(int[] prices) {
        int l = 0;
        int r = 1;
        int maxProfit = 0;

        while (r<prices.length){
            if (prices[l]<prices[r]){
                maxProfit = Math.max(maxProfit, prices[r]-prices[l]);
            } else {
                // if the value on the left is not smaller than the value on the righ
                //then we found a better time to buy --> cheaper
                l=r;
            }
            r++;
        }


        return maxProfit;
    }
}
