public class BST<Key extends Comparable<Key>, Value> {

    private Node root;      // root of the BST

    private class Node {

        private Key key;    // key
        private Value val;  // associated value;

        private Node left;  // links to subtree
        private Node right; // links to subtree

        private int N;      // number of nodes in subtree rooted here

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }

        public String toString() {
            return "["+key+","+val+"]";
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.N;
        }
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {

        if (x != null) {
            System.out.println("put(x = "+x.toString()+", key = "+key+", val ="+val+")");
        } else  {
            System.out.println("put(x = null, key = "+key+", val ="+val+")");
        }
        // if x is null
        if (x == null) {
            return new Node(key, val, 1);
        }
        // search the node with the key
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            // either value updated node or newly created node will be assinged to as x's left node
            x.left = put(x.left, key, val);
        } else if (cmp > 0) {
            // either value updated node or newly created node will be assinged to as x's right node
            x.right = put(x.right, key, val);
        } else {
            // we have key and value hence we need to update
            x.val = val;
        }
        x.N = size(x.left) + size(x.right) + 1; // any node in BST should satisfy this condition.
        return x;
    }

    public Value get(Key key) {
        return get(key, root);
    }

    private Value get(Key key, Node x) {

        if (x == null) {
            return null;
        }
        // if root the key
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(key, x.left);
        } else if (cmp > 0) {
            return get(key, x.right);
        } else {
            return x.val;
        }
    }

    /** 
    * Floor  operation return the largest key which is less than or equal to the given key.
    **/
    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) {
            return null;
        }
        return x.key;
    }

    private Node floor(Node x, Key key) {
        
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        
        if (cmp == 0) {
            // then this node contains the largest key equal to given key
            return x;
        }

        // If not we can check in the left half
        if (cmp < 0) {
            // call floor again, which will go far left until it find a 
            // key which is less than or equal but the largest one.
            return floor(x.left, key);
        }

        //If both above have not found it then it could be in right side
        Node t = floor(x.right, key);
        if (t != null) {
            return t;
        } else {
            return x;
        }
    }

    /**
    * The celing operation return the smallest key which is equal or grater than the given key.
     */
    public Key ceiling(Key key) {
        Node x = ceiling(root, key);
        if (x == null) {
            return null;
        } 
        return x.key;
    }

    public Node ceiling(Node x, Key key) {
        if (x == null) {
            return null;
        }

        int cmp = key.compareTo(x.key);

        if (cmp == 0) {
            // we have the same key in the table, hence returning it
            return x;
        }

        // If not we can check the right nodes
        if (cmp > 0) {
            return ceiling(x.right, key);
        }

        Node t = ceiling(x.left, key);
        if (t != null) {
            return t;
        } else {
            return x;
        }

    }

    /**
    * Number of keys less than the given key. 
    */
    public int rank(Key key) {
        return rank(root, key);
    }

    private int rank(Node x, Key key) {
        if (x == null) {
            return 0;
        }
        int cmp = key.compareTo(x.key);

        if (cmp < 0) {
            // if key is less than the root's key, then we need to move left 
            // until the given key is the largest
            return rank(x.left, key);

        } else if (cmp > 0) {
            // if key is grater than the root's key, then we need to move right 
            // until given key is the largest
            // in this case the rank() should be computed according to following formula.

            // rank  = 1 (root element) + size(x.left) (size of the left sub tree) + rank(x.right, key)

            // note that all elemets root's left sub tree less get added to rank in this case

            return 1 + size(x.left) + rank(x.right, key);
        } else {
            // this is the easy case where, key is equal to the root's key
            // then rank is the size of the left sub tree
            return size(x.left);
        }
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

    public Key min() {
        Node minNode = min(root);
        return minNode.key;
    }

    public Node min(Node x) {
        if (x == null) {
            return null;
        }
        
        if (x.left != null) {
            return min(x.left);
        }

        x.N = 1 + size(x.left) + size(x.right);
        return x;
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

       /*
        *          [5]
                 /    \
               [1]     [7]
               / \     / \
             [-1] [3] [6] [8]
        *
        *
        */
    private Node deleteMin(Node x) {
        if (x == null) {
            return null;
        }

        // this is the recrusion termination condition.
        // where when x.left is null this returns x's right link to upper layer of the recrusion
        // which hold the parent node as x.
        // there parent nodes left link will be assign to this righ link
        if (x.left == null) {
            return x.right;
        }

        // if we still have not found the min we need to keep going to left
        // one of deep node return it's right link.
        x.left = deleteMin(x.left);

        // now we have to update the count
        x.N = 1 + size(x.left) + size(x.right);
        return x;
    }

    public void deleteMax() {
        root = deleteMax(root);
    }

    public Node deleteMax(Node x) {
        if (x == null) {
            return null;
        }

        if (x.right == null) {
            // we got the largest element 
            // return the left link of that element which will be assigned to the 
            // parent's right link of this largest element
            return x.left;
        }
        // keep going to right until we find the largest elelemnt.
        // and when we find it get left link of it will be assign to the right link of the parent.
        x.right = deleteMax(x.right);
        
        // update the count accodingly
        x.N = 1 + size(x.left) + size(x.right);
        // return the linked node
        return x;
    }

    public void delete(Key key) {
        root = delete(key, root);
    }

    public Node delete(Key key, Node x) {
        // first we need to search for the key
        if (x == null) {
            return null;
        }

        int cmp = key.compareTo(x.key);

        if (cmp < 0) {
            x.left = delete(key, x.left);
        } else if (cmp > 0) {
            x.right = delete(key, x.right);
        } else {

            // Handle the first case where x just has one child
            if (x.left == null) {
                return x.right;
            }
            
            if (x.right == null) {
                return x.left;
            }
            // we have found the node
            // STEP 1 : save the node to t.
            Node t = x;
            // STEP 2 : find the minimum in the right tree of t
            // that will be the successor and assign that as the x
            x = min(t.right);
            // STEP 3 : delete the minimin in the t.right and get the link
            // this will make sure that all the keys in the t.right > x.key
            x.right = deleteMin(t.right);
            //STEP 4 : set the x.left with t.left
            x.left = t.left;
        }
        x.N = 1 + size(x.left) + size(x.right);
        return x;
    }

    public void print() {
        //print(root);
        iterablePrint();
    }

    private void iterablePrint() {
        String result = "";
        for (Key key : keys()) {
            result += "["+key+","+get(key)+"], ";
        }

        System.out.println(result);
    }

    private void print(Node x) {

        if (x == null) {
            return;
        }

        if (x.left != null) {
            print(x.left);
        }

        System.out.print("["+x.key+","+x.val+"], ");

        if (x.right != null) {
            print(x.right);
        }
    }

    public static void main(String [] args) {
        BST<Integer, String> bst = new BST<Integer, String>();
        bst.put(5, "five");
        bst.put(1, "one");
        bst.put(7, "seven");
        bst.put(3, "three");
        bst.put(-1, "minesOne");
        bst.put(6, "six");
        bst.put(8, "eight");

        bst.print();  
        /*
        *          [5]
                 /    \
               [1]     [7]
               / \     / \
             [-1] [3] [6] [8]
        *
        *
        */
        

        System.out.println("get(3) returns : "+ bst.get(3));

        // should return the largest element which is less than or equal to the given key
        System.out.println("floor(0) returns : "+ bst.floor(0));

        // should return the smallest element which is grater than or equal to the given key
        System.out.println("ceiling(0) returns : "+ bst.ceiling(0));

        // should return number of elements less than the given key
        System.out.println("rank(5) returns : "+ bst.rank(5)); // key == 5 case
        System.out.println("rank(1) returns : "+ bst.rank(1)); // key < 5 case
        System.out.println("rank(8) returns : "+ bst.rank(8)); // key > 5 case

        System.out.println("min() returns : "+ bst.min());

        bst.deleteMin();
        System.out.println("After deleteMin() execution");
        bst.print();  

        bst.deleteMax();
        System.out.println("After deleteMax() execution");
        bst.print(); 

        bst.delete(5); 
        System.out.println("After delete(5) execution");
        bst.print(); 
    }
}