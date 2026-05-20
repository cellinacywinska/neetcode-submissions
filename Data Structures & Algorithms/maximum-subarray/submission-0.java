class Solution {
    // public int maxSubArray(int[] nums) {
    //     int max = Integer.MIN_VALUE;

    //     for (int i =0; i < nums.length; i++){
    //         int currentSum = 0;
    //         for (int j = i; j < nums.length; j++){
    //             currentSum+=nums[j];
    //             max=Math.max(max, currentSum);
    //         }
    //     }

    //     return max;
    // }

    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int maxSubArray = nums[0];

        for (int i =1 ; i < nums.length; i++){
            if (maxSubArray<0){
                maxSubArray=0;
            }
            maxSubArray+=nums[i];
            maxSum=Math.max(maxSum, maxSubArray);
        }

        return maxSum;
    }
}
