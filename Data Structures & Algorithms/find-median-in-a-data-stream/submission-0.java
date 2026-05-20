class MedianFinder {

    PriorityQueue<Integer> leftHalf; //maxHeap
    PriorityQueue<Integer> rightHalf; // minHeap

    public MedianFinder() {
        leftHalf = new PriorityQueue<>(Collections.reverseOrder());
        rightHalf = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        leftHalf.add(num);
        if (leftHalf.size()-rightHalf.size() > 1 || !rightHalf.isEmpty() && leftHalf.peek() > rightHalf.peek()){
            rightHalf.add(leftHalf.poll());
        }

        if (rightHalf.size()-leftHalf.size() > 1){
            leftHalf.add(rightHalf.poll());
        }
    }
    
    public double findMedian() {
        if (leftHalf.size()==rightHalf.size()){
            return ((double)leftHalf.peek()+(double)rightHalf.peek())/2;
        } else {
            return leftHalf.size() > rightHalf.size() ? leftHalf.peek() : rightHalf.peek();
        }
    }
}
