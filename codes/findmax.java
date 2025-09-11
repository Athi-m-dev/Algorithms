package codes;
import java.util.Scanner;

public class findmax {
      public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        int a = obj.nextInt();
        int b = obj.nextInt();
        int max = (a > b) ? a : b;
        System.out.print("The maximum number is: " + max);
      }
}