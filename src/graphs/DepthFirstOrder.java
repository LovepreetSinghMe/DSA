package graphs;

import stacksqueues.LinkedListStack;

public class DepthFirstOrder {
    private boolean[] marked;

    private LinkedListStack<Integer> reversePost;

    DepthFirstOrder(DirectedG g) {
        marked = new boolean[g.size()];
        reversePost = new LinkedListStack<>();
    }

    public void dfs(DirectedG g, int v) {
        this.marked[v] = true;

        for (int w : g.adj(v)) {
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
