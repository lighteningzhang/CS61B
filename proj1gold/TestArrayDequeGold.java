import static org.junit.Assert.*;
import org.junit.Test;
public class TestArrayDequeGold {
    @Test
    public void testArrayDequeSolution(){
        ArrayDequeSolution<Integer> st = new ArrayDequeSolution<Integer>();
        StudentArrayDeque<Integer> stu = new StudentArrayDeque<>();
        StringBuffer mes = new StringBuffer();
        for (int i = 0; i < 1000; i += 1) {
            int randn = StdRandom.uniform(4);

            switch (randn){
                case 0:
                    stu.addFirst(i);
                    st.addFirst(i);
                    mes.append(String.format("addFirst(%d)\n",i));
//                    assertEquals(mes.toString(),st,stu);
                    break;
                case 1:
                    stu.addLast(i);
                    st.addLast(i);
                    mes.append(String.format("addLast(%d)\n",i));
//                    assertEquals(mes.toString(),st,stu);
                    break;
                case 2:
                    if(st.size() == 0) {
                        assertTrue(mes.toString(),stu.isEmpty());
                        break;
                    }
                    Integer ref = stu.removeFirst();
                    Integer ans = st.removeFirst();
                    mes.append(String.format("removeFirst() %d\n", ref));
                    assertEquals(mes.toString(),ans,ref);
                    break;
                case 3:
                    if(st.size() == 0) {
                        assertTrue(mes.toString(),stu.isEmpty());
                        break;
                    }
                    Integer rl = stu.removeLast();
                    Integer al =st.removeLast();
                    mes.append(String.format("removeLast() %d\n", rl));
                    assertEquals(mes.toString(),al,rl);
                    break;
            }
        }


    }

}
