package shortestpaths;

import graphs.DepthFirstOrder;
import graphs.EdgeWeightedDigraphDFO;

public class EdgeWeightedDAG {
    private Double[] distTo;
    private DirectedEdge[] edgeTo;

    EdgeWeightedDAG(EdgeWeightedDigraph g, int s) {
        distTo = new Double[g.size()];
        edgeTo = new DirectedEdge[g.size()];

        for(int v = 0; v < g.size(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }

        distTo[s] = 0.0;

        EdgeWeightedDigraphDFO dfo = new EdgeWeightedDigraphDFO(g);

        for (int v: dfo.reversePost()) {
            for(DirectedEdge e: g.adj(v)) {
                relaxEdge(e);
            }
        }
    }

    private void relaxEdge(DirectedEdge e) {
        int v = e.from(), w = e.to();

        if (distTo[w] > distTo[v] + e.weight()) {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
        }
    }
}
