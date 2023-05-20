/**
 * @param {Function} fn
 * @param {number} t
 * @return {Function}
 */
var throttle = function(fn, t) {
    let timeout = null;
    let curArgs = null;
    
    const timeoutFunction = () => {
        if(!curArgs){
            timeout = null;
        }
        else{
            fn(...curArgs);
            curArgs = null;
            timeout = setTimeout(timeoutFunction, t);
        }
    }
    
    return function throttled(...args) {
       curArgs = [...args];
       if(!timeout){
           fn(...args);
           curArgs = null;
           timeout = setTimeout(timeoutFunction, t);
       } 
    }
};

/**
 * const throttled = throttle(console.log, 100);
 * throttled("log"); // logged immediately.
 * throttled("log"); // logged at t=100ms.
 */