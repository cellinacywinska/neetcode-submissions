class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> elements = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            if (elements.containsKey(nums[i])){
                int oldValue = elements.get(nums[i]);
                elements.put(nums[i], oldValue+1);
            } else {
                elements.put(nums[i], 1);
            }
        }

        // FIFO - first element to be polled is the one with smaller frequency
        Queue<Integer> heap = new PriorityQueue<>((e1, e2) -> elements.get(e1)-elements.get(e2));

        for (Integer e : elements.keySet()){
            heap.add(e);
            if (heap.size()>k){
                heap.poll();
            }
        }

        int[] result = new int[k];

        int i =0;
        while (!heap.isEmpty() && i < result.length){
            result[i]=heap.poll();
            i++;
        }

        return  result;
    }
}
