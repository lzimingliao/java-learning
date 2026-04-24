// (Palindromic prime) A palindromic prime is a prime number and also palindromic. For example, 131 is a prime and also a palindromic prime,
// as are 313 and 757.
// Write a program that displays the first 100 palindromic prime numbers.
// Display 10 numbers per line, separated by exactly one space, as follows:
// 2 3 5 7 11 101 131 151 181 191
// 313 353 373 383 727 757 787 797 919 929
// ...

public class Exercise_6_26 {
    public static boolean palindromic(int number) {
        int rev = 0, tmp = number;
        while (tmp > 0) {
            rev = rev * 10 + tmp % 10;
            tmp /= 10;
        }
        return rev == number;
    }

    public static boolean prime(int number) {
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int cnt = 0, number = 2;
        while (cnt < 100) {
            if (palindromic(number) && prime(number)) {
                cnt++;
                if (cnt % 10 == 0)
                    System.out.println(number);
                else
                    System.out.print(number + " ");
            }
            number++;
        }
    }
}
