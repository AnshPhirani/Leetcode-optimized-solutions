/**
 * @param {string} word1
 * @param {string} word2
 * @return {string}
 */
var mergeAlternately = function(word1, word2) {
    let res = "";
    const n = word1.length, m = word2.length;
    let i = 0, j = 0;
    while(i < n && j < m){
        res += word1[i++] + word2[j++];
    }
    while(i < n) res += word1[i++];
    while(j < m) res += word2[j++];
    return res;
};