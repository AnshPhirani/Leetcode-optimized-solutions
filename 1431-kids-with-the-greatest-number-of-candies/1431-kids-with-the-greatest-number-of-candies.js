/**
 * @param {number[]} candies
 * @param {number} extraCandies
 * @return {boolean[]}
 */
var kidsWithCandies = function(candies, extraCandies) {
        const maxCandies = candies.reduce((ele, curMax) => Math.max(ele, curMax), 0);
    
        const res = [];
    
        for(let candiesCount of candies){
            res.push(candiesCount + extraCandies >= maxCandies);
        }
        
        return res;
};