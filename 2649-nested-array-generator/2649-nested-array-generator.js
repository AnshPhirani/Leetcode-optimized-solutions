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
        const gen = inorderTraversal(ele);
        let cur = gen.next();
        while(!cur.done){
            yield cur.value;
            cur = gen.next();
        }
    }
    
};

/**
 * const gen = inorderTraversal([1, [2, 3]]);
 * gen.next().value; // 1
 * gen.next().value; // 2
 * gen.next().value; // 3
 */