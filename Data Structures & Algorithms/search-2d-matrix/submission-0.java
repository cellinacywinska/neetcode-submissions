class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length==0) return false;
        int row = -1;
        
        for (int i = 0; i < matrix.length; i++){
            if (target>=matrix[i][0] && target <= matrix[i][matrix[0].length-1]){
                row = i;
                break;
            }
        }
        
        if (row == -1) return false;


        return binarySearch(matrix, target, row);
    }

    public boolean binarySearch(int[][] matrix, int target, int row){
        int left = 0;
        int right=matrix[0].length-1;

        while (left <= right){
            int middle = (left+right)/2;
            if (matrix[row][middle]>target){
                right=middle-1;
            } else if (matrix[row][middle]<target){
                left=middle+1;
            } else {
                return true;
            }
        }

        return false;
    }
}
