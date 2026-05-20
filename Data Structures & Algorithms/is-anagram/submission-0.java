class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> sDict = new HashMap<>();
        Map<Character, Integer> tDict = new HashMap<>();

        for (int i =0; i<s.length(); i++){
            char letter = s.charAt(i);
            if (sDict.containsKey(letter)){
                sDict.put(letter, sDict.get(letter)+1);
            } else {
                sDict.put(letter, 1);
            }
        }

        for (int i =0; i<t.length(); i++){
            char letter = t.charAt(i);
            if (tDict.containsKey(letter)){
                tDict.put(letter, tDict.get(letter)+1);
            } else {
                tDict.put(letter, 1);
            }
        }


        return sDict.equals(tDict);

    }
}
