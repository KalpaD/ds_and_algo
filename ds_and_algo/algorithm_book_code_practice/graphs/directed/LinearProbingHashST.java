public class LinearProbingHashST<Key, Value> {
    private static final int INIT_CAPACITY = 5;

    private int n;          // number of key value pair's in hash table
    private int m = 16;     // size of the liner probing table
    private Key [] keys;
    private Value [] vals;

    /**
     * Init an empty symbol table
     */
    LinearProbingHashST() {
        this(INIT_CAPACITY);
    }

    /**
     * Init a symbol table with specified init capacity
     */
    LinearProbingHashST(int capacity) {
        m = capacity;
        n = 0;
        keys = (Key [])new Object[m];
        vals = (Value [])new Object[m];
    }

    private int size() {
        return n;
    }

    private int hashCode(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    /**
     * Resize the hash table by creting a temperory hash table and hashing keys with the new capacity 
     * Finally , assign it's keys and values to this Hash table.
     */
    private void resize(int capacity) {
        // create a temporary hash table
        LinearProbingHashST<Key, Value> temp = new LinearProbingHashST<Key, Value>(capacity);
        // load non-null keys with respective values
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], vals[i]);
            }
        }
        // assign temp's keys to this keys
        keys = temp.keys;
        vals = temp.vals;
        m = temp.m;
    }

    public void put(Key key, Value val) {
       // check for half full array
       if (n >= (m / 2)) {
           resize(2 * m);
       }
       // search for the key
       int i ; // need to keep i our of for loop to use it later
       for (i = hashCode(key); keys[i] != null; i = (i + 1) % m) {
           if (key.equals(keys[i])) {
               vals[i] = val;
               return;
           }
       }
       // have not found the key, new to add new
        keys[i] = key;
        vals[i] = val;
        n++;
    }

    public Value get(Key key) {
        // get the hash code of the key
        // iterate the loop by i + 1 % M to keep the index within the array boundry
        // until it hits a position which is null
        for (int i = hashCode(key); keys[i] != null; i = (i + 1) % m) {
            if (key.equals(keys[i])) {
                return (Value)vals[i];
            }
        }
        return null;
    }

    public boolean contains(Key key) {
        if (key == null) {
            return false;
        }
        return get(key) != null;
    }

    /**
     * Deleteing key-value pir form the hash table
     */
    public void delete(Key key) {
        // check for existance of the key
        if (!contains(key)) {
            return;
        }
        // find the key value index
        int i = hashCode(key);
        // search for the kwy
        while (!key.equals(keys[i])) {
            i = (i + 1) % m;
        }
        // found the key location
        // delete the key and value
        keys[i] = null;
        vals[i] = null;
        // move one step ahead, where next key is
        i = (i + 1) % m;
        // now we need to re-hash all the keys right to the deletion position
        while (keys[i] != null) {
            // save the key in temp varibale
            Key keyToReDo = keys[i];
            Value valToReDo = vals[i];
            // delete the key and value
            keys[i] = null;
            vals[i] = null;
            n--; // reduce the number of key-value pairs
            // re-hash and insert
            put(keyToReDo, valToReDo);
            // increment the index
            i = (i + 1) % m;
        }
        // all done , but we have one less key-value pair
        n--;
        if (n > 0 && n == m / 8) {
            resize(m / 2);
        }
    }

    public static void main(String [] args) {
        LinearProbingHashST<String, Integer> lphst = new LinearProbingHashST<String, Integer>();
        lphst.put("A", 1);
        lphst.put("E", 5);
        lphst.put("D", 4);
        lphst.put("C", 3);
        lphst.put("B", 2);
        lphst.put("F", 6);
        lphst.put("G", 7);
        lphst.put("H", 8);
        lphst.put("I", 9);

        // successful search
        System.out.println(lphst.get("H"));
        // Unsuccessful search
        System.out.println(lphst.get("Z"));

        System.out.println(lphst.get("C"));

        System.out.println("Deleting C");
        lphst.delete("C");
        System.out.println("Searching for C");
        System.out.println(lphst.get("C"));

    }
}