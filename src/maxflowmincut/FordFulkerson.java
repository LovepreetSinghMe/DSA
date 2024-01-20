package maxflowmincut;

import stacksqueues.LinkedListQueue;

public class FordFulkerson {
    private boolean[] marked;
    private FlowEdge[] edgeTo;

    private double value;

    public FordFulkerson(FlowNetwork fn, int s, int t) {
        value = 0.0;

        while (hasAugmentingPath(fn, s, t)) {
            double bottle = Double.POSITIVE_INFINITY;

            for (int v = t; v != s; v = edgeTo[v].other(v)) {
                bottle = Math.min(bottle, edgeTo[v].residualCapacityTo(v));
            }

            for (int v = t; v != s; v = edgeTo[v].other(v)) {
                edgeTo[v].addResidualFlowTo(v, bottle);
            }

            value += bottle;
        }
    }

//    is a vertex reachable from s and is marked in the residual flow network
    public boolean inCut(int v) {
        return marked[v];
    }

    private boolean hasAugmentingPath(FlowNetwork fn, int s, int t) {
        LinkedListQueue<Integer> q = new LinkedListQueue<>();

        marked = new boolean[fn.size()];
        edgeTo = new FlowEdge[fn.size()];

        marked[s] = true;
        q.enqueue(s);

        while (!q.isEmpty()) {
            int v = q.dequeue();

            for (FlowEdge e: fn.adj(v)) {
                int w = e.other(v);

                if (e.residualCapacityTo(w) > 0 && !marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = e;
                    q.enqueue(w);
                }
            }
        }

        return marked[t];
    }
}
