class Solution {
    public int coinChange(int[] coins, int amount) {
       // dp[i] = minimum number of coins needed to make amount i 
       /* 
        At each amount i, for every coin you try:
            keep current best
            or
            use this coin
       */

       int[] dp = new int[amount+1];
       dp[0]=0;

        // initializing the array to amount+1, in other words a number thats impossible 
        // we can't have more coins than the amount
        //because at worst case it would be all 1's (meaning amount number of coins)
       for (int i = 1; i < dp.length; i++){
           dp[i]=amount+1; 
       }

        for (int i = 1; i <= amount; i++){
            for (int j = 0; j < coins.length; j++){
                // we dont want to use a coin thats larger then current amount
                if (coins[j]<=i){
                    int keepCurrentBest = dp[i];
                    int useThisCoin = dp[i-coins[j]]+1;
                    dp[i]=Math.min(keepCurrentBest, useThisCoin);
                }
            }
        }

        return (dp[amount] > amount) ? -1 : dp[amount];
    }
}
