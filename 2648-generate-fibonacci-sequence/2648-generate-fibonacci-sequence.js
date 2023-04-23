/**
 * @return {Generator<number>}
 */

var fibGenerator = function*() {
    let first = 0;
    let second = 1;
    while(true){
        yield first;
        let temp = second;
        second = first+second;
        first = temp;
    }
    
};

// const gen = fibGenerator();
// console.log(JSON.stringify(gen));

/**
 * const gen = fibGenerator();
 * gen.next().value; // 0
 * gen.next().value; // 1
 */