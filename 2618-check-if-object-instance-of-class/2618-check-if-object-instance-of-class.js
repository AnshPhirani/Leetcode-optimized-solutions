/**
 * @param {any} obj
 * @param {any} classFunction
 * @return {boolean}
 */
var checkIfInstanceOf = function(obj, classFunction) {
    if(obj === null || obj === undefined || classFunction === undefined || classFunction === null) return false;
    if(obj.__proto__ === classFunction.prototype) return true;
    
    return checkIfInstanceOf(obj.__proto__, classFunction);
    
};




/**
 * checkIfInstanceOf(new Date(), Date); // true
 */