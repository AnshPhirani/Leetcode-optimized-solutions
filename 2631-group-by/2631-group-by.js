/**
 * @param {Function} fn
 * @return {Array}
 */
Array.prototype.groupBy = function(fn) {
    return this.reduce((res, value) => {
        const key = fn(value);
        if(!res[key]) res[key] = [];
        res[key].push(value);
        return res;
    }, {});
};

/**
 * [1,2,3].groupBy(String) // {"1":[1],"2":[2],"3":[3]}
 */