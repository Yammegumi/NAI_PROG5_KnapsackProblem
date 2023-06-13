import java.util.ArrayList;
import java.util.List;

public class Knapsack {
    private final int capacity;
    private final int[] values;
    private final int[] weights;
    private List<Boolean> bestCombination;
    private int bestValue;
    private long bestIteration;

    public Knapsack(int capacity, int numberOfItems, int[] values, int[] weights) {
        this.capacity = capacity;
        this.values = values;
        this.weights = weights;
        this.bestValue = 0;

        if (values.length != numberOfItems || weights.length != numberOfItems) {
            throw new IllegalArgumentException("Number of items doesn't match the length of the values or weights array.");
        }
    }

    public void solve() {
        long iterations = (long) Math.pow(2, values.length);

        for (long i = 0; i < iterations; i++) {
            List<Boolean> currentCombination = getCurrentCombination(i);

            int currentWeight = getCurrentWeight(currentCombination);
            if (currentWeight > capacity) {
                continue;
            }

            int currentValue = getCurrentValue(currentCombination);

            if (currentValue > bestValue) {
                bestValue = currentValue;
                bestCombination = currentCombination;
                bestIteration = i;
                System.out.println("New best found at iteration " + bestIteration + ". Value: " + bestValue + ", Vector: " + bestCombination);
            }
            if (i % 10000 == 0) {
                System.out.println("Iteration: " + i);
            }
        }
    }

    private List<Boolean> getCurrentCombination(long i) {
        List<Boolean> combination = new ArrayList<>();

        for (int j = 0; j < values.length; j++) {
            combination.add((i & (1L << j)) != 0);
        }
        return combination;
    }

    private int getCurrentWeight(List<Boolean> combination) {
        int weight = 0;

        for (int i = 0; i < combination.size(); i++) {
            if (combination.get(i)) {
                weight += weights[i];
            }
        }
        return weight;
    }

    private int getCurrentValue(List<Boolean> combination) {
        int value = 0;

        for (int i = 0; i < combination.size(); i++) {
            if (combination.get(i)) {
                value += values[i];
            }
        }
        return value;
    }
    public void printBestCombination() {
        System.out.println("The best combination is:");
        System.out.println("----------------------------------------");
        for (int i = 0; i < bestCombination.size(); i++) {
            if (bestCombination.get(i)) {
                System.out.printf("Item %d: Value = %d, Weight = %d\n", i+1, values[i], weights[i]);
            }
        }
        System.out.println("----------------------------------------");
        System.out.printf("Total value: %d\n", bestValue);
        System.out.printf("Total weight: %d\n", getCurrentWeight(bestCombination));
        System.out.printf("Found at iteration: %d\n", bestIteration);
    }
}
