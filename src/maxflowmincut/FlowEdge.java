package maxflowmincut;

public class FlowEdge {
    private final int v, w;
    private final double capacity;
    private double flow;
    public FlowEdge(int v, int w, double capacity) {
        this.v = v;
        this.w = w;
        this.capacity = capacity;
        this.flow = 0;
    }

    public int from() {
        return v;
    }

    public int to() {
        return w;
    }

    public int other(int vertex) {
        if (vertex == this.v) return w;
        else if (vertex == this.w) return v;
        else throw new RuntimeException("Illegal Endpoint");
    }

    public double capacity() {
        return this.capacity;
    }

    public double flow() {
        return this.flow;
    }

    public double residualCapacityTo(int vertex) {
        if (vertex == this.from()) return this.flow();
        else if (vertex == this.to()) return this.capacity() - this.flow();
        else throw new IllegalArgumentException();
    }

    public void addResidualFlowTo(int vertex, double delta) {
        if (vertex == this.from()) flow -= delta;
        else if (vertex == this.to()) flow += delta;
        else throw new IllegalArgumentException();
    }
}
