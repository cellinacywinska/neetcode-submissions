class Solution {
    /**
     * @param {number[]} nums
     * @param {number} target
     * @return {number[]}
     */
    twoSum(nums, target) {
        let map = new Map();

        for (let i = 0; i < nums.length; i++){
            const diff = target - nums[i];
            
            if (map.has(diff)){
                return [map.get(diff), i].sort((a,b) => a-b);
            } else {
                map.set(nums[i], i);
            }
        }

        return [];
    }
}
