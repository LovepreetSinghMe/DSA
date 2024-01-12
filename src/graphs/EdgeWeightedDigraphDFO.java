package graphs;

import shortestpaths.DirectedEdge;
import shortestpaths.EdgeWeightedDigraph;
import stacksqueues.LinkedListStack;

public class EdgeWeightedDigraphDFO {
    private boolean[] marked;

    private LinkedListStack<Integer> reversePost;

    public EdgeWeightedDigraphDFO(EdgeWeightedDigraph g) {
        marked = new boolean[g.size()];
        reversePost = new LinkedListStack<>();
    }

    public void dfs(EdgeWeightedDigraph g, int v) {
        this.marked[v] = true;

        for (DirectedEdge e : g.adj(v)) {
            int w = e.to();
            if (!this.marked[w]) {
                dfs(g, w);
            }

            reversePost.push(v);
        }
    }

    public Iterable<Integer> reversePost() {
        return reversePost;
    }
}
