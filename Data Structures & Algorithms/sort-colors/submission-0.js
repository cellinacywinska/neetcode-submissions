class Solution {
    /**
     * @param {number[]} nums
     * @return {void} Do not return anything, modify nums in-place instead.
     */
    sortColors(nums) {
        let counts = new Array(3).fill(0);

        for (let n of nums){
            counts[n]++;
        }

        let index = 0;
        for (let i = 0; i < 3; i++) {
            while (counts[i]>0){
                nums[index]=i;
                counts[i]--;
                index++;
            }
        }
    }
}
