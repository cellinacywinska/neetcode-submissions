class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1 ) return nums[0];
        int[] withoutFirstHouse = new int[nums.length-1];
        int[] withoutLastHouse = new int[nums.length-1];

        for (int i = 1; i < nums.length; i++){
            withoutFirstHouse[i-1]=nums[i];
        }
        for (int i = 0; i < nums.length-1; i++){
            withoutLastHouse[i]=nums[i];
        }
       
        int max1 = getMax(withoutFirstHouse);
        int max2 = getMax(withoutLastHouse);

        return Math.max(max1, max2);
    }

    public int getMax(int[] array){
        if (array.length==0) return 0;
        if (array.length == 1 ) return array[0];

        int[] dp = new int[array.length];
       
        dp[0]=array[0];
        dp[1]=Math.max(array[0], array[1]);

        for (int i = 2; i < array.length; i++){
            int skip = dp[i-1];
            int rob = dp[i-2]+array[i];
            dp[i]=Math.max(skip, rob);
        }

        return dp[array.length-1];
    }
}
