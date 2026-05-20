class Solution {
    /**
     * @param {string} s
     * @param {string} t
     * @return {boolean}
     */
    isAnagram(s, t) {
        if (s.length!==t.length) return false;
        const charsInS = new Map();
        const charsInT = new Map();


        for (let i = 0; i < s.length; i++){
            charsInS.set(s[i], (charsInS.get(s[i]) ?? 0) + 1);
            charsInT.set(t[i], (charsInT.get(t[i]) ?? 0) + 1);
        }

        for (const [key,val] of charsInS){
            if (charsInT.get(key)!==val){
                return false;
            }
        }

        return true;
    }
}
