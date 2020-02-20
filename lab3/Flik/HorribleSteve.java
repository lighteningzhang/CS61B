import static org.junit.Assert.*;
import org.junit.Test;
public class HorribleSteve {
    public static void main(String [] args) {
        int i = 0;
        /**
         *  int transforms to Integer automatically,
         *  when the number is between (-128, 127), however, when bigger than 128
         *  the Integer will use the constructor to new an object
         */
//        assertEquals(a, b);
//        assertTrue(Flik.isSameNumber(a, b));
        for (int j = 0; i < 500; ++i, ++j) {
            if (!Flik.isSameNumber(i, j)) {
                break; // break exits the for loop!
            }
        }
        System.out.println("i is " + i);
    }
}
