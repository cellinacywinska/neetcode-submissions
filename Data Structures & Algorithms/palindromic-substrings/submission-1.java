class Solution {
    public int countSubstrings(String s) {
        int count = 0;

        // im going to treat each character as a center
        // and expand around it

        for (int i =0; i < s.length(); i++){
            // for odd length 
            int l = i;
            int r = i;

            while (l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                count++; 
                l--;
                r++;
            }

            // for even length
            l = i;
            r = i+1;
            while (l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                count++;                   
                l--;
                r++;
            }

        }


        return count;
    }
}
