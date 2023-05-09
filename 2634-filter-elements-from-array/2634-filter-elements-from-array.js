/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function(arr, fn) {
    const res = [];
    for(let idx = 0; idx < arr.length; idx++){
        if(fn(arr[idx], idx)) res.push(arr[idx]);
    }
    return res;
};