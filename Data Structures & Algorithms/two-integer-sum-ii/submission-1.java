class Solution {
    // public int[] twoSum(int[] numbers, int target) {
    //     for (int i = 0; i < numbers.length; i++){
    //         int diff = target-numbers[i];
    //         int num2 = binarySearch(diff, numbers, i+1);
    //         if (num2!=-1){
    //             return new int[]{i+1, num2+1};
    //         } 
    //     }

    //     return new int[]{};
    // }

    // public int binarySearch(int target, int[] numbers, int startIndex){
    //     int left = startIndex;
    //     int right = numbers.length-1;

    //     while (left<=right){
    //         int mid = (left+right)/2;

    //         if (numbers[mid]>target){
    //             right=mid-1;
    //         } else if (numbers[mid]<target){
    //             left=mid+1;
    //         } else {
    //             return mid;
    //         }
    //     }

    //     return -1;
    // }
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length-1;

        while (l<r){
            int sum = numbers[l]+numbers[r];

            if (sum>target){
                r--;
            } else if (sum<target){
                l++;
            } else {
                return new int[]{l+1, r+1};
            }
        }

        return new int[]{};
    }
}
