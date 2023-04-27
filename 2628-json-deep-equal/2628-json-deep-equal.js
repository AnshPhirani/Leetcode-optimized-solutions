/**
 * @param {any} o1
 * @param {any} o2
 * @return {boolean}
 */

var areDeeplyEqual = function(o1, o2) {
    if(typeof o1 != typeof o2) return false;
    if(typeof o1 !== "object") return o1 === o2;
    if(o1 === null || o2 === null) return o1 === null && o2 === null; 
    
    if((!Array.isArray(o1) && Array.isArray(o2)) || (Array.isArray(o1) && !Array.isArray(o2))){
        return false;
    }
    
    if(Object.keys(o1).length != Object.keys(o2).length) return false;
    for(let key in o1){
        if(!o2.hasOwnProperty(key) || !areDeeplyEqual(o1[key], o2[key])) return false;
    }
    
    return true;
};