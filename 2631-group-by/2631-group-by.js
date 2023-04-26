/**
 * @param {Function} fn
 * @return {Array}
 */
Array.prototype.groupBy = function(fn) {
    const obj = {};
    for(const ele of this){
        const key = fn(ele);
        if(!obj[key]) obj[key] = [];
        obj[key].push(ele);
    }
    return obj;
};

/**
 * [1,2,3].groupBy(String) // {"1":[1],"2":[2],"3":[3]}
 */