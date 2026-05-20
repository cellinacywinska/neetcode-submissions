class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();

        // first sorting the array
        Arrays.sort(nums);

        // now that its sorted it will be easier to tell where to look
        for (int i=0; i < nums.length; i++){
            // because all remaining numbers are positive
            if (nums[i]>0) break;
            if (i>0 && nums[i]==nums[i-1]) continue;

            int l = i+1;
            int r = nums.length-1;

            while (l<r){
                int sum = nums[i]+nums[l]+nums[r];
                if (sum==0 && i!=l && l!=r && i!=r){
                    triplets.add(new ArrayList<>(List.of(nums[i], nums[l], nums[r])));
                    l++;
                    r--;
                    while (l<r && nums[l]==nums[l-1]){
                        l++;
                    }
                } 
                if (sum < 0){
                    l++;
                }
                if (sum > 0){
                    r--;
                } 
            }
        }










        return triplets;
    }
}
