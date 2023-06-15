/**
 * @param {Array<Function>} functions
 * @return {Promise<any>}
 */
var promiseAll = async function(functions) {
    return new Promise((resolve, reject) => {
        const responses = [];
        let resolvedCount = 0;
        for(let idx in functions){
            functions[idx]()
                .then((response) => {
                responses[idx] = response;
                resolvedCount++;
                if(resolvedCount === functions.length) resolve(responses);
            }).catch(reject)
        }
    });
};

/**
 * const promise = promiseAll([() => new Promise(res => res(42))])
 * promise.then(console.log); // [42]
 */