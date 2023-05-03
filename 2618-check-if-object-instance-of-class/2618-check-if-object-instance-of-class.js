/**
 * @param {any} object
 * @param {any} classFunction
 * @return {boolean}
 */
var checkIfInstanceOf = function(obj, classFunction) {
    if(obj == null) return false;
    if(obj.constructor == classFunction) return true;
    
    return checkIfInstanceOf(obj.__proto__, classFunction);
    

};

/**
 * checkIfInstanceOf(new Date(), Date); // true
 */