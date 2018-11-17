package Distance;
import java.io.*;
import java.util.Scanner;

public class ShortDistance {

    // Global Variables
    private static int[][] distances;
    private static int finalResults[];
    private static String paths[];
    private static int counter = 0;


    // Main Function
    
    public static void main(String args[]) throws IOException{


        // scanner 
        Scanner input = new Scanner(System.in);
        System.out.println("Please, Enter the path where the text file is stored");
        String file = input.nextLine();

        // Please enter the size of the distance
        System.out.println("Please, Enter the size of the matrix");
        int size = input.nextInt();

        // Global variables are initialized considering the size of the matrix
        int numSolutions = factorial(size - 1);
        distances = new int[size][size];
        finalResults = new int[numSolutions];
        paths = new String[numSolutions];

        // The file in that location is opened
        FileReader f = new FileReader(file);
        BufferedReader b = new BufferedReader(f);


        // Our matrix is filled with the values of the file matrix
        for (int row = 0 ; row < size ; row++) {

            // Every value of each row is read and stored
            String line = b.readLine();
            String[] values = line.trim().split("\\s+");

            for (int col = 0; col < size; col++) {
                distances[row][col] = Integer.parseInt(values[col]);
            }
        }

        // Closing file
        b.close();

        /* ------------------------- Starting Algorithm ----------------------- */

        // Initial variables to start the algorithm
        String path = "";
        int[] vertices = new int[size - 1];

        // Filling the initial vertices array with the proper values
        for (int i = 1; i < size; i++) {
            vertices[i - 1] = i;
        }

        // first call to recursive function
        int distance = procedure(0, vertices, path, 0);

        int shortPath = 0;
        for (int i = 0; i < numSolutions; i++) {

            System.out.print("Path: " + paths[i] + ". Distance = " + finalResults[i] + "\n");

            // When we reach the shortest one, its index is saved
            if (finalResults[i] == distance) {
                shortPath = i;
            }
        }
        System.out.println();
        System.out.print("Path: " + paths[shortPath] + ". Distance = " + finalResults[shortPath] + " (ShortestPath)");
    }



    /* ------------------------------- RECURSIVE FUNCTION ---------------------------- */

    private static int procedure(int initial, int vertices[], String path, int costUntilHere) {

        // We concatenate the current path and the vertex taken as initial
        path = path + Integer.toString(initial) + " - ";
        int length = vertices.length;
        int newCostUntilHere;


        // Exit case, if there are no more options to evaluate (last node)
        if (length == 0) {

            // Both results, numerical distances and paths to those distances, are stored
            paths[counter] = path + "0";
            finalResults[counter] = costUntilHere + distances[initial][0];

            counter++;
            return (distances[initial][0]);
        }


        // Common case, where there are more than 1 path
        else {

            int[][] newVertices = new int[length][(length - 1)];
            int costCurrentNode, costChild;
            int bestCost = Integer.MAX_VALUE;

            // For each of the nodes of the list
            for (int i = 0; i < length; i++) {

                // Each recursion new vertices list is constructed
                for (int j = 0, k = 0; j < length; j++, k++) {

                    // The current child is not stored in the new vertices array
                    if (j == i) {
                        k--;
                        continue;
                    }
                    newVertices[i][k] = vertices[j];
                }

                // Cost of arriving the current node from its parent
                costCurrentNode = distances[initial][vertices[i]];

                // Here the cost to be passed to the recursive function is computed
                newCostUntilHere = costCurrentNode + costUntilHere;

                // RECURSIVE CALLS TO THE FUNCTION IN ORDER TO COMPUTE THE COSTS
                costChild = procedure(vertices[i], newVertices[i], path, newCostUntilHere);

                // The cost of every child + the current node cost is computed
                int totalCost = costChild + costCurrentNode;

                // Finally we select from the minimum from all possible children costs
                if (totalCost < bestCost) {
                    bestCost = totalCost;
                }
            }

            return (bestCost);
        }
    }



    // Factorial function used to calculate the number of solutions
    private static int factorial(int n) {

        if (n <= 1) return 1;
        else return (n * factorial(n - 1));
    }
}
