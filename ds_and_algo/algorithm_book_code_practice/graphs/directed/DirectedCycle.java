public class DirectedCycle {
    private boolean [] marked;
    private int [] edgeTo;
    private boolean [] onStack;
    private LinkedStack<Integer> cycle;

    public DirectedCycle(Digraph graph) {
        marked = new boolean [graph.getNumberOfVertices()];
        edgeTo = new int [graph.getNumberOfVertices()];
        onStack = new boolean [graph.getNumberOfVertices()];

        for (int s = 0; s < graph.getNumberOfVertices(); s++) {
            if (!marked[s]) {
                dfs(graph, s);
            }
        }
    }

    /**
     * This method do a DFS , and in addition of usual DFS it does following things
     * it put all the visited vertices in to a onStack [] array.
     * it tracks the DFS navigational points using edgeTo []
     * And if it detects the a particuler w vertex which was adjecent vertex of v , has been on the visited stack of
     * vertices it identify it as sign of cycle.
     */
    public void dfs(Digraph graph, int v) {
        marked[v] = true;   // mark v
        onStack[v] = true;
        for (int w : graph.adj(v)) {
            if (this.hasCycle()) {
                return;
            } else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(graph, w);
            } else if (onStack[w]) {
                cycle = new LinkedStack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> getCycle() {
        return cycle;
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

        DirectedCycle diCycle = new DirectedCycle(digraph);
        String cycle = "";
        int start = 0;
        for (int c : diCycle.getCycle()) {
                if (cycle.length() == 0) {
                    start = c;
                    cycle += c + "->";
                } else if (start == c) {
                    cycle += c;
                } else {
                    cycle += c + "->";
                }
        }
        System.out.println(cycle);
    }
}



 