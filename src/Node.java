import java.util.ArrayList;
import java.util.List;

public class Node {
    int currentCost;
    List<Gate> gates = new ArrayList<>();

    public void createConnection(int cost, Node destination) {
        this.gates.addLast(new Gate(cost, destination));
    }

    public Node(int currentCost) {
        this.currentCost = currentCost;
    }

    public Node() {
    }
}
