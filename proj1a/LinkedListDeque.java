class LinkedListDeque<T>{
    Node sentinel;
    int sz = 0;
    class Node{
        T item;
        Node nxt,prev;
        public Node(T item,Node nxt,Node prev){
            this.item = item;
            this.nxt = nxt;
            this.prev = prev;
        }
        // or equally Node(Node nxt,Node pre) without caring the type
    }

    public LinkedListDeque(){
        sentinel = new Node(null,null,null);
        sentinel.nxt = sentinel;
        sentinel.prev = sentinel;
        sz = 0;
    }

    public void addFirst(T val){
        sz += 1;
        sentinel.nxt = new Node(val,sentinel.nxt,sentinel);
        sentinel.nxt.nxt.prev = sentinel.nxt;
    // Node add_node = new Node(val,sentinel.nxt,sentinel)
    // sentinel.nxt.prev = add_node
    // sentinel.nxt = add_node
    }

    public void addLast(T val){
        sz += 1;
        sentinel.prev.nxt = new Node(val,sentinel,sentinel.prev);
        sentinel.prev = sentinel.prev.nxt;
    }

    public boolean isEmpty(){
        return sz == 0;
    }

    public int size(){
        return sz;
    }

    public void printDeque(){
        Node p = sentinel;
        while(p.nxt != sentinel){
            p = p.nxt;
            System.out.print(p.item);
            if(p.nxt != sentinel){
                System.out.print(" ");
            }
            else
                System.out.println();
        }
    }

    public T removeFirst(){
        sz -= 1;
        T val = sentinel.nxt.item;
        sentinel.nxt = sentinel.nxt.nxt;
        sentinel.nxt.prev = sentinel;
        return val;
    }

    public T removeLast(){
        sz -= 1;
        T val = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.nxt = sentinel;
        return val;
    }

    public T get(int index){
        if(this.size() == 0){
            System.out.println("This list has no element");
            return sentinel.item;
        }
        Node p = sentinel.nxt;
        while(index-- != 0){
            p = p.nxt;
        }
        return p.item;
    }
    
    public T getRecursive(Node p, int index){
        if(p.nxt == sentinel && index!=0){
            System.out.println("Wrong index!");
            return sentinel.item;
        }
        else if (index == 0){
            return p.item;
        }
        else{
            return getRecursive(p.nxt, index-1);
        }
    }

    public T getRecursive(int index){
        return getRecursive(sentinel.nxt, index);
    }

    public static void main(String[] args) {
        LinkedListDeque<String> LLD = new LinkedListDeque<>();
        LLD.addFirst("First");
        LLD.addLast("Second");
        LLD.addLast("Third");
        LLD.addLast("Forth");
        // LLD.removeLast(); 
        // LLD.removeFirst();
        System.out.println(LLD.getRecursive(4));
        LLD.printDeque();
    }
}