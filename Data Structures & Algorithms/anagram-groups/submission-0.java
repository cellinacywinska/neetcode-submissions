class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++){
            // count the characters in the string
            int[] letters = new int[26];

            for (int j = 0; j < strs[i].length(); j++){
                char c = strs[i].charAt(j);
                letters[c-'a']++;
            }

            String key = Arrays.toString(letters);
            // check if that key exists in the map
            // udpate map accordingly
            if (map.containsKey(key)){
                List<String> s = map.get(key);
                s.add(strs[i]);
                map.put(key,s);
            } else {
                List<String> s = new ArrayList<>();
                s.add(strs[i]);
                map.put(key, s);
            }
        }


        return new ArrayList<>(map.values());
    }
}
