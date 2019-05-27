public class KruskalMST {

    private LinkedQueue<Edge> mst;
    private double weight;

    public KruskalMST(EdgeWeightedGraph graph) {
        // create the MST queue
        mst = new LinkedQueue<Edge>();
        // create the min priority queue to get the min corossing edge
        MinPQ<Edge> pq = new MinPQ<Edge>();
        for (Edge e : graph.edges()) {
            pq.insert(e);
        }
        // create UF with the number of vertices to find the connectivity
        UF uf = new UF(graph.getNumberOfVertices());

        // until priority queue is not empty, which means we have more edges
        // and , the MST should have the V-1 number of vertices involved.
        while (!pq.isEmpty() && mst.size() < graph.getNumberOfVertices() - 1) {
            // get min weight edge on pq
            Edge e = pq.delMin();
            // and it's vertices
            int v = e.either();
            int w = e.other(v);
            // if v and w , are connected it means they belong to to the same set. We need to avoid those v, w pairs.
            if (!uf.connected(v, w)) {
                // merge components
                uf.union(v, w);
                // add edge to mst
                mst.enqueue(e);
                weight += e.weight();
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
   
        KruskalMST kMst = new KruskalMST(graph);

        for (Edge e : kMst.edges()) {
            System.out.println(e.toString());
        }

        System.out.println("Weight Of MST : " + kMst.weight());
    }
}