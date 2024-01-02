package graphs;

public class DepthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private int s;

    DepthFirstPaths(UndirecetedGraphADJBag g) {
        int graphSize = g.size();

        this.marked = new boolean[graphSize];
        this.edgeTo = new int[graphSize];
    }

    public void dfs(UndirecetedGraphADJBag g, int v) {
        this.marked[v] = true;

        for (int w : g.adj(v)) {
            if (!this.marked[w]) {
                dfs(g, w);
                this.edgeTo[w] = v;
            }
        }
    }
}
