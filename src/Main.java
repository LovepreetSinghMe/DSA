import graphs.ConnectedComponentsPath;
import graphs.UndirecetedGraphADJBag;
import symboltables.BST;

public class Main {
    public static void main(String[] args) {
        UndirecetedGraphADJBag g = new UndirecetedGraphADJBag(13);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 6);
        g.addEdge(0, 5);
        g.addEdge(6, 4);
        g.addEdge(4, 3);
        g.addEdge(4, 5);
        g.addEdge(7, 8);
        g.addEdge(9, 10);
        g.addEdge(9, 11);
        g.addEdge(9, 12);
        g.addEdge(11, 12);

        ConnectedComponentsPath cc = new ConnectedComponentsPath(g);

        System.out.println(cc.connected(7, 6));
    }
}