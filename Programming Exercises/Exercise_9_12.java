// (Geometry: intersecting point) Suppose two line segments intersect.
// The two endpoints for the first line segment are (x1, y1) and (x2, y2) and for the second line segment are (x3, y3) and (x4, y4).
// Write a program that prompts the user to enter these four endpoints and displays the intersecting point.
// As discussed in Programming Exercise 3.25, the intersecting point can be found by solving a linear equation.
// Use the LinearEquation class in Programming Exercise 9.11 to solve this equation.
// See Programming Exercise 3.25 for sample runs.
// Two points on line 1 are given as (x1,y1) and (x2,y2) and on line 2 as (x3,y3) and (x4,y4).
// The intersecting point of the two lines can be found by solving the following linear equation:
// (y1 - y2)x + (x2 - x1)y = (y1 - y2)x1 + (x2 - x1)y1
// (y3 - y4)x + (x4 - x3)y = (y3 - y4)x3 + (x4 - x3)y3
// Enter x1, y1, x2, y2, x3, y3, x4, y4: 2 2 5 -1.0 4.0 2.0 -1.0 -2.0
// The intersecting point is at (2.88889, 1.1111)
// Enter x1, y1, x2, y2, x3, y3, x4, y4: 2 2 7 6.0 4.0 2.0 -1.0 -2.0
// The two lines are parallel

import java.util.Scanner;

public class Exercise_9_12 {
    public static class LinearEquation {
        private double a, b, c, d, e, f;

        public LinearEquation(double a, double b, double c, double d, double e, double f) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
            this.f = f;
        }

        public double getA() {
            return a;
        }

        public double getB() {
            return b;
        }

        public double getC() {
            return c;
        }

        public double getD() {
            return d;
        }

        public double getE() {
            return e;
        }

        public double getF() {
            return f;
        }

        public boolean isSolvable() {
            return a * d - b * c != 0;
        }

        public double getX() {
            return (e * d - b * f) / (a * d - b * c);
        }

        public double getY() {
            return (a * f - e * c) / (a * d - b * c);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double x1, y1, x2, y2, x3, y3, x4, y4;
        System.out.print("Enter x1, y1, x2, y2, x3, y3, x4, y4: ");

        x1 = input.nextDouble();
        y1 = input.nextDouble();
        x2 = input.nextDouble();
        y2 = input.nextDouble();
        x3 = input.nextDouble();
        y3 = input.nextDouble();
        x4 = input.nextDouble();
        y4 = input.nextDouble();

        LinearEquation L = new LinearEquation(y1 - y2, x2 - x1, y3 - y4, x4 - x3,
                (y1 - y2) * x1 + (x2 - x1) * y1, (y3 - y4) * x3 + (x4 - x3) * y3);

        if (L.isSolvable())
            System.out.printf("The intersecting point is at (%.5f, %.5f)%n", L.getX(), L.getY());
        else
            System.out.println("The two lines are parallel");

        input.close();
    }
}
