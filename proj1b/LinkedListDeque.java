import java.util.LinkedList;

public class LinkedListDeque<T> extends LinkedList<T> implements Deque<T>{
    private Node sentinel;
    private int sz = 0;
    private class Node{
        private T item;
        private Node nxt,prev;
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

    @Override
    public void addFirst(T val){
        sz += 1;
        sentinel.nxt = new Node(val,sentinel.nxt,sentinel);
        sentinel.nxt.nxt.prev = sentinel.nxt;
    // Node add_node = new Node(val,sentinel.nxt,sentinel)
    // sentinel.nxt.prev = add_node
    // sentinel.nxt = add_node
    }

    @Override
    public void addLast(T val){
        sz += 1;
        sentinel.prev.nxt = new Node(val,sentinel,sentinel.prev);
        sentinel.prev = sentinel.prev.nxt;
    }

    @Override
    public boolean isEmpty(){
        return sz == 0;
    }

    @Override
    public int size(){
        return sz;
    }

    @Override
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

    @Override
    public T removeFirst(){
        if(sz == 0)
            return null;
        sz -= 1;
        T val = sentinel.nxt.item;
        sentinel.nxt = sentinel.nxt.nxt;
        sentinel.nxt.prev = sentinel;
        return val;
    }

    @Override
    public T removeLast(){
        if(sz == 0)
            return null;
        sz -= 1;
        T val = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.nxt = sentinel;
        return val;
    }

    @Override
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

    private T getRecursive(Node p, int index){
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

    private T getRecursive(int index){
        return getRecursive(sentinel.nxt, index);
    }

}

