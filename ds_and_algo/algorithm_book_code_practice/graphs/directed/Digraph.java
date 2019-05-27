public class Digraph {
    private Bag<Integer> [] adj;
    private final int V;  // number of vertices in the graph
    private int E;  // number of edges in the graph

    /**
     * Create a Vvertex digraph with no edges
     */
    public Digraph(int V) {
        this.V = V;
        adj = (Bag<Integer> []) new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<Integer>();
        }
    }

    /**
     * Add edge v->w to this digraph.
     */
    public void addEdge(int v, int w) {
        adj[v].add(w); // add w to v's list , but not the otherway since this is a digraph.
        E++;
    }

    /**
     * Return an iterable bag of adjecent vertices for given v.
     */
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    /**
     * Return reverse of this Digraph.
     * Here reverse means the direction of all the edges will be reversed.
     */
    public Digraph reverse() {
        // create a new digraph
        Digraph reversedig = new Digraph(this.V);
        for (int v = 0; v < V; v++) {
            for (int w : adj(v)) {
                reversedig.addEdge(w, v);
            }
        }
        return reversedig;
    }

    /**
     * Return number of vertices in the graph.
     */
    public int getNumberOfVertices() {
        return V;
    }

    /**
     * Return number of edges in the graph.
     */
    public int getNumberOfEdges() {
        return E;
    }

    public void print() {
        int n = getNumberOfVertices();
        for (int i = 0; i < n; i++) {
            String result = "v : " + i + " - ";
            for (int w : adj(i)) {
                result += w + ",";
            }
        System.out.println(result);
        result = "";
        }
    }

    public static void main(String [] args) {

        Digraph digraph = new Digraph(13);
        digraph.addEdge(4, 2);
        digraph.addEdge(2, 3);
        digraph.addEdge(3, 2);
        digraph.addEdge(6, 0);
        digraph.addEdge(0, 1);
        digraph.addEdge(11, 12);
        digraph.addEdge(12, 9);
        digraph.addEdge(9, 10);
        digraph.addEdge(9, 11);
        digraph.addEdge(8, 9);
        digraph.addEdge(10, 12);
        digraph.addEdge(11, 4);
        digraph.addEdge(4, 3);
        digraph.addEdge(3, 5);
        digraph.addEdge(7, 8);
        digraph.addEdge(8, 7);
        digraph.addEdge(5, 4);
        digraph.addEdge(0, 5);
        digraph.addEdge(6, 4);
        digraph.addEdge(6, 9);
        digraph.addEdge(7, 6);

        digraph.print();
    }
    
}