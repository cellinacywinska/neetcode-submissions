class Solution {
    public int characterReplacement(String s, int k) {
    /*
    I first collect the set of unique characters in the string. 
    For each character c, I run a sliding window over the string and treat c as the 
    target character we want the window to become.

    Inside the window, I track how many characters equal c. The number of replacements
    needed is (window size - count). If this exceeds k, I shrink the window from the left.

    Throughout the process, I keep updating the maximum valid window size.
    */

    Set<Character> setOfChars = new HashSet<>();

    for (int i = 0; i < s.length(); i++){
        setOfChars.add(s.charAt(i));
    }

    int maxLen = 0;

    for (char c: setOfChars){
        int left = 0;
        int countOfMatchingChars = 0;
        for (int right = 0; right < s.length(); right++){
    
            if (s.charAt(right)==c){
                countOfMatchingChars++;
            }

            while ((right-left+1)-countOfMatchingChars > k){
                // shrink window size --> move to the right
                if (s.charAt(left)==c){
                    countOfMatchingChars--;
                }
                left++;
            }

            // update max
            maxLen = Math.max(maxLen, right-left+1);
        }
    }

    

    return maxLen;
    }
}
