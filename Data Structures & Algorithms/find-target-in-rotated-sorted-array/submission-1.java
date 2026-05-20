class Solution {
    public int search(int[] nums, int target) {
        // find pivot -- meaning that place where the array was rotated
        int pivot = -1;
        int res = -1;

        if (nums[0]<nums[nums.length-1]){
           return binarySearch(0,nums.length-1, nums, target);
        }

        /* it is a pivot if:
            - the number left of the pivot is smaller 
            - the number right of the pivot is smaller
        */

        int l = 0;
        int r = nums.length-1;

        while (l<=r){
            int middle = (l+r)/2;
            if (middle < nums.length - 1 && nums[middle]>nums[middle+1]){
                pivot=middle;
                break;
            } else if (middle > 0 && nums[middle]<nums[middle-1]){
                pivot=middle-1;
                break;
            }

            //if nums[middle] >= nums[0], pivot is on the right
            if (nums[middle]>=nums[0]){
                l=middle+1;
            } else {
                r=middle-1;
            }

        }



        // binary search each side 
        int right = binarySearch(pivot+1,nums.length-1, nums, target);
        int left = binarySearch(0,pivot, nums, target);

        if (right!=-1) return right;
        if (left!=-1) return left;

        return res;
    }

    public int binarySearch(int start, int end, int[] nums, int target){
        
        while (start <= end){
            int middle = (start+end)/2;

            if (nums[middle]>target){
                end=middle-1;
            } else if (nums[middle]<target){
                start=middle+1;
            } else {
                return middle;
            }
        }

        return -1;
    }
    
}
