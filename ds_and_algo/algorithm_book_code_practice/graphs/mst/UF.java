public class UF {
    private int [] id; // access to component id
    private int count; // number of components

    public UF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    /**
     * Return the root of the given node p
     */
    private int root(int p) {
        // once p == id[p] we found the root
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    /**
     * Create union between given p and q nodes.
     */
    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);
        if (pRoot == qRoot) {
            // p and q has the same root
            return;
        }
        id[pRoot] = qRoot;
        count--; // this mean we will have one less component from now on.
    }

    public void print() {
        String idArray = "[";
        for (int i = 0; i < id.length; i++) {
            idArray += " " + id[i] + ",";
        }
        idArray += " ]";
        System.out.println(idArray);
    }

    public static void main(String [] args) {
        UF uf = new UF(10);

        uf.print();

        uf.union(0, 1);
        uf.union(1, 2);

        uf.union(3, 4);
        uf.union(4, 5);

        uf.union(6, 7);
        uf.union(7, 8);
        uf.union(8, 9);
        
        uf.print();
        System.out.println("Number of connected compoenents: " + uf.count());
        System.out.println("Is 1 connected to 7 ? : " + uf.connected(1, 7));
        System.out.println("Is 6 connected to 9 ? : " + uf.connected(6, 9));
    }
}