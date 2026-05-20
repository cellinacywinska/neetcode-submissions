class Solution {
    public int[] sortArray(int[] nums) {
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        Map<Integer,Integer> counts = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            counts.put(nums[i], counts.getOrDefault(nums[i], 0)+1);
            minValue=Math.min(minValue, nums[i]);
            maxValue=Math.max(maxValue, nums[i]);
        }

        int index = 0;

        for (int val = minValue; val <= maxValue; val++){
            while (counts.containsKey(val) && counts.get(val)>0){
                nums[index]=val;
                index++;
                counts.put(val, counts.get(val)-1);
            }
        }

        return nums;
    }
}