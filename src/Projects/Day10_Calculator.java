package Projects;

import java.util.Scanner;

public class Day10_Calculator {

    public static double add(double n1, double n2) {
        return n1 + n2;
    }

    public static double subtract(double n1, double n2) {
        return n1 - n2;
    }

    public static double multiply(double n1, double n2) {
        return n1 * n2;
    }

    public static double divide(double n1, double n2) {
        return n1 / n2;
    }

    public static void calculator() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("What is the first number?: ");
        double num1 = Double.parseDouble(scanner.nextLine());

        boolean shouldContinue = true;

        while (shouldContinue) {
            System.out.println("Available operations:");
            System.out.println("+\n-\n*\n/");
            System.out.print("Pick an operation: ");
            String operation = scanner.nextLine();

            System.out.print("What is the next number?: ");
            double num2 = Double.parseDouble(scanner.nextLine());

            double answer = 0;
            switch (operation) {
                case "+":
                    answer = add(num1, num2);
                    break;
                case "-":
                    answer = subtract(num1, num2);
                    break;
                case "*":
                    answer = multiply(num1, num2);
                    break;
                case "/":
                    answer = divide(num1, num2);
                    break;
                default:
                    System.out.println("Invalid operation.");
                    continue;
            }

            System.out.println(num1 + " " + operation + " " + num2 + " = " + answer);

            System.out.print("Type 'y' to continue calculating with " + answer + ", or type 'n' to start a new calculation: ");
            String choice = scanner.nextLine().toLowerCase();

            if (choice.equals("y")) {
                num1 = answer;
            } else {
                System.out.println("\n".repeat(20));
                calculator(); // recursive call to restart
                shouldContinue = false; // exit current loop
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        calculator();
    }
}
