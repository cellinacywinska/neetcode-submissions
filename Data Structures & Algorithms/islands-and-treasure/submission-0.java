class Solution {
    int[][] directions = new int[][]{{-1,0}, {1,0},{0,1}, {0,-1}};
    public void islandsAndTreasure(int[][] grid) {
        int TREASURE_CHEST = 0;
        int INF = 2147483647;
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> treasureChests = new LinkedList<>();

        for (int i = 0; i < rows; i++){
            for (int j = 0; j<cols; j++){
                if (grid[i][j]==TREASURE_CHEST){
                    treasureChests.add(new int[]{i,j});
                }
            }
        }

        while (!treasureChests.isEmpty()){
            int[] current = treasureChests.poll();
            int row = current[0];
            int col = current[1];

            for (int i = 0; i < directions.length; i++){
                int newRow = row+directions[i][0];
                int newCol = col+directions[i][1];

                if (newRow < 0 || newCol < 0 || newRow>=rows || newCol>=cols || grid[newRow][newCol]!=INF){
                    continue;
                }

                grid[newRow][newCol]=grid[row][col]+1;
                treasureChests.add(new int[]{newRow, newCol});
            }
        }
    }
}
