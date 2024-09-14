import java.util.ArrayList;
import java.util.List;

public class Node {
    int currentCost;
    boolean costCalculated = false;
    List<Gate> gates = new ArrayList<>();

    public void createConnection(int cost, Node destination) {
        this.gates.addLast(new Gate(cost, destination));
    }

    public void setCost(int cost) {
        this.currentCost = cost;
        this.costCalculated = true;
    }

    public Node(int currentCost) {
        this.currentCost = currentCost;
        this.costCalculated = true;
    }

    public Node() {
    }
}
