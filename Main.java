import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        int capacity;
        int numberOfItems;
        int[] values;
        int[] weights;

        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            String[] firstLine = br.readLine().split(" ");
            capacity = Integer.parseInt(firstLine[0]);
            numberOfItems = Integer.parseInt(firstLine[1]);
            values = Arrays.stream(br.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
            weights = Arrays.stream(br.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        }

        Knapsack knapsack = new Knapsack(capacity, numberOfItems, values, weights);
        knapsack.solve();
        knapsack.printBestCombination();
    }
}