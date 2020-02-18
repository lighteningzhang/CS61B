public class SLList{
    private IntNode first;
    private class IntNode{
        public int item;
        public IntNode next;
        public IntNode(int item, IntNode next){
            this.item = item;
            this.next = next;
        }
    }

    SLList(int x){
        first = new IntNode(x,null);
    }
    
    public void addFirst(int x){
        first = new IntNode(x,first);
    }

    public void insert(int x, int pos){
        IntNode st = first;
        pos-=1;
        while(st.next!=null && pos!=0){
            st = st.next;
            pos--;
        }
        if(pos==-1){

            this.addFirst(x);
        }
        else
            st.next = new IntNode(x,st.next);
    }

    public void reverse(){
        IntNode prev,cur;
        IntNode p = first;
        prev = null;
        cur = first;
        while(p!=null){
            p = p.next;
            cur.next = prev;
            prev = cur;
            cur = p;
        }
        first = prev;
    }
    
    public void helper(IntNode p,IntNode prev){
        if(p.next!=null){
            helper(p.next,p);
            p.next = prev;
        }
        else{
            first = p;
            p.next = prev;
            // prev.next = null;
        }
    }

    public static IntNode helper(IntNode p){
        if(p==null)
            return p;
        else if(p.next == null)
            return p;
        else{
            IntNode re = helper(p.next);
            p.next.next =  p;
            p.next = null;
            return re;
        }
    }

    public static IntNode reverse(IntNode first){
        first = helper(first);
        return first;
    }

    public void reverseIt(){
        helper(first,null);
    }

    public void print(){
        IntNode p = first;
        while(p!=null){
            System.out.print(p.item);
            System.out.print(" ");
            p = p.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        SLList ll = new SLList(2);
        ll.addFirst(3);
        ll.addFirst(5);
        ll.addFirst(7);
        ll.insert(8, 3);
        System.out.println("Before reversing: ");
        ll.print();
        ll.first = reverse(ll.first);
        System.out.println("After reversing: ");
        ll.print();
    }
}