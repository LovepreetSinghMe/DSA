package graphs;

import stacksqueues.Bag;

public class UndirecetedGraphADJBag {
    private final int V;
    private Bag<Integer>[] adj;


    public UndirecetedGraphADJBag(int V) {
        this.V = V;
        this.adj = new Bag[V];

        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    public int size() {
        return this.V;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}
