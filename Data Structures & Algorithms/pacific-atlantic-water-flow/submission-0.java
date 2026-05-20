class Solution {
    public int[][] directions = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        Queue<int[]> pacificAdjacent = new LinkedList<>();
        Queue<int[]> atlanticAdjacent = new LinkedList<>();

        for (int i = 0; i < rows; i++){
            pacificAdjacent.add(new int[]{i,0});
            atlanticAdjacent.add(new int[]{i, cols-1});
        }

        for (int i = 0; i < cols; i++){
            pacificAdjacent.add(new int[]{0,i});
            atlanticAdjacent.add(new int[]{rows-1, i});
        }

        boolean[][] pacificReachable = bfs(heights, pacificAdjacent);
        boolean[][] atlanticReachable = bfs(heights, atlanticAdjacent);

        List<List<Integer>> commonCells = new ArrayList<>();

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (pacificReachable[i][j] && atlanticReachable[i][j]){
                    commonCells.add(List.of(i,j));
                }
            }
        }   
    
        return commonCells;
    }

    public boolean[][] bfs(int[][] heights, Queue<int[]> queue){
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] reachable = new boolean[rows][cols];

        while (!queue.isEmpty()){
            int[] current = queue.poll();

            int r = current[0];
            int c = current[1];

            reachable[r][c]=true;

            for (int[] dir : directions){
                int newRow = r+dir[0];
                int newCol = c+dir[1];

                if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >=cols){
                    continue;
                }

                if (reachable[newRow][newCol]){
                    continue;
                }

                if (heights[r][c]>heights[newRow][newCol]){
                    continue;
                }

                queue.add(new int[]{newRow, newCol});
            }
        }

        return reachable;
    }
}
