class Solution {

    /*
Instead of resetting everything, you should:

Remove characters from the left until the duplicate disappears.

Keep moving right forward.

This way each character is added and removed at most once → O(n).
    */

    public int lengthOfLongestSubstring(String s) {
        int max = 0;

        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();

        while (right < s.length()){
            if (!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                max = Math.max(max, set.size());
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }

        return max;
    }
}
