/**
 * @param {Function} fn
 * @return {Function}
 */
var curry = function(fn) {
    const args = [];
    return function curried(...curArgs) {
        args.push(...curArgs);
        if(args.length === fn.length) return fn(...args);
        return curried;
    };
};

/**
 * function sum(a, b) { return a + b; }
 * const csum = curry(sum);
 * csum(1)(2) // 3
 */
