package graphs;

public class KosarajuSharirSCC {
    private int[] id;
    private boolean[] marked;

    private int count;

    public KosarajuSharirSCC(DirectedG g) {
        count = 0;
        marked = new boolean[g.size()];
        id = new int[g.size()];

//        DFS on reverse of g for finding reverse post order, then a dfs in the received order on the original graph
        DepthFirstOrder dfo = new DepthFirstOrder(g.reverse());

        for (int v: dfo.reversePost()) {
            if (!marked[v]) {
                dfs(g, v);
                count++;
            }
        }
    }

    public int count() {
        return count;
    }

    public boolean stronglyConnected(int v, int w) {
        return id[v] == id[w];
    }

    private void dfs(DirectedG g, int v) {
        marked[v] = true;
        id[v] = count;

        for (int w : g.adj(v)) {
            if (!marked[w]) {
                dfs(g, w);
            }
        }
    }
}
