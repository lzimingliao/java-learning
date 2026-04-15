// (Mersenne prime) A prime number is called a Mersenne prime if it can be written in the form 2^p - 1 for some positive integer p.
// Write a program that finds all Mersenne primes with p <= 31 and displays the output as follows:
// p     2^p - 1
// 2     3
// 3     7
// 5     31
// ...

public class Exercise_6_28 {
    public static boolean prime(long number) {
        for (long i = 2; i * i <= number; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("p     2^p - 1");
        for (int p = 2; p <= 31; p++) {
            long mersennePrime = (1L << p) - 1;
            if (prime(mersennePrime)) {
                System.out.printf("%-5d %d%n", p, mersennePrime);
            }
        }
    }
}
