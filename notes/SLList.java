// Never give up
class SLList<LochNess>{
    private IntNode sentinel;
    private int sz=0;
    private IntNode last_sentinel;
    public class IntNode{
        public LochNess item;
        public IntNode next;
        public IntNode(LochNess i, IntNode n){
            item = i;
            next = n;
        }
        
    }
    // public SLList(){
    //     sentinel = new IntNode(-1,null);
        
    //     sz = 0;
    // }
    public SLList(LochNess f){
        sentinel = new IntNode(f,null);
        
        IntNode first = new IntNode(f,null);
        sentinel.next = first;
        sz+=1;
    }
    public void addFirst(LochNess x){
        sz+=1;
        IntNode first = new IntNode(x,sentinel.next);
        sentinel.next = first;
    }
    public LochNess getFirst(){
        return sentinel.next.item;
    }
    public void addLast(LochNess x){
        IntNode f = sentinel;
        sz+=1;
        while(f.next!=null){
            f = f.next;
        }
        f.next = new IntNode(x,null);
    }
    // private static int size(IntNode f){
    //     if(f.next==null){
    //         return 1;
    //     }
    //     return 1+size(f.next);
    // }
    public int size(){
        // IntNode p = this.first;
        // int sz = 0;
        // while(p!=null){
        //     p = p.next;
        //     sz+=1;
        // }
        // return size(first);
        return sz;
    }
    public static void main(String[] args) {
        SLList<Integer> l = new SLList<Integer>(5);
        l.addFirst(3);
        l.addFirst(334);
        l.addLast(21);
        
    }
}