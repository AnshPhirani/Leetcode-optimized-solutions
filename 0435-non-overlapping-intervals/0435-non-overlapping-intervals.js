/**
 * @param {number[][]} intervals
 * @return {number}
 */
var eraseOverlapIntervals = function(intervals) {
    
    intervals.sort((a, b) => a[0]-b[0]);
    
    let prevEnd = intervals[0][1];
    let count = 0;
    for(let idx = 1; idx < intervals.length; idx++){
        let [start, end] = intervals[idx];
        if(start >= prevEnd){
            prevEnd = end;
        }
        else{
            count++;
            prevEnd = Math.min(prevEnd, end);
        }
    }
    return count;
};