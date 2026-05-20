class Solution {
    /**
     * @param {number[]} nums
     * @return {number}
     */
    // majorityElement(nums) {
    //     let counts = new Map();

    //     for (let i = 0; i < nums.length; i++){
    //         if (counts.has(nums[i])){
    //             counts.set(nums[i], counts.get(nums[i])+1);
    //             if (counts.get(nums[i])>nums.length/2){
    //                 return nums[i];
    //             }
    //         } else {
    //             counts.set(nums[i], 1);
    //         }
    //     }

    //     return 0;
    // }
    majorityElement(nums) {
        let candidate = 0;
        let count = 0;

        for (let i = 0; i < nums.length; i++){
            if (count==0){
                candidate=nums[i];
            } 
            count+= (nums[i]==candidate) ? 1 : -1;   
        }

        return candidate;  
    }
}
