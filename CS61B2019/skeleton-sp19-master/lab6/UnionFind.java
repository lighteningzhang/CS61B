public class UnionFind {

    // TODO - Add instance variables?
    private int[] par;
    /* Creates a UnionFind data structure holding n vertices. Initially, all
       vertices are in disjoint sets. */
    public UnionFind(int n) {
        // TODO
        par = new int[n+1];
        for (int i=1; i<=n; i++) {
            par[i] = -1;
        }
    }

    /* Throws an exception if v1 is not a valid index. */
    private void validate(int vertex) {
        // TODO
        if (vertex<=0 || vertex>=par.length) {
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }
    }

    /* Returns the size of the set v1 belongs to. */
    public int sizeOf(int v1) {
        int p = find(v1);
        if(p<0)
            return -p;
        return -par[p];
    }

    /* Returns the parent of v1. If v1 is the root of a tree, returns the
       negative size of the tree for which v1 is the root. */
    public int parent(int v1) {
        // TODO
        validate(v1);
        return par[v1];
    }

    /* Returns true if nodes v1 and v2 are connected. */
    public boolean connected(int v1, int v2) {
        // TODO
        validate(v1);
        validate(v2);
        int p1 = find(v1), p2 = find(v2);
        return p1 == p2;
    }

    /* Connects two elements v1 and v2 together. v1 and v2 can be any valid 
       elements, and a union-by-size heuristic is used. If the sizes of the sets
       are equal, tie break by connecting v1's root to v2's root. Unioning a 
       vertex with itself or vertices that are already connected should not 
       change the sets but may alter the internal structure of the data. */
    public void union(int v1, int v2) {
        // TODO
        int p1 = find(v1), p2 = find(v2);
        if(p1 != p2) {
            int w1 = -par[p1], w2 = -par[p2];
//            System.out.println("w1: "+w1+", w2: "+w2);
            if(w1<=w2) {
                par[p2] += par[p1];
                par[p1] = p2;
            } else {
                par[p1] += par[p2];
                par[p2] = p1;
            }
        }
    }

    /* Returns the root of the set V belongs to. Path-compression is employed
       allowing for fast search-time. */
    public int find(int vertex) {
        // TODO
        validate(vertex);
        if(par[vertex]<0)
            return vertex;
        else{
            int root = find(par[vertex]);
            par[vertex] = root;
            return root;
        }

    }

}
