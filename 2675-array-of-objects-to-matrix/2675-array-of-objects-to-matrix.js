var objectToDict = (obj, path) => {
    if(typeof obj !== "object" || obj === null) return{[path] : obj};
    
    let res = {};
    for(let key in obj){
        let newPath = path + (path.length > 0? "." : "") + key;
        let curRes = objectToDict(obj[key], newPath);
        res = {...res, ...curRes};
    }
    return res;
}

var jsonToMatrix = function(arr) {
    const dicts = [];
    for(let obj of arr){
        dicts.push(objectToDict(obj, ""));
    }
    
    let set = new Set();
    for(let dict of dicts){
        for(let path in dict) set.add(path);
    }
    
    let cols = [...set];
    cols.sort(); 
    
    let n = arr.length;
    let m = cols.length;
    
    const res = [];
    res[0] = cols;
    for(let i = 0; i < n; i++){
        let curRow = new Array(m).fill("");
        let curDict = dicts[i];
        for(let j = 0; j < m; j++){
            let path = cols[j];
            if(curDict.hasOwnProperty(path)) curRow[j] = curDict[path];
        }
        res.push(curRow);
    }
    
    return res;
};