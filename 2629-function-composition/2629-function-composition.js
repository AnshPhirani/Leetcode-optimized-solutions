/**
 * @param {Function[]} functions
 * @return {Function}
 */
var compose = function(functions) {
    functions.reverse();
    return function(x){
        let res = x;
        for(let f of functions){
            res = f(res);
        }
        return res;
    }
};

/**
 * const fn = compose([x => x + 1, x => 2 * x])
 * fn(4) // 9
 */