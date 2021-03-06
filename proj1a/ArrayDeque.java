/**
 * ArrayDeque.java
 * 1. add and remove take constant time
 * 2. initial size is 8
 * 3. For arrays of length 16 or more, usage factor should
 * be at least 25%
 */
public class ArrayDeque<T> {
    private T[] arr;
    private int sz = 0;
    private int nxt_f,nxt_l;
    public ArrayDeque() {
        arr = (T []) new Object[8];
        sz = 0;
        nxt_f = 0;
        nxt_l = 1; 
    }
    
    private T[] resize(int size){
        T[] arr = (T[]) new Object[size];
        return arr;
    }

    private T[] assign_new_arr(T[] n_arr){
        int cur_f =(nxt_f+1)%arr.length;

        for(int i = 1; i <= sz ; i++){
            n_arr[i] = arr[cur_f];
            cur_f = (cur_f+1)%arr.length;
        }
        
        nxt_f = 0;
        nxt_l = sz+1;
        return n_arr;
    }

    public void addFirst(T item){
        sz += 1;
        arr[nxt_f] = item;
        nxt_f = (nxt_f-1+arr.length)%arr.length;
        if(nxt_f == nxt_l){
            T[] n_arr = resize(sz*2);
            arr = assign_new_arr(n_arr);
        }
    }

    public void addLast(T item){
        sz += 1;
        arr[nxt_l] = item;
        nxt_l = (nxt_l+1+arr.length)%arr.length;
        if(nxt_f == nxt_l){
            T[] n_arr = resize(sz*2);//previously written sz*2-1 
            arr = assign_new_arr(n_arr);
        }
    }

    public boolean isEmpty(){
        return sz == 0;
    }

    public int size(){
        return sz;
    }

    public void printDeque(){
        int first = (nxt_f+1)%arr.length; 
        for(int i = 0; i < sz; i++){
            System.out.print(arr[first]);
            first = (first+1)%arr.length;
            if(i != (sz-1)){
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public T removeFirst(){
        if(sz == 0)
            return null;
        sz -= 1;
        nxt_f = (nxt_f+1)%arr.length;
        T val = arr[nxt_f];
        arr[nxt_f] = null;
       if(sz*4<arr.length && arr.length>=16){
            T[] n_arr = resize(arr.length/2);
            arr = assign_new_arr(n_arr);
        }
        return val;
    }

    public T removeLast(){
        if(sz == 0)
            return null;
        sz -= 1;
        nxt_l = (nxt_l-1+arr.length)%arr.length;
        T val = arr[nxt_l];
        arr[nxt_l] = null;
        if(sz*4<arr.length && arr.length>=16){
            T[] n_arr = resize(arr.length/2);
            arr = assign_new_arr(n_arr);
        }
        return val;
    }

    public T get(int index){
        int first = (nxt_f+1)%arr.length;
        
        if(index >= sz){
            return null;
        }
        else if(index == 0){
            return arr[first];
        }
        for(int i = 1; (i <= index) && (index < sz); i++){
            first = (first+1)%arr.length;
        }
        return arr[first];
        
    }

    // public static void main(String[] args) {
    //     ArrayDeque<Integer> aD = new ArrayDeque<Integer>();
    //     for(int i=3; i < 10; i++)
    //         aD.addFirst(i);
    //     aD.printDeque();
    //     System.out.println(aD.get(4));
    //     System.out.println(aD.removeLast());
    //     aD.printDeque();
    //     System.out.println(aD.removeFirst());
    //     System.out.println(aD.removeFirst());
    //     System.out.println(aD.removeLast());
    //     aD.printDeque();
    // }

}