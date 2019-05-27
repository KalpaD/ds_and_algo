import java.util.Scanner;
import java.util.NoSuchElementException;
import java.util.Scanner;

import java.io.File;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.FileNotFoundException;

public class SymbolGraph {
    private LinearProbingHashST<String, Integer> st;
    private String[] keys;
    private Graph graph;

    /** 
     * Takes string with 
     */
    public SymbolGraph(String filePath, String delim) throws FileNotFoundException {
        st = new LinearProbingHashST<String, Integer>();
        In in = new In(filePath);
        while (in.hasNextLine()) {

            String [] a = in.readLine().split(delim);
            for (int i = 0; i < a.length; i++) {
                if (!st.contains(a[i])) {
                    st.put(a[i], st.size());
                }
            }
        }

        keys = new String[st.size()];
        for (String name : st.keys()) {
            keys[st.get(name)] = name;
        }
        
        graph = new Graph(st.size());
        in = new In(filePath);

        while (in.hasNextLine()) {
            String [] a = in.readLine().split(delim);
            int v = st.get(a[0]);
            for (int i = 1; i < a.length; i++) {
                graph.addEdge(v, st.get(a[i]));
            }
        }
    }

    public boolean contains(String s) {
        return st.contains(s);
    }

    public int getIndex(String s) {
        return st.get(s);
    }

    public String getName(int v) {
        return keys[v];
    }

    public Graph getGraph() {
        return graph;
    }

    private class In {
        Scanner scanner;

        In(String filePath) throws FileNotFoundException {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            scanner = new Scanner(new BufferedInputStream(fis), "UTF-8");
        }

        public boolean hasNextLine() {
            return scanner.hasNextLine();
        }

        public String readLine() {
            String line;
            try {
                line = scanner.nextLine();
            }
            catch (NoSuchElementException e) {
                line = null;
            }
            return line;   
        } 
    }

    public static void main(String [] args) throws FileNotFoundException {
        String fileName = args[0];
        String delim    = args[1];

        SymbolGraph sg = new SymbolGraph(fileName, delim);

        Graph graph = sg.getGraph();

        graph.print();
    }
}