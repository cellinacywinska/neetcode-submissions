class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        int max = 0;

        Set<Integer> set = new HashSet<>();
        for (int i: nums){
            set.add(i);
        }   

        // for every num in the array
        for (int i =0; i < nums.length; i++){
            if (!set.contains(nums[i]-1)){
                int len = 1;
                while (set.contains(nums[i]+len)){
                    len++;
                }
                max=Math.max(len, max);
            }
        }

        return max;
    }
}
