// (Science: day of the week) Zeller's congruence is an algorithm developed by Christian Zeller to calculate the day of the week.
// The formula is
// h = (q + 26(m + 1) / 10 + k + k / 4 + j / 4 + 5j) % 7
// where
// h is the day of the week (0: Saturday, 1: Sunday, 2: Monday, ..., 6: Friday).
// q is the day of the month.
// m is the month (3: March, 4: April, ..., 12: December). January and February are counted as months 13 and 14 of the previous year.
// j is year / 100.
// k is the year of the century (i.e., year % 100).
// Note all divisions in this exercise perform an integer division.
// Write a program that prompts the user to enter a year, month, and day of the month, and displays the name of the day of the week.
// Here are sample runs:
// Enter year: 2012
// Enter month: 1
// Enter the day of the month: 25
// The day of the week is Wednesday
// Enter year: 2012
// Enter month: 5
// Enter the day of the month: 12
// The day of the week is Saturday

import java.util.Scanner;

public class Exercise_3_21 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter year: ");
        int year = input.nextInt();

        System.out.print("Enter month: ");
        int month = input.nextInt();

        System.out.print("Enter the day of the month: ");
        int theDayOfTheMonth = input.nextInt();

        int q = theDayOfTheMonth;
        if (month == 1 || month == 2) {
            month += 12;
            year -= 1;
        }
        int m = month;
        int k = year % 100;
        int j = year / 100;
        int h = (q + 26 * (m + 1) / 10 + k + k / 4 + j / 4 + 5 * j) % 7;

        if (h == 0) {
            System.out.println("The day of the week is Saturday");
        } else if (h == 1) {
            System.out.println("The day of the week is Sunday");
        } else if (h == 2) {
            System.out.println("The day of the week is Monday");
        } else if (h == 3) {
            System.out.println("The day of the week is Tuesday");
        } else if (h == 4) {
            System.out.println("The day of the week is Wednesday");
        } else if (h == 5) {
            System.out.println("The day of the week is Thursday");
        } else {
            System.out.println("The day of the week is Friday");
        }
    }
}
