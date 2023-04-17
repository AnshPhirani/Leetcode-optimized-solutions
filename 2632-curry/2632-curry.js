/**
 * @param {Function} fn
 * @return {Function}
 */
var curry = function(fn) {
 
    return function curried(...curArgs) {
        if(curArgs.length == fn.length) return fn(...curArgs);
        return function(...remainingArgs){
            return curried(...curArgs, ...remainingArgs);
        }
    }
};

/**
 * function sum(a, b) { return a + b; }
 * const csum = curry(sum);
 * csum(1)(2) // 3
 */
