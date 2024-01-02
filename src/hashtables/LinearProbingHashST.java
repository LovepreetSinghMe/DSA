package hashtables;

//Optimum performance with array resizing upto half full
public class LinearProbingHashST<Key, Value> {
    private int M = 30001;
    private Value[] vals  = (Value[]) new Object[M];
    private Key[] keys  = (Key[]) new Object[M];

    private int hash(Key k) {
        return (k.hashCode() & 0x7fffffff) % M;
    }

    public void put(Key k, Value val) {
        int i;

        for (i = hash(k); keys[i] != null; i = (i + 1) % M) {
            if (k.equals(keys[i])) break;
        }

        keys[i] = k;
        vals[i] = val;
    }

    public Value get(Key k) {
        for (int i = hash(k); keys[i] != null; i = (i + 1) % M) {
            if (k.equals(keys[i])) return vals[i];
        }

        return null;
    }
}
