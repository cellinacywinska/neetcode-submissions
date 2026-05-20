class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder("");

        for (int i = 0; i < strs.size(); i++){
            String word = strs.get(i);
            String len = String.valueOf(word.length());
            encoded.append(len).append('#').append(word);
        }

        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();

        int i = 0;

        while (i<str.length()){
            int j = i;

            // get the end index of the substring 
            while (str.charAt(j)!='#'){
                j++;
            }

            int lengthOfTheWord = Integer.parseInt(str.substring(i, j));
            i = j +1; // to get the number - length of the string
            j = i + lengthOfTheWord;

            decoded.add(str.substring(i,j));
            i=j;
        }
     
        return decoded;
    }
}
