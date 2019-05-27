public class DepthFirstPaths {

    private boolean [] marked;
    private int [] edgeto;
    private int s;

    /**
     * Find a path connected to a source s.
     */
    DepthFirstPaths(Graph graph, int s) {
        marked = new boolean[graph.getNumberOfVertices()];
        edgeto = edgeto = new int[graph.getNumberOfVertices()];
        dfs(graph, s);
    }

    /**
     * Indicate a boolean flag of the status, is there a path from s to v.
     */
    public boolean hasPathTo(int v) {
        // if there is no path from s to v, search should not have been visited the vertex.
        return marked[v];
    }

    /**  
     * Return a path from s to v ; null if no such path.
     */
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        LinkedStack<Integer> pathStack = new LinkedStack<Integer>();
        int x = v;
        pathStack.push(v);
        // if x == s , we should stop moving, we have reached to the end of the line.
        while (x != s) {
            //query edgeTo Array which has the nodes and their navigation index
            int navigationPoint = edgeto[x];
            pathStack.push(navigationPoint);
            x = navigationPoint;
        }
        return pathStack;
    }

    private void dfs(Graph graph, int v) {
        marked[v] = true;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                // this will only reach in every first visit a given vertex.
                // hence add the way we got there to the edgeto array.
                // it will track the whole pathf from any node to source.
                edgeto[w] = v;
                dfs(graph, w);
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

        DepthFirstPaths paths = new DepthFirstPaths(graph, 0);

        for (int v = 0; v < graph.getNumberOfVertices(); v++) {
            int pathToVertex = v;
            String result = "";
            for(int p : paths.pathTo(pathToVertex)) {
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