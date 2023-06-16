/**
 * @param {Object} obj
 * @return {Object}
 */
var compactObject = function(obj) {
    
    let compactObj = Array.isArray(obj) ? [] : {};
    
    for(let key in obj){
        let val = obj[key];
        if(val === null || ["string", "number", "boolean"].includes(typeof val)){
            if(Boolean(val)) {
                if(Array.isArray(compactObj)) compactObj.push(val);
                else compactObj[key] = val;
            }
        }
        else{
            if(Array.isArray(compactObj)) compactObj.push(compactObject(val));
            else compactObj[key] = compactObject(val);
        }
    }
    
    return compactObj;
};