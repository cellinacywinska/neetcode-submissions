class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length==0) return 0;
        int[] dp = new int[cost.length+1];

        dp[0]=0;
        dp[1]=0;

        for (int i = 2; i <= cost.length; i++){
            int takeOne = dp[i-1]+cost[i-1];
            int takeTwo = dp[i-2]+cost[i-2];
            dp[i]=Math.min(takeOne, takeTwo);
        }

        return dp[cost.length];
        
    }
}
