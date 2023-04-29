/**
 * @param {any[]} arr
 * @param {number} depth
 * @return {any[]}
 */
var flat = function (arr, n) {
    if(n === 0) return arr;
    let flatArr = [];
    for(const ele of arr){
        if(Array.isArray(ele)){
            flatArr.push(...flat(ele, n-1));
        }
        else{
            flatArr.push(ele);
        }
    }
    return flatArr;
};