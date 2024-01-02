package unionfind;

public class QuickUnionUF {
    private final int[] ids;
    private final int[] rootSizes;
    public QuickUnionUF(int size) {
        ids = new int[size];
        rootSizes = new int[size];

        for(int i = 0; i < size; i++) {
            ids[i] = i;
            rootSizes[i] = 1;
        }
    }

    private int root(int obj) {
        int i = obj;
        while(ids[i] != i) {
//            pointing each item to its grandparent to decrease length of the path
            ids[i] = ids[ids[i]];
            i = ids[i];
        }

        return i;
    }

    public int[] getDS() {
        return ids;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);

//        weighted quick union
        if(rootSizes[i] >= rootSizes[j]) {
            ids[j] = i;
            rootSizes[i] += rootSizes[j];
        } else {
            ids[i] = j;
            rootSizes[j] += rootSizes[i];
        }
    }
}
