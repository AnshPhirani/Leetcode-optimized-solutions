/**
 * @param {Function} fn
 */
function memoize(fn) {
    const root = new Map(); // Trie's root
    return function(...args) {
        let cur = root;
        for(let arg of args){
            if(!cur.has(arg)) cur.set(arg, new Map());
            cur = cur.get(arg);
        }
        if(!cur.has("result")) cur.set("result", fn(...args));
        return cur.get("result");
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