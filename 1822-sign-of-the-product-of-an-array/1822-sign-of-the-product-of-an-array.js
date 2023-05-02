/**
 * @param {number[]} nums
 * @return {number}
 */
var arraySign = function(nums) {
    let negCount = 0;

    for(let num of nums){
        if(num == 0) return 0;
        if(num < 0) negCount++;
    }

    return (negCount%2 == 0) ? 1 : -1;
};