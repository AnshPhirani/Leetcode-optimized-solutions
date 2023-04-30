/**
 * @param {Function[]} functions
 * @param {number} n
 * @return {Function}
 */
var promisePool = async function(functions, n) {
    return new Promise(resolve => {
        
        if(functions.length === 0) resolve();
        
        var idx = 0;
        var inRunning = 0;
        
        const next = () => {   
            if(idx < functions.length){
                functions[idx]().then(next);
                idx++;
            }
            else{
                inRunning--;
            }
            
            if(inRunning === 0) resolve();
        }

        while(idx < Math.min(functions.length, n)){
            functions[idx]().then(next);
            inRunning++;
            idx++;
        }
    });
};

/**
 * const sleep = (t) => new Promise(res => setTimeout(res, t));
 * promisePool([() => sleep(500), () => sleep(400)], 1)
 *   .then(console.log) // After 900ms
 */