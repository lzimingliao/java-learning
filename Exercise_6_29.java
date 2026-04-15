// (Twin primes) Twin primes are a pair of prime numbers that differ by 2.
// For example, 3 and 5 are twin primes, 5 and 7 are twin primes, and 11 and 13 are twin primes.
// Write a program to find all twin primes less than 1000.
// Displays the output as follows:
// (3, 5)
// (5, 7)
// ...

public class Exercise_6_29 {
    public static boolean prime(int number) {
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        for (int i = 3; i < 1000 - 2; i += 2) {
            if (prime(i) && prime(i + 2)) {
                System.out.printf("(%d, %d)%n", i, i + 2);
            }
        }
    }
}
