/**
 * @param {Function} fn
 * @param {number} t
 * @return {Function}
 */
var timeLimit = function(fn, t) {
    const maxTimeLimit = t;
	return async function(...args) {
        return new Promise(async (resolve, reject) =>{
            setTimeout(() => {
                reject("Time Limit Exceeded");
            }, maxTimeLimit);
            
            fn(...args).then((res) => resolve(res)).catch(reject);
        });
    }
};

/**
 * const limited = timeLimit((t) => new Promise(res => setTimeout(res, t)), 100);
 * limited(150).catch(console.log) // "Time Limit Exceeded" at t=100ms
 */