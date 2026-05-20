class Solution {
    char ONE = '1';

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int numOfIslands = 0;

        for (int i =0; i < rows; i++){
            for (int j=0; j < columns; j++){
                if (grid[i][j]==ONE){
                    // if its one, then we want to check its neighbors
                    // we also need to mark it as visited
                    dfs(i,j, grid);
                    numOfIslands++;
                }
            }
        }

        return numOfIslands;
    }


    public void dfs(int i, int j, char[][] grid){
        // we want to check the neighbors
        // we also need to mark it as visited
        // increment island count if needed
        int rows = grid.length;
        int columns = grid[0].length;

        if (i < 0 || i >= rows || j < 0 || j >= columns || grid[i][j]=='0'){
            return;
        }

        grid[i][j]='0';
        // top neighbour
        // IF THE TOP NEIGBOR IS A ONE WITHIN THE GRID SIZE
        if (i-1>=0 && grid[i-1][j]==ONE){
            // visit the next
            dfs(i-1,j, grid);
        }
        // bottom neighbour
        if (i+1<rows && grid[i+1][j]==ONE){
            // visit the next
            dfs(i+1,j, grid);
        }
        // left neighbour
        if (j-1>=0 && grid[i][j-1]==ONE){
            // visit the next
            dfs(i,j-1, grid);
        }

        // right neighbour
        if (j+1<columns && grid[i][j+1]==ONE){
            // visit the next
            dfs(i,j+1, grid);
        }
    }
}
