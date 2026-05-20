class Solution {
    public int maxProduct(int[] nums) {
        int result = nums[0];
        int currentMax = 1; // maximum product ending at current index
        int currentMin = 1; // minimum product ending at current index

        // Case 1: if the array has only positive numbers its the product of all numbers 
        // Case 2: if there is a zero, we need to start a new subarray
        // Case 3: if there is a negative number:
        // - the product will be negative unless we encounter another negative number

        for (int i = 0; i < nums.length; i++){
            int temp = currentMax;
            currentMax=Math.max(nums[i],Math.max(nums[i]*currentMax, nums[i]*currentMin));
            currentMin=Math.min(nums[i],Math.min(nums[i]*temp, nums[i]*currentMin));
            result = Math.max(result, currentMax);
        }

        return result;

    }
}
// [1,2,-3,4]
// 1, 1 --> 
