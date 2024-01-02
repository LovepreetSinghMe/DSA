package symboltables;

import java.util.Queue;
import java.util.Stack;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value val;

        int count;

        private Node left, right;

        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
            this.count = 1;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if(x == null) return 0;

        return x.count;
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.count = 1 + size(x.left) + size(x.right);

        return x;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

//    hibbard deletion
    private Node delete(Node x, Key key) {
        if (x == null) return null;

        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;


            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }

        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if(x == null) return new Node(key, val);

        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, val);
        } else if (cmp > 0){
            x.right = put(x.right, key, val);
        } else {
            x.val = val;
        }

        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    public int rank(Key k) {
        return rank(k, root);
    }

    private int rank(Key k, Node x) {
        if(x == null) return 0;

        int cmp = k.compareTo(x.key);

        if (cmp < 0) return rank(k, x.left);
        else if (cmp > 0) return 1 + size(x.left) + rank(k, x.right);
        else return size(x.left);
    }

    public Value get(Key key) {
        Node x = root;

        while (x != null) {
            int cmp = key.compareTo(x.key);
            if(cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else return x.val;
        }

        return null;
    }

    public boolean contains(Key k) {
        return get(k) != null;
    }

    public int rangeCount(Key lo, Key hi) {
        if(contains(hi)) return rank(hi) - rank(lo) + 1;
        else return rank(hi) - rank(lo);
    }

    private Node min(Node root) {
        Node min = root;

        while (min.left != null) {
            min = min.left;
        }

        return min;
    }

    private Node max() {
        Node max = root;

        while (max.right != null) {
            max = max.right;
        }

        return max;
    }

    public Key floor(Key k) {
        Node x = root;
        Key floorKey = null;

        while (x != null) {
            int cmp = x.key.compareTo(k);

            if (cmp == 0) {
               floorKey = x.key;
               break;
            } else if (cmp > 0) {
                x = x.left;
            } else {
                floorKey = x.key;
                x = x.right;
            }
        }

        return floorKey;
    }
}
