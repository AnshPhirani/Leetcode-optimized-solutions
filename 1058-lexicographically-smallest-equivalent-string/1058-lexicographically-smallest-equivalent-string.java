class UnionFind{
    int[] parent;
    int size;

    public UnionFind(int size){
        this.size = size;
        this.parent = new int[size];
        for(int i = 0; i < size; i++) parent[i] = i;
    }

    public int findParent(int u){
        return parent[u] == u ? u : findParent(parent[u]);
    }

    public void union(int u, int v){
        int uParent = findParent(u);
        int vParent = findParent(v);
        if(uParent == vParent) return;
        if(uParent < vParent) parent[vParent] = uParent;
        else parent[uParent] = vParent;
    }
}

class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n = s1.length();
        UnionFind uf = new UnionFind(26);
        for(int i = 0; i < n; i++){
            uf.union(s1.charAt(i)-'a', s2.charAt(i)-'a');
        }

        StringBuilder sb = new StringBuilder();
        for(char ch : baseStr.toCharArray()){
            char eqChar = (char)(uf.findParent(ch-'a') + 'a');
            sb.append(eqChar);
        }
        return sb.toString();

    }
}