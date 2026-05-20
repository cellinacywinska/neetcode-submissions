class Solution {
    public String longestPalindrome(String s) {

        // whether the substring with inclusive bounds [i][j] is a palindrome
        boolean[][] dp = new boolean[s.length()][s.length()];
        int[] result = new int[]{0,0};

        // first base cases
        // 1. all substrings of 1 are palindromes 
        for (int i = 0; i <s.length(); i++){
            dp[i][i]=true;
        }

    
        for (int i = 0; i <s.length()-1; i++){
            if (s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1]=true;
                result[0]=i;
                result[1]=i+1;
            }
        }
        
        for (int diff = 2; diff < s.length(); diff++) {
           for (int i = 0; i < s.length() - diff; i++) {
                int j = i + diff;
                if ((s.charAt(i)==s.charAt(j) && dp[i+1][j-1])){
                    dp[i][j]=true;
                    result[0]=i;
                    result[1]=j;
                }
            }
        }

        return s.substring(result[0], result[1]+1);

    }
}
