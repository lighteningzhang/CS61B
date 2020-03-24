import org.junit.Test;
import static org.junit.Assert.*;
public class TestUnionFind {
    @Test
    public void TUF() {
        UnionFind uf = new UnionFind(5);
        assertEquals(2,uf.find(2));
        uf.union(1,2);
        assertEquals(2,uf.find(1));
        assertTrue(uf.connected(1,2));
        uf.union(3,2);
        assertEquals(2,uf.find(3));
        uf.union(4,5);
        assertEquals(5,uf.find(5));
        uf.union(5,1);
        assertTrue(uf.connected(5,3));
        assertEquals(5,uf.sizeOf(3));
        //        uf.union(2,3);
//        assertEquals(1,uf.find(3));
    }
}
