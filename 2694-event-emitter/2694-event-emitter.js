class EventEmitter {
    
    constructor(){
        this.events = {};
        this.eventNumber = 0;
    }
    
  subscribe(event, cb) {
      const events = this.events;
      const eventNumber = this.eventNumber++;
      
      if(!events.hasOwnProperty(event)) events[event] = {};
      events[event][eventNumber] = {callback : cb};
      
    return {
        unsubscribe: () => {
            delete events[event][eventNumber];
        }
    };
  }

  emit(event, args = []) {
      const events = this.events;
      if(!events[event]) return []; // no event are present
      
      const response = [];
      for(let eventNumber of Object.keys(events[event]).sort()){
          const callback = events[event][eventNumber].callback;
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