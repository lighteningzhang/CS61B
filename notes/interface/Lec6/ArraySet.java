@SuppressWarnings (value="unchecked")
public class ArraySet<T> {
    private T[] buildSet;
    private int sz;
    public ArraySet() {
        buildSet = (T[]) new Object[100];
        sz = 0;
    }

    /* Returns true if this map contains a mapping for the specified key.
     */
    public boolean contains(T x) {
        for(int i=0;i<sz;i++){
            if(buildSet[i].equals(x)){
                return true;
            }
        }
        return false;
    }

    /* Associates the specified value with the specified key in this map. 
       Throws an IllegalArgumentException if the key is null. */
    public void add(T x) {
        buildSet[sz] = x;
        sz++;
        return;
    }

    /* Returns the number of key-value mappings in this map. */
    public int size() {
        return sz;
    }

    public static void main(String[] args) {
        ArraySet<String> s = new ArraySet<>();
        // s.add(null);
        s.add("horse");
        s.add("fish");
        s.add("house");
        s.add("fish");        
        System.out.println(s.contains("horse"));        
        System.out.println(s.size());   
    
        String ss = new String("hh");
        String t = new String("hh");
        System.out.println(ss==t);    
    }

    /* Also to do:
    1. Make ArraySet implement the Iterable<T> interface.
    2. Implement a toString method.
    3. Implement an equals() method.
    */
}