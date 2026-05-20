class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0,1);
        int res = 0;
        int currSum =0;

        for (int num: nums){
            currSum+=num;
            int diff = currSum-k;
            res+=prefixSums.getOrDefault(diff,0);
            prefixSums.put(currSum, prefixSums.getOrDefault(currSum,0)+1);

        }

        return res;
    }
}

/*
[2,-1,1,2]
[2, 1, 2, 4]
key   = prefix sum value
value = how many times we’ve seen that sum

*/