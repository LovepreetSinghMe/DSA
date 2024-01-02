package graphs;

import stacksqueues.Bag;

public class EdgeWeightedG {
    private final int V;
    private final Bag<Edge>[] adj;
    public EdgeWeightedG(int V) {
        this.V = V;

        this.adj = new Bag[V];

        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Edge>();
        }
    }

    public void addEdge(Edge e) {
        int v = e.either(), w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }
}
