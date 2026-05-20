class Solution {
    public int rob(int[] nums) {
        // that each house we have to make a decision:
        // skip that house --> that means money from prev robberies
        // rob that house --> that means the money from prev + this house

        if (nums.length==1) return nums[0];
        if (nums.length==2) return Math.max(nums[0], nums[1]);
        int dp[] = new int[nums.length+1];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0], nums[1]);
        int max = 0;

        for (int i = 2; i < nums.length; i++){
            // we want the max 
            int skip = dp[i-1];
            int rob = nums[i]+dp[i-2];
            dp[i]=Math.max(skip, rob);
            max=Math.max(max, dp[i]);
        }

        return max;
    }
}
