
var TimeLimitedCache = function() {
    this.store = {};
};

/** 
 * @param {number} key
 * @param {number} value
 * @param {number} time until expiration in ms
 * @return {boolean} if un-expired key already existed
 */
TimeLimitedCache.prototype.set = function(key, value, duration) {
    const store = this.store;
    // console.log(this.store)
    const curTime = Date.now();
    if(store[key]){
        const isExpired = store[key].expiryTime > curTime;
        store[key].value = value;
        store[key].expiryTime = curTime + duration;
        console.log(this.store)
        return isExpired;
    }
    store[key] = {};
    store[key].value = value;
    store[key].expiryTime = curTime + duration;
    console.log(this.store)
    return false;
};

/** 
 * @param {number} key
 * @return {number} value associated with key
 */
TimeLimitedCache.prototype.get = function(key) {
    const store = this.store;
    console.log(this.store)
    const curTime = Date.now();
    console.log(curTime)
    if(store[key] && store[key].expiryTime > curTime){
        return store[key].value;
    }
    return -1;
};

/** 
 * @return {number} count of non-expired keys
 */
TimeLimitedCache.prototype.count = function() {
    const curTime = Date.now();
    let count = 0;
    for(let key in this.store){
        if(this.store[key].expiryTime > curTime) count++;
    }
    return count;
};

/**
 * Your TimeLimitedCache object will be instantiated and called as such:
 * var obj = new TimeLimitedCache()
 * obj.set(1, 42, 1000); // false
 * obj.get(1) // 42
 * obj.count() // 1
 */