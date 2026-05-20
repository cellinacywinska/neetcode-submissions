class Solution {
    /**
     * @param {string[]} strs
     * @return {string[][]}
     */
    groupAnagrams(strs) {
        const groups = new Map();

        for (let s of strs){
            let letters = new Array(26).fill(0);

            for (let ch of s){
                letters[ch.charCodeAt()-'a'.charCodeAt()]++;
            }

            const key = letters.join();

            if (!groups.has(key)){
                groups.set(key, []);
            }

            groups.get(key).push(s);
        }

        return Array.from(groups.values());   
    }
}
