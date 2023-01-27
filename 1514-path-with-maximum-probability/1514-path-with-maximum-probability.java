class Pair{
    int node;
    double prob;
    public Pair(int node, double prob){
        this.node = node;
        this.prob = prob;
    }
    
}

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < edges.length; i++){
            int[] edge = edges[i];
            adj.get(edge[0]).add(new Pair(edge[1], succProb[i]));
            adj.get(edge[1]).add(new Pair(edge[0], succProb[i]));
        }
        
        double[] probability = new double[n];
        Arrays.fill(probability, -1);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            return (b.prob > a.prob) ? 1 : (b.prob < a.prob) ? -1 : 0;
        });
        pq.add(new Pair(start, 1.0));
        
        while(!pq.isEmpty()){
            Pair cur = pq.poll();
            if(probability[cur.node] != -1) continue;
            probability[cur.node] = cur.prob;
            
            for(Pair neigh : adj.get(cur.node)){
                double newProb = cur.prob * neigh.prob;
                pq.add(new Pair(neigh.node, newProb));
            }
            
        }
        
        return probability[end] != -1 ? probability[end] : 0;
        
        
    }
}