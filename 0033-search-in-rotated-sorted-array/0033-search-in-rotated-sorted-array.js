/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
    let l = 0, h = nums.length-1;
    while(l <= h){
        let mid = Math.floor((l+h)/2);
        if(nums[mid] == target) return mid;
        
        if(nums[mid] >= nums[l]){ // left side is sorted
            if(target >= nums[l] && target < nums[mid]) h = mid-1;
            else l = mid+1;
        }
        else{ // right side is sorted
            if(target > nums[mid] && target <= nums[h]) l = mid+1;
            else h = mid-1;
        }
    }
    
    return -1;
    
};