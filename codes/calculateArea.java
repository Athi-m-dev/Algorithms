package codes;
import java.util.Scanner;
class CalculateArea {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        System.out.print("Enter length and breadth of rectangle: ");
        int length = obj.nextInt();
        int breadth = obj.nextInt();
        System.out.print("Enter 'r' for rectangle, 't' for triangle and 'c' for circle: ");
        char choice = obj.next().charAt(0);
        int Area = calculateArea(length, breadth , choice);
        System.out.println("Area  is: " + Area);

    }

    public static int calculateArea(int length, int breadth , char choice) {
        if (choice == 'r') {
            return length * breadth;
        } else if (choice == 't') {
            return (length * breadth) / 2;
        } else {
            return (int) (3.14 * length * length);
        }
    }
}