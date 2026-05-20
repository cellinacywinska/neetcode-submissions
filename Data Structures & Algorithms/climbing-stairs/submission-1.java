class Solution {
    public int climbStairs(int n) {
        // ways to reach current step
        int stepOne = 1;

        // ways to reach previous step
        int stepTwo = 1;

        for (int i = 0; i < n-1; i++){
            int temp = stepOne;
            stepOne = stepOne+stepTwo;
            stepTwo = temp;
        }

        return stepOne;
    }
}
