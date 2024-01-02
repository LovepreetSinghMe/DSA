package symboltables;

public class OrderedSymbolTable<Key extends Comparable<Key>, Value> {
    Key[] keys;
    Value[] vals;

    int size;

    public OrderedSymbolTable(int capacity) {
        size = 0;
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Comparable[capacity];
    }

    private boolean isEmpty() {
        return size == 0;
    }

    public Value get(Key key) {
        int rank = rank(key);

        if(rank < size && keys[rank].compareTo(key) == 0) {
            return vals[rank];
        }

        return null;
    }

    public void put(Key key, Value val) {
        int rank = rank(key);

        if (rank < size && keys[rank].compareTo(key) == 0) {
            vals[rank] = val;
        } else {

            for (int i = size; i > rank; i--) {
                keys[i] = keys[i - 1];
                vals[i] = vals[i - 1];
            }

            keys[rank] = key;
            vals[rank] = val;

            size++;
        }
    }

    int rank(Key key) {
        int lo = 0, hi = size - 1;

        while (lo <= hi) {
            int mid = lo + ((hi - lo) / 2);
            if (key.compareTo(keys[mid]) == 0) return mid;
            else if (key.compareTo(keys[mid]) < 0) hi = mid - 1;
            else lo = mid + 1;
        }

        return lo;
    }
}
