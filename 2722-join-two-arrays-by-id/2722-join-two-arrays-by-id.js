/**
 * @param {Array} arr1
 * @param {Array} arr2
 * @return {Array}
 */
var join = function(arr1, arr2) {
    let n = arr1.length, m = arr2.length;
    let i = 0, j = 0;
    
    const res = [];
    
    while(i < n || j < m){
        let first = i < n ? arr1[i] : {id : Number.MAX_VALUE};
        let second = j < m ? arr2[j] : {id : Number.MAX_VALUE};
        if(first.id < second.id){
            res.push(first);
            i++;
        }
        else if(second.id < first.id){
            res.push(second);
            j++;
        }
        else{
            const obj = {...first, ...second};
            res.push(obj);
            i++;
            j++;
        }
    }
    return res;
    
};