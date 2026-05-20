class Solution {
    public int maxArea(int[] heights) {
        // max area --> height of the smaller bar * (distance between bars)

        int maxArea = 0;
        int l = 0;
        int r = heights.length-1;

        while (l<r){
            int localArea = Math.min(heights[l],heights[r])*(r-l);
            maxArea=Math.max(maxArea, localArea);
            
            // the only chance to increase area is to move l and find a taller bar.
            if (heights[l]<=heights[r]){
                l++;
            } else {
                r--;
            }
            
        }

        return maxArea;
    }
}
