import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Set;
public class Coll {
    public static List<String> getWords() {
        String inputFileName = "words.txt";
        List<String> l = new LinkedList<String>();
        Scanner in;
        try {
            in = new Scanner(new FileReader(inputFileName));
            while(in.hasNext()) {
                l.add(in.next());
            }
            in.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("Not found");
            e.printStackTrace();
        }
        
        return l;
    }
    public static int countWords(List<String> l){
        return l.size();
    }
    public static int countUniqueWords(List<String>l) {
        Set<String>wordSet = new HashSet<String>(l);
        // String[] arr = l.toArray(new String[l.size()]);
        // for(String i: l) {
        //     wordSet.add(i);
        // }   
        return wordSet.size();
    }
    public static Map<String, Integer> collectMap(List<String>target, List<String>l) {
        Map<String, Integer> count = new HashMap<>();
        for(String s:target) {
            count.put(s,0);
        }
        for(String item:l) {
            if(count.containsKey(item)) {
                count.put(item,count.get(item)+1);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        List<String>L = getWords();
        System.out.println(L.get(5));
        System.out.println(countUniqueWords(L));  
        System.out.println(L.size());      
    }
} 