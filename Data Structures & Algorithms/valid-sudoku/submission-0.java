class Solution {
    public boolean isValidSudoku(char[][] board) {
        // check rows
        for (int i =0; i < 9; i++){
            Set<Character> seen = new HashSet<>();
            for (int j = 0; j < 9 ; j++){
                if (board[i][j]=='.') continue;
                if (seen.contains(board[i][j])) return false;
                seen.add(board[i][j]);
            }
        }

        // check cols 
        for (int i =0; i < 9; i++){
            Set<Character> seen = new HashSet<>();
            for (int j = 0; j < 9 ; j++){
                if (board[j][i]=='.') continue;
                if (seen.contains(board[j][i])) return false;
                seen.add(board[j][i]);
            }
        }

        //check boxes
        for (int box =0; box < 9; box++){
            Set<Character> seen = new HashSet<>();
            for (int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++){
                    int row = (box/3) * 3 + i;
                    int col = (box%3) * 3 + j;
                    if (board[row][col]=='.') continue;
                    if (seen.contains(board[row][col])) return false;
                    seen.add(board[row][col]);
                }
            }
            
        }

        return true;
    }
}
