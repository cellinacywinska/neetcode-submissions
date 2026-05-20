class Solution {
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length()-1;

        while (l<r){
            // if letters are equal we just shrink the window
            if (s.charAt(l)!=s.charAt(r)){
                return (checkPalindrome(s, l+1, r) || checkPalindrome(s, l, r-1));
            }
            l++;
            r--;
        }

        return true;
    }

    public boolean checkPalindrome(String s, int l, int r){
        while (l<r){
            if (s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}