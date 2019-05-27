public class LazyPrimMST {
    private boolean [] marked;          // MST vertices
    private LinkedQueue<Edge> mst;      // MST edges
    private MinPQ<Edge> pq;             // PQ of edges
    private double weight;

    public LazyPrimMST(EdgeWeightedGraph graph) {

        marked = new boolean[graph.getNumberOfVertices()];
        mst = new LinkedQueue<Edge>();
        pq = new MinPQ<Edge>();
        visit(graph, 0); // vist the 0th node

        while (!pq.isEmpty()) {
            Edge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);
            // if both endpoints are on MST we ignore those 
            if (marked[v] && marked[w]) {
                continue;
            }
            mst.enqueue(e);
            weight += e.weight();
            if (!marked[v]) {
                visit(graph, v);
            }
            if (!marked[w]) {
                visit(graph, w);
            }
        }
    }

    /**
     * This method visit the given vertex, and add all edges which are connected to given vertex 
     * to the priority queue. 
     * 
     * Note that the Priority queue will then have all edges including in eligibale edges as well.
     * That is why this method named as lazy version of the Prim's algorithm.
     */
    private void visit(EdgeWeightedGraph graph, int v) {
        marked[v] = true; // mark the given vertex
        // get all the vertices connected to v
        for (Edge e : graph.adj(v)) {
            // if the vertex in the other end has not been visited
            // it should be on the priority queue as a possible candidate
            if (!marked[e.other(v)]) {
                pq.insert(e);
            }
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public double weight() {
        return weight;
    }

    public static void main(String [] args) {

        EdgeWeightedGraph graph = new EdgeWeightedGraph(8);
        graph.addEdge(new Edge(0, 7, 0.16));
        graph.addEdge(new Edge(2, 3, 0.17));
        graph.addEdge(new Edge(1, 7, 0.19));
        graph.addEdge(new Edge(0, 2, 0.26));
        graph.addEdge(new Edge(5, 7, 0.28));
        graph.addEdge(new Edge(1, 3, 0.29));
        graph.addEdge(new Edge(1, 5, 0.32));
        graph.addEdge(new Edge(2, 7, 0.34));
        graph.addEdge(new Edge(4, 5, 0.35));
        graph.addEdge(new Edge(1, 2, 0.36));
        graph.addEdge(new Edge(4, 7, 0.37));
        graph.addEdge(new Edge(0, 4, 0.38));
        graph.addEdge(new Edge(6, 2, 0.40));
        graph.addEdge(new Edge(3, 6, 0.52));
        graph.addEdge(new Edge(6, 0, 0.58));
        graph.addEdge(new Edge(6, 4, 0.93));
   
        LazyPrimMST pMst = new LazyPrimMST(graph);

        for (Edge e : pMst.edges()) {
            System.out.println(e.toString());
        }

        System.out.println("Weight Of MST : " + pMst.weight());
    }
}