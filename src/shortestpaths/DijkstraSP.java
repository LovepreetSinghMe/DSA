package shortestpaths;

import priorityqueues.IndexedMinPQ;

public class DijkstraSP {
    private Double[] distTo;
    private DirectedEdge[] edgeTo;
    private IndexedMinPQ<Double> pq;
    public DijkstraSP(EdgeWeightedDigraph g, int s) {
        edgeTo = new DirectedEdge[g.size()];
        distTo = new Double[g.size()];

        pq = new IndexedMinPQ<>();

//        start with largest distTo for all vertices
        for (int v = 0; v < g.size(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }

//        since we know point s is 0 from s, we start with it
        distTo[s] = 0.0;

        pq.insert(s, 0.0);

        while (!pq.isEmpty()) {
            int v = pq.extractMin();

//            relax all edges from a point v, closest to point s in terms of distance from origin
            for (DirectedEdge e: g.adj(v)) {
                relaxEdge(e);
            }
        }
    }

    private void relaxEdge(DirectedEdge e) {
        int v = e.from(), w = e.to();

        if (distTo[w] > distTo[v] + e.weight()) {
           distTo[w] = distTo[v] + e.weight();
           edgeTo[w] = e;

//           if pq already has point w, meaning that we found the closest (or closer) distance to w
           if (pq.contains(w)) pq.decreaseKey(w, distTo[w]);
           else pq.insert(w, distTo[w]);
        }
    }
}
