public class BinarySearchST<Key extends Comparable<Key>, Value>{

    private Key[] keys;
    private Value[] values;
    private int N;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    /**
    * This is most important method here , since it act as heart of the
    * two other main operations. get() and put().
    * 
    * It does binary search for the key index using iterative method.
    * */
    public int rank(Key key) {
        int lo = 0;
        int hi = N - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) / 2);
            int cmd = key.compareTo(keys[mid]);
            if (cmd < 0) { 
                hi = mid - 1; 
            } else if (cmd > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo; // ??
    }

    public Value get(Key key) {
        if (isEmpty()) {
            return null;
        }
        int rankIndex = rank(key);
        if (rankIndex < N && keys[rankIndex].compareTo(key) == 0) {
            return values[rankIndex];
        } else {
            return null;
        }
    }

    public void put(Key key, Value value) {
        // if we have the key alreay , then we just have to update the value
        int rankIndex = rank(key);
        if (rankIndex < N && keys[rankIndex].compareTo(key) == 0) {
            values[rankIndex] = value;
            return;
        }
        // if value does not exists, we need to insert
        // sweep the right half ( rankIndex < j < N ) from the N 
        for (int j = N; j > rankIndex; j--) {
            keys[j] = keys[j-1];
            values[j] = values[j-1];
        }
        keys[rankIndex]   = key;
        values[rankIndex] = value;
        N++;
    }

    public static void main(String [] args) {
        BinarySearchST<String, Integer> bsst = new BinarySearchST(5);
        bsst.put("A", 1);
        bsst.put("B", 2);
        bsst.put("D", 4);
        bsst.put("C", 3);
        
        bsst.print(bsst.keys, bsst.values);
    }

     public void print(Key keys [], Value [] values) {
        String result = "";
        for (int i = 0; i < keys.length; i++) {
            result = result + "["+keys[i]+","+values[i]+"], ";
        }
        System.out.println(result);
    }
}