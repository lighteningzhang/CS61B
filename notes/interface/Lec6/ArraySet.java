import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;
@SuppressWarnings (value="unchecked")
public class ArraySet<T> implements Iterable<T>{
    private T[] buildSet;
    private int sz;
    public ArraySet() {
        buildSet = (T[]) new Object[100];
        sz = 0;
    }  
    public Iterator<T> iterator(){
        return new ArraySetIterator();
    }
    private class ArraySetIterator implements Iterator<T>{
        private int wizPos;
        public ArraySetIterator(){
            wizPos = 0;
        }
        public boolean hasNext(){
            return wizPos<sz;
        }
        public T next(){
            T ret = buildSet[wizPos];
            wizPos++;
            return ret;
        }
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
        if( x==null)
            throw new IllegalArgumentException("Add null item");
        if(contains(x))
            return;
        buildSet[sz++] = x;
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
        Set<String> s2 = new HashSet<>();

        s2.add(null);
        s2.add("hhh");
        s2.add("kkkk");
        Iterator<String> seer = s.iterator();
        // while(seer.hasNext()){
        //     String i = seer.next();
        //     System.out.println(i);
        // }
        for(String i:s){
            System.out.println(i);
        }
    }

    /* Also to do:
    1. Make ArraySet implement the Iterable<T> interface.
    2. Implement a toString method.
    3. Implement an equals() method.
    */
}