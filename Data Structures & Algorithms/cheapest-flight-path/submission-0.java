class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> sourcesAndDest = new HashMap<>();
        int[] minCostForCity = new int[n];

        for (int i = 0; i < n; i++){
            sourcesAndDest.put(i, new ArrayList<>());
        }

        for (int i = 0; i < flights.length; i++){
            int from = flights[i][0];
            int dest = flights[i][1];
            int cost = flights[i][2];

            sourcesAndDest.get(from).add(new int[]{dest, cost});
        }

        for (int i = 0; i < n; i++){
            minCostForCity[i]=-1;
        }

        minCostForCity[src]=0;

        Queue<Integer> cityQueue = new LinkedList<>();
        cityQueue.add(src);
        int levelCount = 0;

        while (!cityQueue.isEmpty() && levelCount<=k){
            int queueSize = cityQueue.size();
            
            int[] nextCost = Arrays.copyOf(minCostForCity, n);

            for (int i = 0; i < queueSize; i++){
                int currentCity = cityQueue.poll();
                
                List<int[]> nextCities = sourcesAndDest.get(currentCity);

                for (int j = 0; j < nextCities.size(); j++){
                    int city = nextCities.get(j)[0];
                    int price = nextCities.get(j)[1];

                    int newCost = minCostForCity[currentCity] + price;

                    if (nextCost[city] == -1 || nextCost[city]>newCost){
                        nextCost[city]=newCost;
                        cityQueue.add(city);
                    }
                }
            }
            minCostForCity=nextCost;
            levelCount++;
        }
        return minCostForCity[dst];
    }
}
/*
sourcesAndDestinations Map<Integer, List<int[]>>
{0:{[1, 200]}, 1: {[2, 100], [3,300]}, 2: {[3,100]}, 3 : {}}

MIN COST TO GET TO A CITY: array of size of n -> [0, -1,-1,-1,]

queue - [0]
levelCount = 0;
[0, 200,-1,-1]

queue - [1]
levelCount = 1;

[0, 200, 300, 500]

levelCount = 2;
queue - [2,3]

levelCount > k


return 500

*/