class Solution {
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        
        int water = 0;
        int[] leftTallest = new int[height.length];
        leftTallest[0]=height[0];

        for (int i = 1; i < height.length; i++){
            leftTallest[i]=Math.max(leftTallest[i-1], height[i]);
        }

        int[] rightTallest = new int[height.length];
        rightTallest[height.length-1]=height[height.length-1];

        for (int i = height.length-2; i >= 0; i--){
            rightTallest[i]=Math.max(rightTallest[i+1], height[i]);
        }

        for (int i = 0; i < height.length; i++){
            water+=Math.min(leftTallest[i],rightTallest[i])-height[i];
        }

        return water;

    }
}
