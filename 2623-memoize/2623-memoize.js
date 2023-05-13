/**
 * @param {Function} fn
 */
function memoize(fn) {
    const memo = {};
    return function(...args) {
        let key;
        if(args.length == 2){
            key = args[0] + "*" + args[1];
        }
        else{
            key = args[0];
        }
        
        if(memo.hasOwnProperty(key)) return memo[key];
        return memo[key] = fn(...args);
        
    }
}


/** 
 * let callCount = 0;
 * const memoizedFn = memoize(function (a, b) {
 *	 callCount += 1;
 *   return a + b;
 * })
 * memoizedFn(2, 3) // 5
 * memoizedFn(2, 3) // 5
 * console.log(callCount) // 1 
 */