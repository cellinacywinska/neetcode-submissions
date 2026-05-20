class Solution {
    public int[][] directions = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length==0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int maxArea = 0;

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (grid[i][j]==1 && !visited[i][j]){
                    int area = dfs(grid, i,j, visited);
                    maxArea=Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    public int dfs(int[][] grid, int i, int j, boolean[][] visited){    
        int rows = grid.length;
        int cols = grid[0].length;
        int area = 1;
        
        visited[i][j]=true;

        for (int[] dir : directions){
            int newRow = i + dir[0];
            int newCol = j + dir[1];

            if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols || 
                grid[newRow][newCol]!=1 || visited[newRow][newCol]){
                continue;
            }
            area+=dfs(grid, newRow, newCol, visited);
        }

        return area;
    }
}
