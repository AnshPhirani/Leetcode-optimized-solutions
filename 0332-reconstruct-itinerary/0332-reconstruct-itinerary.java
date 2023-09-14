
class Pair<K, V>{
    K key;
    V value;
    
    public Pair(K key, V value){
        this.key = key;
        this.value = value;
    }
    
    public String toString(){
        return "[" + key + " " + value + "]";
    }
}

class Solution {
    private Map<String, List<Pair<String, Boolean>>> adj;
    
    private boolean dfs(String from, int ticketsUsed, int totalTickets, List<String> ans){
        ans.add(from);
        
        if(ticketsUsed == totalTickets){
            return true;
        }
        
        for(Pair<String, Boolean> neigh : adj.getOrDefault(from, new ArrayList<>())){
            String to = neigh.key;
            boolean used = neigh.value;
            if(used) continue;
            
            neigh.value = true;
            if(dfs(to, ticketsUsed+1, totalTickets, ans)) return true;
            neigh.value = false;
        }
        
        ans.remove(ans.size()-1);
        return false;
    }
    
    public List<String> findItinerary(List<List<String>> tickets) {
        this.adj = new HashMap<>();
        for(List<String> ticket : tickets){
            String from = ticket.get(0), to = ticket.get(1);
            adj.putIfAbsent(from, new ArrayList<>());
            adj.get(from).add(new Pair(to, false));
        }
        
        for(String from : adj.keySet()){
            Collections.sort(adj.get(from), (a, b) -> a.key.compareTo(b.key));
        }
        
        List<String> ans = new ArrayList<>();
        dfs("JFK", 0, tickets.size(), ans);
        return ans;
    }
}