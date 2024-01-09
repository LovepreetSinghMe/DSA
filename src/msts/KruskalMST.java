package msts;

import graphs.Edge;
import graphs.EdgeWeightedG;
import priorityqueues.MinPQ;
import stacksqueues.LinkedListQueue;
import unionfind.QuickUnionUF;

import java.util.ArrayList;

public class KruskalMST {
    private LinkedListQueue<Edge> mst = new LinkedListQueue<>();
    public KruskalMST(EdgeWeightedG g) {
        MinPQ<Edge> pq = new MinPQ<>();

        for (Edge e: g.edges()) {
            pq.insert(e);
        }

        QuickUnionUF uf = new QuickUnionUF(g.size());

        while (!pq.isEmpty() && mst.size() < g.size() - 1) {
            Edge e = pq.deleteMin();
            int v = e.either(), w = e.other(v);
            if (!uf.connected(v, w)) {
                mst.enqueue(e);
                uf.union(v, w);
            }
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }
}
