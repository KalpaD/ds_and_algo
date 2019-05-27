public class TopologicalSort {
    private boolean [] marked;
    private LinkedStack<Integer> reversePostOrder;

    public TopologicalSort(Digraph graph) {
        int n = graph.getNumberOfVertices();
        marked = new boolean[n];
        reversePostOrder = new LinkedStack<>();

        for (int s = 0; s < n; s++) {
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
        reversePostOrder.push(v);
    }

    public static void main(String [] args) {
        Digraph graph = new Digraph(7);
        graph.addEdge(0, 5);
        graph.addEdge(0, 2);
        graph.addEdge(0, 1);
        graph.addEdge(3, 6);
        graph.addEdge(3, 5);
        graph.addEdge(3, 4);
        graph.addEdge(5, 2);
        graph.addEdge(6, 4);
        graph.addEdge(6, 0);
        graph.addEdge(3, 2);
        graph.addEdge(1, 4);

        TopologicalSort tsort = new TopologicalSort(graph);

        String revPostOrder = "Topological Sort Result :-    ";
        for (int w : tsort.reversePostOrder) {
            revPostOrder += w + ", ";
        }

        System.out.println(revPostOrder);
    }
}