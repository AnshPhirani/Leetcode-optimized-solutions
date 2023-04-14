/**
 * @param {Function} fn
 * @param {number} t
 * @return {Function}
 */
var timeLimit = function(fn, t) {
    const maxTimeLimit = t;
	return async function(...args) {
        const promise1 = new Promise((resolve, reject) => {
            setTimeout(() => reject("Time Limit Exceeded"), maxTimeLimit);
        });
        
        const promise2 = fn(...args)
        
        return Promise.race([promise1, promise2]);
    }
};

/**
 * const limited = timeLimit((t) => new Promise(res => setTimeout(res, t)), 100);
 * limited(150).catch(console.log) // "Time Limit Exceeded" at t=100ms
 */