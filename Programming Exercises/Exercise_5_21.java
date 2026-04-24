// (Financial application: compare loans with various interest rates)
// Write a program that lets the user enter the loan amount and loan period in numbers of years,
// and displays the monthly and total payments for each interest rate starting from 5% to 8%,
// with an increment of 1/8.
// Here is a sample run:
// Loan Amount: 10000
// Number of Years: 5
// Interest Rate Monthly Payment Total Payment
// 5.000% $188.71 $11322.74
// 5.125% $189.29 $11357.13
// 5.250% $189.86 $11391.59
// ...
// 7.875% $202.17 $12129.97
// 8.000% $202.76 $12165.84

import java.util.Scanner;

public class Exercise_5_21 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Loan Amount: ");
        double loanAmount = input.nextDouble();

        System.out.print("Number of Years: ");
        int numberOfYears = input.nextInt();

        System.out.println("Interest Rate\tMonthly Payment\tTotal Payment");

        for (double annualInterestRate = 5.0; annualInterestRate <= 8.0; annualInterestRate += 0.125) {

            double monthlyInterestRate = annualInterestRate / 1200;
            double monthlyPayment = loanAmount * monthlyInterestRate
                    / (1 - 1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12));
            double totalPayment = monthlyPayment * numberOfYears * 12;

            System.out.printf("%.3f%%\t\t$%.2f\t\t$%.2f\n", annualInterestRate, monthlyPayment, totalPayment);
        }

        input.close();
    }
}
