/**
 * @return {Generator<number>}
 */

var fibGenerator = function*() {
    let first = 0;
    let second = 1;
    while(true){
        yield first;
        [first, second] = [second, first+second];
    }
    
};


/**
 * const gen = fibGenerator();
 * gen.next().value; // 0
 * gen.next().value; // 1
 */