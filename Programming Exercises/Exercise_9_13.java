// (The Location class) Design a class named Location fro locating a maximal value and its location in a two-dimensional array.
// The class contains public data fields row, column, and maxValue that store the maximal value and its indices in a two-dimensional array with row and column as int types and maxValue as a double type.
// Write the following method that returns the location of the largest element in a two-dimensional array:
// public static Location locateLargest(double[][] a)
// The return value is an instance of Location.
// Write a test program that prompts the user to enter a two-dimensional array and displays the location of the largest element in the array.
// Here is a sample run:
// Enter the number of rows and columns in the array: 3 4
// Enter the array:
// 23.5 35 2 10
// 4.5 3 45 3.5
// 35 44 5.5 9.6
// The location of the largest element is 45 at (1, 2)

import java.util.Scanner;

public class Exercise_9_13 {
    public static class Location {
        public int row, column;
        public double maxValue;

        public Location(double maxValue, int row, int column) {
            this.maxValue = maxValue;
            this.row = row;
            this.column = column;
        }
    }

    public static Location locateLargest(double[][] a) {
        Location location = new Location(a[0][0], 0, 0);

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] > location.maxValue) {
                    location.maxValue = a[i][j];
                    location.row = i;
                    location.column = j;
                }
            }
        }

        return location;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of rows and columns in the array: ");

        int rows = input.nextInt();
        int columns = input.nextInt();
        double[][] array = new double[rows][columns];

        System.out.println("Enter the array: ");
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                array[i][j] = input.nextDouble();

        Location location = locateLargest(array);
        System.out.println(
                "The location of the largest element is " + location.maxValue + " at (" + location.row + ", "
                        + location.column + ")");
        input.close();
    }
}
