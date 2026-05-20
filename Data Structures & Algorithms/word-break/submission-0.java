class Solution {
    // Set<String> subStrings = new HashSet<>();
    // public boolean wordBreak(String s, List<String> wordDict) {
    //     return canSegment(s, wordDict, 0);
    // }

    // public boolean canSegment(String s, List<String> wordDict, int i){
    //     if (i==s.length()){
    //         return true;
    //     }

    //     for (String word : wordDict){
    //         if (i + word.length() <= s.length() &&
    //             s.substring(i, i + word.length()).equals(word)){
    //             if (canSegment(s, wordDict, i+word.length())){
    //                 return true;
    //             }
    //         }
    //     }

    //     return false;
    // }
    // public boolean wordBreak(String s, List<String> wordDict) {
    //     Set<String> wordSet = new HashSet<>(wordDict);
    //     return canSegment(s, wordSet, 0);
    // }

    // public boolean canSegment(String s, Set<String> wordSet, int i){
    //     if (i==s.length()){
    //         return true;
    //     }

    //     for (int j = i+1; j <= s.length(); j++){
    //         if (wordSet.contains(s.substring(i,j))){
    //             if (canSegment(s, wordSet, j)){
    //                 return true;
    //             }
    //         }
    //     }

    //     return false;
    // }

    Map<Integer, Boolean> memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new HashMap<>();
        memo.put(s.length(), true);
        return canSegment(s, wordDict, 0);
    }

    public boolean canSegment(String s, List<String> wordDict, int i){
        if (memo.containsKey(i)){
            return memo.get(i);
        }

        for (String word : wordDict){
            if (i+word.length()<=s.length() && s.substring(i, i+word.length()).equals(word)){
                if (canSegment(s, wordDict, i+word.length())){
                    memo.put(i, true);
                    return true;

                }
            }
        }
        memo.put(i, false);
        return false;
    }

}
