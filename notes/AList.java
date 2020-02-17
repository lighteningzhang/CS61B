/** Array based list.
 *  @author Josh Hug
 */
// <Glorp>
// ((Glorp[]) new Object[100])
public class AList {
    private int[] arr;
    private int idx;
    /** Creates an empty list. */
    public AList() {
        arr = new int[100];
        idx = 0;
    }
    public void resize(int size){
        int[] a = new int[size];
        System.arraycopy(arr, 0, a, 0, idx-1);
        arr = a;
    }
    /** Inserts X into the back of the list. */
    public void addLast(int x) {
        if(idx==arr.length){
            resize(idx*5);
        }
        arr[idx] = x;
        idx+=1;
    }

    /** Returns the item from the back of the list. */
    public int getLast() {
        if(idx==0)
            return 0;
        else{
            return arr[idx-1];
        }        
    }
    /** Gets the ith item in the list (0 is the front). */
    public int get(int i) {
        return arr[i];        
    }

    /** Returns the number of items in the list. */
    public int size() {
        return idx;        
    }

    /** Deletes item from back of the list and
      * returns deleted item. */
    public int removeLast() {
        int num = arr[--idx];
        arr[idx] = 0;
        return num;
    }
    public static void main(String[] args) {
        AList a = new AList();
        int i = 0;
        while(i<100000){
            a.addLast(i);
            i+=1;
            
        }

    }
} 