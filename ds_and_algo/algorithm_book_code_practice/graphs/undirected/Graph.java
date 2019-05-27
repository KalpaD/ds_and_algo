
public class Graph {
    private final int V;            // number of vertices
    private int E;                  // number of edges
    private Bag<Integer> [] adj;    // adjacency lists

    /**
     * Create a V-vertex graph with no edges.
     */
    Graph(int V) {
        this.V = V;
        this.E = E;
        adj = (Bag<Integer> []) new Bag[V]; // create array of bags
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<Integer>();    // init all array slots with empty bag. 
        } 
    }

    public int getNumberOfVertices() {
        return V;
    }

    public int getNumberOfEdges() {
        return E;
    }

    /**
     * Add edge which connects the given vertices v and w.
     */
    public void addEdge(int v, int w) {
        adj[v].add(w);                  // add w to v's list
        adj[w].add(v);                  // add v to w's list
        E++;
    }

    /**
     * Returns the adjeciency list of vertex v.
     */
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    /**
     * Returns the degree of the vertex v.
     */
    public int degree(int v) {
        int degree = 0;
        Bag<Integer> vertices = adj[v];
        for (int w : vertices) {
            degree++;
        }
        return degree;
    }

    /**
     * Returns max degree of the adj list.
     */
    public int maxDegree() {
       int max = 0;
       for (int i = 0; i < getNumberOfVertices(); i++) {
           int degree = degree(i);
           if (degree > max) {
               max = degree;
           }
       }
       return max;
    }

    public int numberOfSelfLoops() {
        int count = 0;
        for (int v = 0; v < getNumberOfVertices(); v++) {
            for (int w : adj(v)) {
                if (w == v) {
                    count++;
                }
            }
        }
        return count /  2;  // node that addEdge method assiocite 
                            // the same edge twise in case of self loop.
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
        Graph graph = new Graph(7);
        graph.addEdge(0, 5);
            graph.addEdge(5, 5);
        graph.addEdge(0, 6);
        graph.addEdge(0, 2);
        graph.addEdge(0, 1);
        graph.addEdge(3, 4);
            graph.addEdge(3, 3);
        graph.addEdge(3, 5);
        graph.addEdge(4, 6);
        graph.addEdge(4, 5);

        graph.print();

        System.out.println("degree of 0 : " + graph.degree(0));
        System.out.println("max degree of graph : " + graph.maxDegree());
        System.out.println("number of self loops : " + graph.numberOfSelfLoops());
    }

}