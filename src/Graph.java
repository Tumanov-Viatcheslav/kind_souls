import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Graph {
    Node[][] map;

    public int calculateCheapestPath() {
        Stack<Node> stack = new Stack<>();
        Node currentPlanet;
        int min;

        stack.add(this.map[0][0]);
        while (stack.size() > 0) {
            currentPlanet = stack.pop();
            for (Gate gate: currentPlanet.gates) {
                gate.destination.currentCost = currentPlanet.currentCost + gate.cost;
                stack.add(gate.destination);
            }
        }

        min = map[map.length - 1][0].currentCost;
        for (int i = 1; i < map[map.length - 1].length; i++) {
            if (map[map.length - 1][i].currentCost < min)
                min = map[map.length - 1][i].currentCost;
        }
        return min;
    }

    public Graph(String inputData) {
        String[] inputStrings = inputData.split("\n"), gates;
        int totalLevels = Integer.parseInt(inputStrings[0]) + 1, numberOfPlanetsOnLevel, from, cost,
                inputLineIndex = 1, gateLineIndex;

        this.map = new Node[totalLevels][];
        this.map[0] = new Node[1];
        this.map[0][0] = new Node(0);
        for (int i = 1; i < totalLevels; i++) {
            numberOfPlanetsOnLevel = Integer.parseInt(inputStrings[inputLineIndex]);
            inputLineIndex++;
            this.map[i] = new Node[numberOfPlanetsOnLevel];
            for (int j = 0; j < numberOfPlanetsOnLevel; j++) {
                gates = inputStrings[inputLineIndex].split(" ");
                inputLineIndex++;
                gateLineIndex = 0;
                this.map[i][j] = new Node();
                while ((from = Integer.parseInt(gates[gateLineIndex])) != 0) {
                    gateLineIndex++;
                    cost = Integer.parseInt(gates[gateLineIndex]);
                    gateLineIndex++;
                    this.map[i - 1][from - 1].createConnection(cost, this.map[i][j]);
                }
            }
            inputLineIndex++;
        }
    }
}
