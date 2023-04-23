/**
 * @return {Generator<number>}
 */

var fibGenerator = function*() {
    let first = 0;
    let second = 1;
    yield first;
    yield second;
    while(true){
        [first, second] = [second, first+second];
        yield second;
    }
    
};


/**
 * const gen = fibGenerator();
 * gen.next().value; // 0
 * gen.next().value; // 1
 */