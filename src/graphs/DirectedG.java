package graphs;

import stacksqueues.Bag;

public class DirectedG {
    private final int V;
    private Bag<Integer>[] adj;


    public DirectedG(int V) {
        this.V = V;
        this.adj = new Bag[V];

        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public int size() {
        return this.V;
    }

    public DirectedG reverse() {
        DirectedG reversed = new DirectedG(size());

        for (int v = 0; v < size(); v++) {
            for (int w: adj(v)) {
                reversed.addEdge(w, v);
            }
        }

        return reversed;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}
