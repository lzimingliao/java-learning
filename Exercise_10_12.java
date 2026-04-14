// (Geometry: the Triangle2D class) Define the Triangle2D class that contains:
// The points named p1, p2, and p3 of the type MyPoint with getter methods and setter methods.
// A no-arg constructor that creates a default triangle with the points (0, 0), (1, 1), and (2, 5).
// A constructor that creates a triangle with the specified points.
// A method named getArea() that returns the area of the triangle.
// A method named getPerimeter() that returns the perimeter of the triangle.
// A method named contains(MyPoint p) that returns true if the specified point is inside this triangle.
// A method named contains(Triangle2D t) that returns true if the specified triangle is inside this triangle.
// A method named overlaps(Triangle2D t) that returns true if the specified triangle overlaps with this triangle.
// Draw the UML diagram for the class and then implement the class.
// Write a test program that creates a Triangle2D object t1 using the constructor new Triangle2D(new MyPoint(2.5, 2), new MyPoint(4.2, 3), new MyPoint(5, 3.5)),
// displays its area and perimeter, and displays the result of t1.contains(3, 3), t1.contains(new Triangle2D(new MyPoint(2.9, 2), new MyPoint(4, 1), new MyPoint(1, 3.4))),
// and t1.overlaps(new Triangle2D(new MyPoint(2, 5.5), new MyPoint(4, -3), new MyPoint(2, 6.5))).

public class Exercise_10_12 {
    public static void main(String[] args) {
        Triangle2D t1 = new Triangle2D(new MyPoint(2.5, 2), new MyPoint(4.2, 3), new MyPoint(5, 3.5));
        System.out.println("Area: " + t1.getArea());
        System.out.println("Perimeter: " + t1.getPerimeter());
        System.out.println("Contains(new MyPoint(3, 3)): " + t1.contains(new MyPoint(3, 3)));
        System.out.println("Contains(triangle): "
                + t1.contains(new Triangle2D(new MyPoint(2.9, 2), new MyPoint(4, 1), new MyPoint(1, 3.4))));
        System.out.println("Overlaps(triangle): "
                + t1.overlaps(new Triangle2D(new MyPoint(2, 5.5), new MyPoint(4, -3), new MyPoint(2, 6.5))));
    }

    public static class MyPoint {
        private double x;
        private double y;

        public MyPoint() {
            this.x = 0;
            this.y = 0;
        }

        public MyPoint(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public double distance(MyPoint another) {
            return Math.sqrt(Math.pow(this.x - another.x, 2) + Math.pow(this.y - another.y, 2));
        }

        public double distance(double x, double y) {
            return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));
        }

        public static double distance(MyPoint point1, MyPoint point2) {
            return Math.sqrt(Math.pow(point1.x - point2.x, 2) + Math.pow(point1.y - point2.y, 2));
        }
    }

    public static class Triangle2D {
        private MyPoint p1, p2, p3;

        public MyPoint getP1() {
            return p1;
        }

        public MyPoint getP2() {
            return p2;
        }

        public MyPoint getP3() {
            return p3;
        }

        public void setP1(MyPoint point) {
            this.p1 = point;
        }

        public void setP2(MyPoint point) {
            this.p2 = point;
        }

        public void setP3(MyPoint point) {
            this.p3 = point;
        }

        public Triangle2D() {
            this.p1 = new MyPoint(0, 0);
            this.p2 = new MyPoint(1, 1);
            this.p3 = new MyPoint(2, 5);
        }

        public Triangle2D(MyPoint p1, MyPoint p2, MyPoint p3) {
            this.p1 = p1;
            this.p2 = p2;
            this.p3 = p3;
        }

        public double getArea() {
            double a = this.p1.distance(this.p2);
            double b = this.p2.distance(this.p3);
            double c = this.p3.distance(this.p1);
            double s = (a + b + c) / 2;
            return Math.sqrt(s * (s - a) * (s - b) * (s - c));
        }

        public double getPerimeter() {
            double a = this.p1.distance(this.p2);
            double b = this.p2.distance(this.p3);
            double c = this.p3.distance(this.p1);
            return a + b + c;
        }

        public boolean contains(MyPoint p) {
            double area1 = new Triangle2D(this.p1, this.p2, p).getArea(); // ABp
            double area2 = new Triangle2D(this.p1, this.p3, p).getArea(); // ACp
            double area3 = new Triangle2D(this.p2, this.p3, p).getArea(); // BCp
            return Math.abs(area1 + area2 + area3 - this.getArea()) < 1E-10;
        }

        public boolean contains(Triangle2D t) {
            return this.contains(t.getP1()) && this.contains(t.getP2()) && this.contains(t.getP3());
        }

        public boolean overlaps(Triangle2D t) {
            if (this.contains(t.getP1()) || this.contains(t.getP2()) || this.contains(t.getP3()))
                return true;
            if (t.contains(this.getP1()) || t.contains(this.getP2()) || t.contains(this.getP3()))
                return true;

            MyPoint[] edges1 = { this.p1, this.p2, this.p3, this.p1 };
            MyPoint[] edges2 = { t.getP1(), t.getP2(), t.getP3(), t.getP1() };

            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                    if (linesIntersect(edges1[i], edges1[i + 1], edges2[j], edges2[j + 1]))
                        return true;
            return false;
        }

        public boolean linesIntersect(MyPoint p1, MyPoint q1, MyPoint p2, MyPoint q2) {
            return ccw(p1, p2, q2) != ccw(q1, p2, q2) && ccw(p1, q1, p2) != ccw(p1, q1, q2);
        }

        public boolean ccw(MyPoint a, MyPoint b, MyPoint c) {
            return (c.getY() - a.getY()) * (b.getX() - a.getX()) > (b.getY() - a.getY()) * (c.getX() - a.getX());
        }
    }
}
