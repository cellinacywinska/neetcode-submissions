class Solution {
    /**
     * @param {number[]} nums
     * @param {number} val
     * @return {number}
     */
    removeElement(nums, val) {
        let currentPos = 0;
        let len = nums.length;

        while (currentPos < len) {
            if (nums[currentPos]===val){
                const temp = nums[currentPos];
                nums[currentPos]=nums[len-1];
                nums[len-1]=temp;
                len--;
            } else {
                currentPos++;
            }
        }

        return len; 
    }
}
