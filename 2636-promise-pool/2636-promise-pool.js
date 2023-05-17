/**
 * @param {Function[]} functions
 * @param {number} n
 * @return {Function}
 */
var promisePool = async function(functions, n) {
    return new Promise(res => {
        if(functions.length == 0) res();
        
        let inRunning = 0;
        let idx = 0;
        function next(){
            if(idx === functions.length){
                inRunning--;
                if(inRunning == 0) res();
            }
            else{
                functions[idx++]().then(next);
            }
        }

        while(idx < Math.min(n, functions.length)){
            inRunning++;
            functions[idx++]().then(next);
        } 
    });
};

/**
 * const sleep = (t) => new Promise(res => setTimeout(res, t));
 * promisePool([() => sleep(500), () => sleep(400)], 1)
 *   .then(console.log) // After 900ms
 */