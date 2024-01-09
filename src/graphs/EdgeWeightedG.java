package graphs;

import stacksqueues.Bag;

import java.util.ArrayList;

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

    public Iterable<Edge> edges() {
        ArrayList<Edge> edges = new ArrayList<>();

        for (int v = 0; v < V; v++) {
            for (Edge e: adj(v)) {
                if (v < e.other(v)) {
                    edges.add(e);
                }
            }
        }

        return edges;
    }

    public int size() {
        return this.V;
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }
}
