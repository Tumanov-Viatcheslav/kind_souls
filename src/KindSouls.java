import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class KindSouls {
    public static void main(String[] args) {
        int result = 0;
        String inputData = "";
        Graph map;
        try(BufferedReader input = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = input.readLine()) != null)
                inputData += line + "\n";
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        map = new Graph(inputData);
        result = map.calculateCheapestPath();

        try(FileWriter output = new FileWriter("output.txt")) {
            output.write(String.valueOf(result));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}