class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            int diff = target - nums[i];

            if (map.containsKey(diff) && i!=map.get(diff)){
                if (map.get(diff)>i){
                    return new int[]{i, map.get(diff)};
                }
                return new int[]{map.get(diff), i};
            } else {
                map.put(nums[i],i);
            }
        }

        return new int[]{};
        
    }
}
