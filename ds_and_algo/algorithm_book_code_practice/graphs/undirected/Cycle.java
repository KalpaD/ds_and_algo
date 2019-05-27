public class Cycle {
    private boolean [] marked;
    private boolean hasCycle;


    public Cycle (Graph graph) {
        marked = new boolean [graph.getNumberOfVertices()];
        for (int s = 0; s < graph.getNumberOfVertices(); s++) {
            if (!marked[s]) {
                dfs(graph, s, s);
            }
        }
    }

    private void dfs(Graph graph, int v, int u) {
        System.out.println("dfs(v="+v+", u="+u+")");
        marked[v] = true;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                dfs(graph, w, v);
            } else if (w != u) {
                System.out.println("    (w="+w+", u="+u+")");
                hasCycle = true;
            }
        }
    }

    public boolean hasCycle() {
        return hasCycle;
    }


    public static void main(String [] args) {

        Graph graph = new Graph(6);

        graph.addEdge(0, 5);
        graph.addEdge(5, 1);
        graph.addEdge(0, 2);
        graph.addEdge(5, 3);
        //graph.addEdge(3, 2);
        graph.addEdge(3, 4);
        graph.addEdge(4, 2);
        graph.addEdge(1, 4);

        graph.print();

        Cycle cycle = new Cycle(graph);
        System.out.println(cycle.hasCycle());
    }
}
