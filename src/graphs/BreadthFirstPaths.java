package graphs;

import stacksqueues.LinkedListQueue;

public class BreadthFirstPaths {
    private final boolean[] marked;
    private final int[] edgeTo;

    BreadthFirstPaths(UndirecetedGraphADJBag g) {
        this.marked = new boolean[g.size()];
        this.edgeTo = new int[g.size()];
    }

    public void bfs(UndirecetedGraphADJBag g, int s) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();

        queue.enqueue(s);
        marked[s] = true;

        while (!queue.isEmpty()) {
            int w = queue.dequeue();

            for (int v: g.adj(w)) {
                if (!marked[v]) {
                    queue.enqueue(v);
                    marked[v] = true;
                    edgeTo[v] = w;
                }
            }
        }
    }
}
