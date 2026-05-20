class Solution {
    /**
     * @param {number[]} nums
     * @return {number[]}
     */
    getConcatenation(nums) {
        let ans = [];
        const n = nums.length;

        for (let i = 0; i < n; i++){
            ans[i]=nums[i];
            ans[i+n]=nums[i];
        }

        return ans;

    }
}
