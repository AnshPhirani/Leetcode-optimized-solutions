/**
 * @param {Function} fn
 * @return {Function}
 */
var curry = function(fn) {
    const args = [];
    const argsLen = fn.length;
    return function curried(...curArgs) {
        args.push(...curArgs);
        if(args.length == argsLen) return fn(...args);
        return curried;
    };
};

/**
 * function sum(a, b) { return a + b; }
 * const csum = curry(sum);
 * csum(1)(2) // 3
 */
