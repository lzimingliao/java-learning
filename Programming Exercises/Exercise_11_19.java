// (Bin packing using first fit) The bin packing problem is to pack objects of various weights into containers.
// Assume each container can hold a maximum of 10 pounds.
// The program uses an algorithm that places an object into the first bin in which it would it.
// Your program should prompt the user to enter the total number of objects and the weight of each object.
// The program displays the total number of containers needed to pack the objects and the contents of each container.
// Here is a sample run of the program:
// Enter the number of objects: 6
// Enter the weights of the objects: 7 5 2 3 5 8
// Container 1 contains objects with weight 7 2
// Container 2 contains objects with weight 5 3
// Container 3 contains objects with weight 5
// Container 4 contains objects with weight 8
// Does this program produce an optimal solution, that is, finding the minimum number of containers to pack the objects?

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise_11_19 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of objects: ");
        int numberOfObjects = input.nextInt();

        System.out.print("Enter the weights of the objects: ");
        int[] weights = new int[numberOfObjects];
        for (int i = 0; i < numberOfObjects; i++)
            weights[i] = input.nextInt();

        ArrayList<ArrayList<Integer>> containers = new ArrayList<>();
        for (int weight : weights) {
            boolean placed = false;
            for (ArrayList<Integer> container : containers) {
                int currentWeight = 0;
                for (int w : container)
                    currentWeight += w;
                if (currentWeight + weight <= 10) {
                    container.add(weight);
                    placed = true;
                    break;
                }
            }

            if (!placed) {
                ArrayList<Integer> newContainer = new ArrayList<>();
                newContainer.add(weight);
                containers.add(newContainer);
            }
        }

        for (int i = 0; i < containers.size(); i++) {
            ArrayList<Integer> container = containers.get(i);
            System.out.print("Container " + (i + 1) + " contains objects with weight ");
            for (int w : container)
                System.out.print(w + " ");
            System.out.println();
        }

        input.close();
    }
}
