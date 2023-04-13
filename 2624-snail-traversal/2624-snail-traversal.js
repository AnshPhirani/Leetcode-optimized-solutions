/**
 * @param {number} rowsCount
 * @param {number} colsCount
 * @return {Array<Array<number>>}
 */
Array.prototype.snail = function(rowsCount, colsCount) {
    if(this.length != rowsCount*colsCount) return [];
    
    const mat = new Array(rowsCount);
    for(let i = 0; i < rowsCount; i++) mat[i] = [];
    
    let k = 0;
    for(let j = 0; j < colsCount; j++){
        // top to bottom
        if(j%2 == 0){
            for(let i = 0; i < rowsCount; i++){
                mat[i][j] = this[k++];
            }
        }
        // bottom to top
        else{
            for(let i = rowsCount-1; i >= 0; i--){
                mat[i][j] = this[k++];
            }
        }
    }
    
    return mat;
}

/**
 * const arr = [1,2,3,4];
 * arr.snail(1,4); // [[1,2,3,4]]
 */