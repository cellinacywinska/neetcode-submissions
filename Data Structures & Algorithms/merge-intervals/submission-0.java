class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length==0) return new int[][]{};
        Arrays.sort(intervals, (a, b)-> a[0]-b[0]);
        List<int[]> merged = new ArrayList<>();

        merged.add(intervals[0]);

        for (int i = 0; i < intervals.length; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            int mergedLastEnd =merged.get(merged.size()-1)[1];

            //overlapping
            // if start time of the 2nd is smaller than end time of 1st
            if (start<=mergedLastEnd){
                merged.get(merged.size()-1)[1]=Math.max(mergedLastEnd,end);
            } else {
                // not overlapping
                merged.add(new int[]{start,end});
            }
        }

        int[][] res = new int[merged.size()][2];

        for (int i = 0; i<merged.size(); i++){
            res[i][0]=merged.get(i)[0];
            res[i][1]=merged.get(i)[1];
        }

        return res;

    }
}
