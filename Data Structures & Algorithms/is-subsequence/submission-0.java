class Solution {
    public boolean isSubsequence(String s, String t) {
        int l = 0;
        int r = t.length();
        int count = 0;
        for (char c : s.toCharArray()){
            while (l<r){
                if (t.charAt(l)==c){
                    l++;
                    count++;
                    break;
                } else {
                    l++;
                }
            }
        }

        return count==s.length();
    }
}