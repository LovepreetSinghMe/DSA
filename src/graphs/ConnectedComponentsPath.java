package graphs;

public class ConnectedComponentsPath {
    private int[] id;
    private boolean[] marked;

    private int count;

    public ConnectedComponentsPath(UndirecetedGraphADJBag g) {
        count = 0;
        marked = new boolean[g.size()];
        id = new int[g.size()];

        for (int v = 0; v < g.size(); v++) {
            if (!marked[v]) {
                dfs(g, v);
                count++;
            }
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    private void dfs(UndirecetedGraphADJBag g, int v) {
        marked[v] = true;
        id[v] = count;

        for (int w : g.adj(v)) {
            if (!marked[w]) {
                dfs(g, w);
            }
        }
    }
}
