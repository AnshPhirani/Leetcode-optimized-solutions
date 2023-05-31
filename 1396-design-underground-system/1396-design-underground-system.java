class Entry{
    int id;
    String stationName;
    int t;
    public Entry(int id, String stationName, int t){
        this.id = id;
        this.stationName = stationName;
        this.t = t;
    }
}


class UndergroundSystem {
    private Map<Integer, Entry> checkIn;
    private Map<String, List<Integer>> travelTime;
    
    public UndergroundSystem() {
        this.checkIn = new HashMap<>();
        this.travelTime = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkIn.put(id, new Entry(id, stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        String from = checkIn.get(id).stationName;
        String to = stationName;
        int curTripTime = t - checkIn.get(id).t;
        checkIn.remove(id);
        
        String key = from+"*"+to;
        travelTime.computeIfAbsent(key, k -> new ArrayList<>()).add(curTripTime);
    }
    
    public double getAverageTime(String from, String to) {
        String key = from+"*"+to;
        double totalTime = 0;
        int totalTrips = travelTime.get(key).size();
        for(int time : travelTime.get(key)){
            totalTime += time;
        }
        return totalTime/totalTrips;
        
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */