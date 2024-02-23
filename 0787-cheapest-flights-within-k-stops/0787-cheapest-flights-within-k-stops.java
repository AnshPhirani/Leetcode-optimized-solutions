class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] flight : flights) {
            adj[flight[0]].add(new int[] { flight[1], flight[2] });
        }

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] { src, 0, k });
        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[src] = 0;

        int level = 0;
        while (!que.isEmpty() && level <= k) {
            int size = que.size();
            while (size-- > 0) {
                int[] cur = que.poll();
                int curCity = cur[0], curPrice = cur[1], remainingK = cur[2];

                // if(remainingK < 0) continue;
                for (int[] neigh : adj[curCity]) {
                    int nextCity = neigh[0], cost = neigh[1];
                    if (curPrice + cost < minCost[nextCity]) {
                        que.add(new int[] { nextCity, curPrice + cost, remainingK - 1 });
                        minCost[nextCity] = curPrice + cost;
                    }
                }
            }

            level++;
        }

        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }
}
