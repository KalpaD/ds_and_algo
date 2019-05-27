public class CC {
    private boolean [] marked; // is this vertex visited ?
    private int [] id;         // id's of the connected components.
    private int count;         // number of connected components

    public CC(Graph graph) {
        marked = new boolean[graph.getNumberOfVertices()];
        id = new int[graph.getNumberOfVertices()];
        // treat every vertex as a source, and use dfs to mark and identify all the verices connected to it.
        for (int s = 0; s < graph.getNumberOfVertices(); s++) {
            if (!marked[s]) { // if the source is not marked, call dfs()
                dfs(graph, s);
                count++;  // note that this will only get updated only when algo found a new connected component
                          // this is becasue the gurantee from dfs that , it will not leave the connected component 
                          // until it find all the vertices connected to given source. 
            }
        }
    }

    private void dfs(Graph graph, int v) {
        marked[v] = true;
        id[v] = count; // id of the component will be value of the count.
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                marked[w] = true;
                dfs(graph, w);
            }
        }
    }

    /**
     * Returns true is the given v is connected to w, otherwise returns false.
     */
    public boolean connected(int v, int w) {
        // if id of a connected component is same for given v and w vertices
        // then they are connected.
        return id[v] == id[w]; 
    }

    /**
     * Returns the number of connected componenets.
     */
    public int count() {
        return count;
    }

    /**
     * Returns componenet identifier for given v.
     */
    int id(int v) {
        return id[v];
    }

    public static void main(String [] args) {

        Graph graph = new Graph(13);

        graph.addEdge(0, 6);
        graph.addEdge(0, 2);
        graph.addEdge(0, 1);
        graph.addEdge(0, 5);
        graph.addEdge(3, 5);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(7, 8);
        graph.addEdge(9, 11);
        graph.addEdge(9, 10);
        graph.addEdge(9, 12);
        graph.addEdge(11,12);
       
        graph.print();

        CC cc = new CC(graph);
        // print all connected components

        // get the number of connected components
        int numberOfCC = cc.count;

        // create a bag array to collect connected components
        Bag<Integer> [] connectedComponentsBagArray = (Bag<Integer> []) new Bag[numberOfCC];

        // load empty bags to bag array
        for (int i = 0; i < numberOfCC; i++) {
            connectedComponentsBagArray[i] = new Bag<Integer>();
        }

        // collect vertices to relevant component bags
        // this is done by looking at the id array for every index v
        for (int v = 0; v < graph.getNumberOfVertices(); v++) {
            int componentId = cc.id[v];
            connectedComponentsBagArray[componentId].add(v);
        }

        for (int j = 0; j < connectedComponentsBagArray.length; j++) {
            String component = "Component " + j + ":- ";
            for (int w : connectedComponentsBagArray[j]) {
                component += w + ", ";
            }
            System.out.println(component);
        }
    }
}