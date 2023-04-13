/**
 * @param {number[]} nums
 * @param {Function} fn
 * @param {number} init
 * @return {number}
 */
var reduce = function(nums, fn, init) {
    for(let ele of nums){
        init = fn(init, ele);
    }
    return init;
};