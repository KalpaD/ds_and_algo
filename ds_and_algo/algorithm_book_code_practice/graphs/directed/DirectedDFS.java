/**
 * Single source reachability : given a digraph and a source vertex s, support queries of the 
 * from "Is there a directed path from s to a given target vertex v ?"
 */
public class DirectedDFS {
    private boolean [] marked;
    /**
     * Do the pre-processing for anwser the the query about reachability.
     */
    public DirectedDFS(Digraph graph, int s) {
        int numberOfVertices = graph.getNumberOfVertices();
        marked = new boolean [numberOfVertices];
        dfs(graph, s);
    }

    /**
     * Do the processing for answer more genral query like
     * "Is there a directed path from any vertex in the set to a given vertex v"
     */
    public DirectedDFS(Digraph graph, Bag<Integer> sources) {
        for (int s : sources) {
            if (!marked[s]) {
                dfs(graph, s);
            }
        }
    }

    private void dfs(Digraph graph, int v) {
        marked[v] = true;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                dfs(graph, w);
            }
        }
    }

    /** 
     * Is there a directed path from s to a given target vertex v ?
     */
    public boolean isReachable(int v) {
        return marked[v];
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

        DirectedDFS ddfs = new DirectedDFS(digraph, 0);

        System.out.println("Is 1 reachable when source is 0 : "+ ddfs.isReachable(1));

        System.out.println("Is 6 reachable when source is 0 : "+ ddfs.isReachable(6));
    }

}