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
        Arrays.fill(probability, 0);
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(start, 1.0));
        
        while(!que.isEmpty()){
            Pair cur = que.poll();
            
            for(Pair neigh : adj.get(cur.node)){
                double newProb = cur.prob * neigh.prob;
                if(newProb > probability[neigh.node]){
                    probability[neigh.node] = newProb;
                    que.add(new Pair(neigh.node, newProb));
                }
            }
            
        }
        
        return probability[end];
        
        
    }
}