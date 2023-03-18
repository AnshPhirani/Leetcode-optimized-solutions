
class ListNode{
    String url;
    ListNode next, prev;
    public ListNode(String url){
        this.url = url;
    }
}


class BrowserHistory {

    ListNode homePage, curPage;
    
    public BrowserHistory(String homepage) {
        this.homePage = new ListNode(homepage);
        this.curPage = homePage;
    }
    
    public void visit(String url) {
        
        curPage.next = null; // clears up all the forward history
        
        ListNode newPage = new ListNode(url);
        curPage.next = newPage;
        newPage.prev = curPage;
        curPage = newPage;
    }
    
    public String back(int steps) {
        while(steps > 0 && curPage != homePage){
            curPage = curPage.prev;
            steps--;
        }
        return curPage.url;
    }
    
    public String forward(int steps) {
        while(steps > 0 && curPage.next != null){
            curPage = curPage.next;
            steps--;
        }
        return curPage.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */