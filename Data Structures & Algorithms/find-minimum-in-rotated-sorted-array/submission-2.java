class Solution {
    public int findMin(int[] nums) {
        // pivot - number on the left is smaller, and number of right is smaller

        // first find pivot 
        int left = 0;
        int right = nums.length-1;
        if (nums.length == 1) return nums[0];
        if (nums[left]<nums[right]) return nums[0];

        while (left < right){
            int middle = (left+right)/2;
            // if we found the max, the smallest is the following number
            if (nums[middle]>nums[middle+1]){
                return nums[middle+1];
            } 

            // if the middle is smaller then the previous, we found the min
            if (nums[middle]<nums[middle-1]){
                return nums[middle];
            }

            if (nums[middle]>nums[0]){
                left=middle+1;   
            } else {
                right=middle-1;   
            }
        }


   
        return -1;
        // the number right after the pivot is the smallest
    }
}