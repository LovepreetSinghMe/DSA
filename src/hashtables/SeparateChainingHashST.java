package hashtables;

public class SeparateChainingHashST<Key, Value> {
    private int M = 97;
    private Node[] st = new Node[M];

    private static class Node {
        private Object key;
        private Object val;

        private Node next;

        Node(Object k, Object val, Node x) {
            this.key = k;
            this.val = val;
            this.next = x;
        }
    }

    private int hash(Key k) {
        return (k.hashCode() & 0x7fffffff) % M;
    }

    public Value get(Key k) {
        int i = hash(k);

        for (Node x = st[i]; x != null; x = x.next) {
            if (x.key.equals(k)) return (Value) x.val;
        }

        return null;
    }

    public void put(Key k, Value val) {
        int i = hash(k);

        for (Node x = st[i]; x != null; x = x.next) {
            if (x.key.equals(k)) x.val = val;
            return;
        }

        st[i] = new Node(k, val, st[i]);
    }
}
