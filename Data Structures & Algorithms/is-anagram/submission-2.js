class Solution {
    /**
     * @param {string} s
     * @param {string} t
     * @return {boolean}
     */
    isAnagram(s, t) {
        if (s.length!==t.length) return false;
        const counts = new Map();


        for (let i = 0; i < s.length; i++){
            counts.set(s[i], (counts.get(s[i]) ?? 0) + 1);
        }

        for (let i = 0; i < t.length; i++){
            if (!counts.has(t[i])) return false;

            counts.set(t[i], counts.get(t[i]) - 1);
            if (counts.get(t[i])===0){
                counts.delete(t[i]);
            }
        }

        return counts.size===0;
    }
}
