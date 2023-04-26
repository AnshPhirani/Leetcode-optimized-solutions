/**
 * @param {Array} arr
 * @return {Generator}
 */
var inorderTraversal = function*(arr) {
    if(typeof arr == "number"){
        yield arr;
        return;
    }

    for(let ele of arr){
        yield* inorderTraversal(ele);
    }
    
};

/**
 * const gen = inorderTraversal([1, [2, 3]]);
 * gen.next().value; // 1
 * gen.next().value; // 2
 * gen.next().value; // 3
 */