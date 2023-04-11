/**
 * @param {string} s
 * @return {string}
 */
var removeStars = function(s) {
    const stack = [];
    for(let ch of s){
        if(ch == '*') stack.pop();
        else stack.push(ch);
    }
    
    let res = '';
    stack.reverse();
    while(stack.length > 0) res += stack.pop();
    return res;
    
};