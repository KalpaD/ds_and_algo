public class BreadthFirstPaths {
    private boolean [] marked;  // Is a shortest path to this vertex known ?
    private int [] edgeTo;      // last vertex on known path to this vertex
    private final int s;        // source

    public BreadthFirstPaths(Graph graph, int s) {
        marked = new boolean[graph.getNumberOfVertices()];
        edgeTo = new int[graph.getNumberOfVertices()];
        this.s = s;
        bfs(graph, s);
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        LinkedStack<Integer> path = new LinkedStack<Integer>();
        int x = v; 
        path.push(x);

        while (x != s) {
            int parent = edgeTo[x];
            path.push(parent);
            x = parent;
        }
        return path;
    }

    private void bfs(Graph graph, int s) {
        LinkedQueue<Integer> queue = new LinkedQueue<Integer>();
        marked[s] = true;           // mark the source
        queue.enqueue(s);           // enqueue the source

        while (!queue.isEmpty()) { 
            int v = queue.dequeue(); // remove the next vertex from the queue

            for (int w : graph.adj(v)) {
                if (!marked[w]) {       // for every unmarked adjacent vertex
                    edgeTo[w] = v;      // save last edge on a shortest path
                    marked[w] = true;   // mark it
                    queue.enqueue(w);   // add it to the queue
                }
            }
        }
    }

    public static void main(String [] args) {
        Graph graph = new Graph(6);

        graph.addEdge(0, 5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(5, 3);
        graph.addEdge(3, 2);
        graph.addEdge(3, 4);
        graph.addEdge(4, 2);
        graph.addEdge(1, 2);

        graph.print();

        BreadthFirstPaths paths = new BreadthFirstPaths(graph, 0);

        for (int v = 0; v < graph.getNumberOfVertices(); v++) {
            int pathToVertex = v;
            if (paths.hasPathTo(v)) {
                String result = "";
            for (int p : paths.pathTo(pathToVertex)) {
                if (p == pathToVertex) {
                    result += p;
                } else {
                    result += p + "->";
                }
            }
            System.out.println(result);
            }
        }
    }
}