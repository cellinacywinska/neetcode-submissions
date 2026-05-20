class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // k - bananas per hour eating speed 
        int minSpeed = 1; 
        int maxSpeed = max(piles);
        // 1 2 3 4 
        int min = 0;

        while (minSpeed <= maxSpeed){
            int mid = (minSpeed+maxSpeed)/2;
            // if possible to eat slower
            if (isPossibleToEat(piles, mid,h)){
                maxSpeed=mid-1;
            }else {
                minSpeed=mid+1;
            }
        }

        return minSpeed;
    }

    public boolean isPossibleToEat(int[] piles, int speed, int h){
        // can i eat all bananas at this speed?
        int hoursPassed = 0;
        for (int i =0; i<piles.length; i++){
            int hoursNeeded = (int)Math.ceil((double)piles[i]/speed);
            hoursPassed+=hoursNeeded;

            if (hoursPassed>h) return false;
        }

        return true;
    }

    public int max(int[] piles){
        int max = 0;
        for (int i = 0; i < piles.length; i++){
            max=Math.max(max,piles[i]);
        }

        return max;
    }
}
