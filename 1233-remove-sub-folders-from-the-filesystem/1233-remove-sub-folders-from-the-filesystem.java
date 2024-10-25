class TrieNode{
    String folderName;
    boolean ends;
    Map<String, TrieNode> childrens;
    public TrieNode(String folderName){
        this.folderName = folderName;
        ends = false;
        childrens = new HashMap<>();
    }
}

class Solution {

    private void addToTrie(TrieNode root, int idx,  String[] path){
        if(idx == path.length){
            root.ends = true;
            return;
        }
        String curFolder = path[idx];
        if(!root.childrens.containsKey(curFolder)) root.childrens.put(curFolder, new TrieNode(curFolder));
        addToTrie(root.childrens.get(curFolder), idx+1, path);

    }

    private boolean isSubFolder(TrieNode root, int idx,  String[] path){
        if(idx == path.length){
            return false;
        }
        if(root.ends) return true;
    
        String curFolder = path[idx];
        return isSubFolder(root.childrens.get(curFolder), idx+1, path);
    }
   
    public List<String> removeSubfolders(String[] folder) {
        TrieNode root = new TrieNode("");
        for(String path : folder){
            addToTrie(root, 0, path.substring(1).split("/"));
        }

        List<String> ans = new ArrayList<>();
        for(String path : folder){
            if(!isSubFolder(root, 0,  path.substring(1).split("/")))
                ans.add(path);
        }

        return ans;

    }
}