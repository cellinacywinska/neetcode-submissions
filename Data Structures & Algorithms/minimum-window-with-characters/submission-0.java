class Solution {
    public String minWindow(String s, String t) {
        // window size has to be at least t size
        int sLen = s.length();
        int tLen = t.length();
        if (t=="") return "";
        if (tLen>sLen) return "";

        Map<Character, Integer> mapOfT = new HashMap<>();
        // frequency of characters in T for O(1) lookup
        for (char c : t.toCharArray()){
            if (mapOfT.containsKey(c)){
                mapOfT.put(c, mapOfT.get(c)+1);
            } else {
                mapOfT.put(c,1);
            }
        }

        int have = 0;
        int need = mapOfT.size();
        int[] res = new int[]{-1, -1};
        int resLen = Integer.MAX_VALUE;
        Map<Character, Integer> mapOfCharsFound = new HashMap<>();

        int left =0;

        for (int right = 0; right < sLen; right++){
            char letter = s.charAt(right);
            mapOfCharsFound.put(letter, mapOfCharsFound.getOrDefault(letter, 0)+1);
            
            if (mapOfT.containsKey(letter) && mapOfCharsFound.get(letter)==mapOfT.get(letter)){
                have++;
            }

            while (have==need){
                // if the current window is smaller than the resLen
                if ((right-left+1)<resLen){
                    resLen=right-left+1;
                    res[0]=left;
                    res[1]=right;
                }

                mapOfCharsFound.put(s.charAt(left), mapOfCharsFound.get(s.charAt(left)) - 1);
                if (mapOfT.containsKey(s.charAt(left)) 
                && mapOfCharsFound.get(s.charAt(left)) < mapOfT.get(s.charAt(left))){
                    have--;
                }
                left++;

            }



        }


        return resLen==Integer.MAX_VALUE ? "" : s.substring(res[0], res[1]+1);
    }
}
