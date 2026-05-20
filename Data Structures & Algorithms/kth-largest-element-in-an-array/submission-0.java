class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> kLargest = new PriorityQueue<Integer>();

        for (int i = 0; i < nums.length; i++){
            kLargest.add(nums[i]);
            while (kLargest.size()>k){
                kLargest.poll();
            }
            
        }


        return kLargest.peek();
    }
}
