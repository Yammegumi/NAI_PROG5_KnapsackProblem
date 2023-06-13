# NAI_KnapsackProblem_PROG5
Knapsack bruteforce solution for NAI lessons in PJATK

This is a Java-based application designed to solve the Knapsack Problem. The algorithm uses a brute-force approach to determine the optimal combination of items that maximizes the total value without exceeding the knapsack's capacity.

## Structure

The project is composed of two main classes: `Knapsack` and `KnapsackProblem`.

- `Knapsack`: This class encapsulates the functionality of the knapsack problem. It holds the information of the capacity of the knapsack, the values and weights of items, and the best combination of items found. The `solve()` method is used to find the optimal solution. It also includes a `printBestCombination()` method to display the best solution found.

- `KnapsackProblem`: This class contains the `main` method. It is responsible for reading the input data file, initializing an instance of the `Knapsack` class with this data, invoking the `solve()` method to find the solution, and calling the `printBestCombination()` method to display the solution.

## Input

The input to the program is provided via a text file that follows this structure:

capacity numberOfItems <br>
v1,v2,v3,v4,...,vn <br>
w1,w2,w3,w4,...,wn <br>

Where:

- `capacity` is the capacity of the knapsack.
- `numberOfItems` is the number of available items.
- `v1,...,vn` are the values of the items.
- `w1,...,wn` are the weights of the items.

Items are separated by commas.

## Output

The output of the program is the optimal combination of items to be included in the knapsack to achieve maximum total value without exceeding the capacity. The program also outputs the total value and weight of the optimal combination and the iteration at which the best solution was found.

## Usage

To run the program, compile the Java files and then execute the `Main` class with the input file as an argument. The output will be printed to the console.