/**
 * @param {number[]} nums
 * @param {Function} fn
 * @param {number} init
 * @return {number}
 */
var reduce = function(nums, fn, init) {
    let ans = init;
    for(let ele of nums){
        ans = fn(ans, ele);
    }
    return ans;
};