class Solution {
    // public boolean canJump(int[] nums) {
    //     int[] dp = new int[nums.length];
    //     Arrays.fill(dp, -1);
    //     // -1 unknown
    //     // 0 bad 
    //     //  1 good 
    //     dp[nums.length-1]=1;

    //     for (int i = nums.length-2; i>=0; i--){
    //         int farthestJump = Math.min(i+nums[i], nums.length-1);
    //         for (int j = i; j <= farthestJump; j++){
    //             if (dp[j]==1){
    //                 dp[i]=1;
    //                 break;
    //             }
    //         }
    //     }

    //     return dp[0]==1;
    // }
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++){
            if (i>maxReach){
                return false;
            } else {
                maxReach=Math.max(maxReach, nums[i]+i);
            }
            
        }

        return true;
    }

}
