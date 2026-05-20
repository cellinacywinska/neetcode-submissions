class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length()<s1.length()) return false;

        Map<Character, Integer> lettersS1 = new HashMap<>();
        for (char c : s1.toCharArray()){
            lettersS1.put(c, lettersS1.getOrDefault(c, 0)+1);
        }

        int l = 0;
        int r = 0;
        Map<Character, Integer> found = new HashMap<>();

        while (r<s2.length()){
            char currentLetter = s2.charAt(r);

            if (lettersS1.containsKey(currentLetter)){
                found.put(currentLetter, found.getOrDefault(currentLetter, 0)+1);
            }

            if (r-l+1>s1.length()){
                char leftLetter = s2.charAt(l);

                if (lettersS1.containsKey(leftLetter)){
                    found.put(leftLetter,found.get(leftLetter)-1);
                    if (found.get(leftLetter)==0){
                        found.remove(leftLetter);
                    }
                }
                l++;
            }

            if (r-l+1==s1.length() && found.equals(lettersS1)){
                return true;
            }

            r++;
        } 

        return false;
    }
}
/*



*/