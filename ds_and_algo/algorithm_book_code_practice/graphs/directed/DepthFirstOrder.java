public class DepthFirstOrder {
    private boolean [] marked;

    private LinkedQueue<Integer> preOrderQueue;  // put the vertex to this queue before the recursive call.
    private LinkedQueue<Integer> postOrderQueue; // put the vertex to this queue after the recursive call.
    private LinkedStack<Integer> reversePostorder;     // put the vertex to this stack after the recursive call.

    public DepthFirstOrder(Digraph graph) {
        marked = new boolean[graph.getNumberOfVertices()];
        preOrderQueue = new LinkedQueue<Integer>();
        postOrderQueue = new LinkedQueue<Integer>();
        reversePostorder = new LinkedStack<Integer>();

        for (int s = 0; s < graph.getNumberOfVertices(); s++) {
            if (!marked[s]) {
                dfs(graph, s);
            }
        }
    }

    private void dfs(Digraph graph, int v) {
        marked[v] = true;
        preOrderQueue.enqueue(v);
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                dfs(graph, w);
            }
        }
        postOrderQueue.enqueue(v);
        reversePostorder.push(v);
    }

    public static void main(String [] args) {
        Digraph digraph = new Digraph(13);
        digraph.addEdge(0, 6);
        digraph.addEdge(0, 1);
        digraph.addEdge(0, 5);
        digraph.addEdge(2, 0);
        digraph.addEdge(2, 3);
        digraph.addEdge(3, 5);
        digraph.addEdge(5, 4);
        digraph.addEdge(6, 4);
        digraph.addEdge(8, 7);
        digraph.addEdge(7, 6);
        digraph.addEdge(6, 9);
        digraph.addEdge(9, 10);
        digraph.addEdge(9, 12);
        digraph.addEdge(9, 11);
        
        digraph.print();

        DepthFirstOrder dfso = new DepthFirstOrder(digraph);
        
        String preOrder = "Pre Order :-             ";
        for (int u : dfso.preOrderQueue) {
            preOrder += u + ", ";
        }

        String postOrder = "Post Order :-            ";
        for (int v : dfso.postOrderQueue) {
            postOrder += v + ", ";
        }

        String revPostOrder = "Reverse Post Order :-    ";
        for (int w : dfso.reversePostorder) {
            revPostOrder += w + ", ";
        }

        System.out.println(preOrder);
        System.out.println(postOrder);
        System.out.println(revPostOrder);
    }

}