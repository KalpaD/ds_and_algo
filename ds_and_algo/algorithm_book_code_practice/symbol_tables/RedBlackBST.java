public class RedBlackBST<Key extends Comparable<Key>, Value> {

    private static boolean RED = true;
    private static boolean BLACK = false;

    private Node root;

    // definiton of the Node
    private class Node {

        private Key key;
        private Value val;
        private Node left;
        private Node right;
        private int N;
        private boolean color;

        Node(Key key, Value val, int N, boolean color) {
            this.key = key;
            this.val = val;
            this.N = N;
            this.color = color; // this color bit represents the color of the parent link.
        }
    }

    /**
    * Method to detemine given nodes parent link color.
    */
    public boolean isRed(Node x) {
        if (x == null) {
            // null links are implicitly BLACK
            return false;
        } 
        return x.color == RED;
    }

    private Node leftRotate(Node h) {
        // select h.right as the new h ie. x
        Node x = h.right;

        // remove x.left link and set it as the h.right link
        h.right = x.left;
        // and new x.left link should be h
        x.left = h;

        // x's parent link color should be same as h's parent color
        x.color = h.color;
        // and h's parent color should be RED now 
        h.color = RED;
        // number of children should not be changed
        x.N = h.N;

        // h's number of children has been chnaged
        h.N = 1 + size(h.right) + size(h.left);

        return x;
    }

    private Node rightRotate(Node h) {
        // select h.left as the new h ie x
        Node x = h.left;

        //remove x.right link ans set is as h.left link
        h.left = x.right;
        // new x.right should be h
        x.right = h;

        //x's parent link color should be h's parent link color
        x.color = h.color;
        
        h.color = RED;
        // numer of children should not be chnaged
        x.N = h.N;

        h.N = 1 + size(h.right) + size(h.left);

        return x;
    }

    private void flipColor(Node h) {
        assert !isRed(h);
        assert isRed(h.right);
        assert isRed(h.left);
        h.color = RED;
        h.right.color = BLACK;
        h.left.color = BLACK;
    }

    /**
    * Method to insert items to the Red-Balck tree
    */
    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    /**
    *  This method will recrusivly search for th right place to insert and
    *  execute the rightRorate(), leftRotate(), flipColor() operations accordingly
    *  to keep the perfectly balanced Black nodes.
    */
    private Node put(Node x, Key key, Value val) {
        // if the the given element is null
        if (x == null) {
            // new nodes always get created with RED parent links
            return new Node(key, val, 1, RED);
        }
        // search for the right place to insert
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, val);
        } else if (cmp > 0) {
            x.right = put(x.right, key, val);
        } else {
            x.val = val;
        }
       
 
        if (isRed(x.right) && !isRed(x.left)) {
             //       []
             //      /  \\
             //     []   []
             //we should rotate left here
            x = leftRotate(x);
        } else if (isRed(x.left) && isRed(x.left.left)) {
             //        []
             //      //  \
             //     []    [] 
             //    //
             //   []
            x = rightRotate(x);
        } else if (isRed(x.left) && isRed(x.right)) {
             //        []
             //      //  \\
             //     []    [] 
             flipColor(x);
        }
        x.N = 1 + size(x.left) + size(x.right);
        return x;
    }

    public Value get(Key key) {
        if (key == null) {
            return null;
        }
        Node x = get(root, key);
        return x.val;
    }

    private Node get(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);

        if (cmp < 0) {
            return get(x.left, key);
        } else if (cmp > 0) {
            return get(x.right, key);
        } else {
            return x;
        }
    }


    private int size(Node x) {
        if (x == null) {
            return 0;
        }
        return x.N;
    }

    public Iterable<Key> keys() {
        LinkedQueue<Key> q = new LinkedQueue<Key>();
        inorder(root, q);
        return q;
    }

    private void inorder(Node x, LinkedQueue<Key> q) {
        if (x == null) {
            return;
        }
        inorder(x.left, q); // queue all the elements in the left sub tree
        q.enqueue(x.key);   // queue the root element
        inorder(x.right, q); // queue all the elements in the right sub tree
    }

    public void print() {
        //print(root);
        iterablePrint();
    }

    private void iterablePrint() {
        String result = "";
        for (Key key : keys()) {
            //result += "["+key+","+get(key)+"], ";
            result += "["+key+","+get(key)+"]";
        }

        System.out.println(result);
    }

    public static void main(String [] args) {
        RedBlackBST<Integer, String> rbbst = new RedBlackBST<Integer, String>();
        rbbst.put(1, "A");
        rbbst.put(5, "E");
        rbbst.put(4, "D");
        rbbst.put(3, "C");
        rbbst.put(2, "B");
        //rbbst.put(7, "G");
        //rbbst.put(6, "F");
        //rbbst.put(9, "J");
        
        rbbst.print();

    }
 
}