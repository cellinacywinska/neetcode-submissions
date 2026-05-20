class Solution {
    /**
     * @param {number[]} nums
     * @param {number} k
     * @return {number[]}
     */
    topKFrequent(nums, k) {
        let counts = new Map();

        for (let n of nums){
            counts.set(n, (counts.get(n) || 0) +1);
        }

        let freqencyNumbers = [];
        for (let [key,value] of counts){
            freqencyNumbers.push([value, key]);
        }

        freqencyNumbers.sort((a,b)=>a[0]-b[0]);

        let res = [];

        for (let i = freqencyNumbers.length-1; i >= freqencyNumbers.length-k; i--){
            res.push(freqencyNumbers[i][1]);
        }

        return res;
    }
}
