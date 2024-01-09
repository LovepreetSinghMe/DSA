package shortestpaths;

import graphs.Edge;
import stacksqueues.Bag;

import java.util.ArrayList;

public class EdgeWeightedDigraph {
    private final int V;
    private final Bag<DirectedEdge>[] adj;
    public EdgeWeightedDigraph(int V) {
        this.V = V;

        this.adj = new Bag[V];

        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<DirectedEdge>();
        }
    }

    public void addEdge(DirectedEdge e) {
        int v = e.from();
        adj[v].add(e);
    }

    public Iterable<DirectedEdge> edges() {
        ArrayList<DirectedEdge> edges = new ArrayList<>();

        for (int v = 0; v < V; v++) {
            for (DirectedEdge e: adj(v)) {
                edges.add(e);
            }
        }

        return edges;
    }

    public int size() {
        return this.V;
    }

    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }
}
