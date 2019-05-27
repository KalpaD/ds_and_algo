/**
 * There type of task specific classes decouple the implementations of the Graph based algorithms 
 * from the Graph implementation.
 * 
 */
public class DepthFirstSearch {

    private boolean[] marked;
    private int count;

    /**
     * Find vertices connected to a source vertex s.
     */
    DepthFirstSearch(Graph graph, int s) {
        // init the marked boolean array with the soze of the graph
        marked = new boolean[graph.getNumberOfVertices()];
        dfs(graph, s);
    }

    /** 
     * Search Graph by following below algorithm
     * 1. Mark it as having been visited.
     * 2. Visit recursively all the vertices that are adjacent to it and the have not been marked.
     */
    private void dfs(Graph graph, int v) {
        marked[v] = true; // Mark it as having been visited.
        count++;
        for (int w : graph.adj(v)) { // Get all vertices that are adjacent to v and mark them
            if (!marked[w]) {
                dfs(graph, w); // Visit recursively all the vertices that are adjacent
            }
        }   
    }

    /**
     * Indicate is given (w) vertex connected to the the source (s).
     */
    public boolean marked(int w) {
        return marked[w];
    }

    /**
     * Returns integer indicating the number of vertices connected to source (s).
     */
    public int count() {
        return count;
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

        DepthFirstSearch dfs = new DepthFirstSearch(graph, 0);

        System.out.println("count() : " + dfs.count());
    }
}