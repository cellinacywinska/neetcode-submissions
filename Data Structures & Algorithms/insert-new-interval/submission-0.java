class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> intervalList = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            // if current interval is before the new interval
            if (newInterval[0]>end){
                intervalList.add(intervals[i]);
            } else if (newInterval[1]<start) {
                intervalList.add(newInterval);
                // add the rest
                int j = i;
                while (j<intervals.length){
                    intervalList.add(intervals[j]);
                    j++;
                }

                return intervalList.toArray(new int[intervalList.size()][]);
            } else {
                newInterval[0]=Math.min(start, newInterval[0]);
                newInterval[1]=Math.max(end, newInterval[1]);
            }
        }

        intervalList.add(newInterval);

        return intervalList.toArray(new int[intervalList.size()][]);
    }
}
