class EventEmitter {
    
    constructor(){
        this.events = {};
    }
    
  subscribe(event, cb) {
      const events = this.events;
 
      if(!events.hasOwnProperty(event)) events[event] = [];
      events[event].push(cb);
      
    return {
        unsubscribe: () => {
            events[event] = events[event].filter(fn => fn !== cb);
            if(events[event].length === 0) delete events[event];
        }
    };
  }

  emit(event, args = []) {
      const events = this.events;
      if(!events[event]) return []; // no event are present
      
      const response = [];
      for(let callback of events[event]){
          response.push(callback(...args));
      }
      return response;
  }
}

/**
 * const emitter = new EventEmitter();
 *
 * // Subscribe to the onClick event with onClickCallback
 * function onClickCallback() { return 99 }
 * const sub = emitter.subscribe('onClick', onClickCallback);
 *
 * emitter.emit('onClick'); // [99]
 * sub.unsubscribe(); // undefined
 * emitter.emit('onClick'); // []
 */