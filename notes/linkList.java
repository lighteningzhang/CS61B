public class linkList{
    public node first;
    public linkList rest;
    public linkList(int x){
        first = new node(x,null);
    }
    public linkList(int x,linkList l){
        first = new node(x,first);
        this.rest = l;
    }
    public void addFirst(int x){
        first = new node(x,first);
    }
    /**Return the first element */
    public int getFirst(){
        return first.val;
    }
    public static void main(String[] args) {
        linkList l = new linkList(2);
        l = new linkList(100,l);
        l = new linkList(50,l);
        System.out.println(l.getIt(0));

    }
    /** adds node to front of a linklist */
    public void add(node n){
        first.next = n;

    }
    public int iterativeSize(){
        linkList l = this;
        int sz = 0;
        while(l!=null){
            sz += 1;
            l = l.rest;
        }
        return sz;
    }
    public int size(){
        if(rest==null)
            return 1;
        else
            return 1+this.rest.size();
    }
    public int get(int i){
        if(i==0){
            return first.val;
        }
        return this.rest.get(i-1);
    }
    public int getIt(int i){
        linkList l = this;
        while(i!=0){
            i--;
            l = l.rest;
        }
        return l.first.val;
    }
    public static int pass_node_size(node n){
        if(n.next==null)
            return 1;
        else
            return pass_node_size(n.next)+1;
    }
    public static int pass_node_iterativeSize(node n){
        int sz = 0;
        while(n !=null){
            sz += 1;
            n = n.next;
        }
        return sz;
    }


}