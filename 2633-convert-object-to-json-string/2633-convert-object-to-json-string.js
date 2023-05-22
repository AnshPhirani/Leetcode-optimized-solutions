/**
 * @param {any} object
 * @return {string}
 */
var jsonStringify = function(object) {
    if(typeof object === "number" || typeof object === "boolean" || object === null){
        return object;
    }
    else if(typeof object === "string"){
        return '"' + object + '"'; 
    }
    else if(Array.isArray(object)){
        let str = "[";
        for(let idx = 0; idx < object.length; idx++){
            str += jsonStringify(object[idx]);
            if(idx != object.length-1) str += ",";
        }
        str += "]";
        return str;
    }
    else{
        if(Object.keys(object).length === 0) return "{}";
        
        let str = "{";
        for(let key in object){
            str +=  '"' + key + '":' + jsonStringify(object[key]) + ",";
        }
        str = str.substring(0, str.length-1);
        str += "}";
        return str;
    }
    
};