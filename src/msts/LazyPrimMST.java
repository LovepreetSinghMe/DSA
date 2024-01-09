package msts;

import graphs.Edge;
import graphs.EdgeWeightedG;
import priorityqueues.MinPQ;
import stacksqueues.LinkedListQueue;

public class LazyPrimMST {
    private MinPQ<Edge> pq;
    private LinkedListQueue<Edge> mst;

    private boolean[] marked;

    public LazyPrimMST(EdgeWeightedG g) {
        marked = new boolean[g.size()];
        pq = new MinPQ<>();
        mst = new LinkedListQueue<>();

        visit(g, 0);

        while (!pq.isEmpty()) {
            Edge e = pq.deleteMin();
            int v = e.either(), w = e.other(v);

            if (marked[v] && marked[w]) continue;

            mst.enqueue(e);

            if (!marked[v]) visit(g, v);
            if (!marked[w]) visit(g, w);
        }
    }

    private void visit(EdgeWeightedG g, int v) {
        marked[v] = true;

        for (Edge e: g.adj(v)) {
            if (!marked[e.other(v)]) {
                pq.insert(e);
            }
        }
    }
}
