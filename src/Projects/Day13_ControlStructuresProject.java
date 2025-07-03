package Projects;

public class Day13_ControlStructuresProject {
    public static void main(String[] args) {
        int num = 234;
        int year = 2016;

        System.out.println(even_odd(num));
        System.out.println(leap_year_cheker(year));
        fizzBuzz_Game(num);

    }

    // Function To Check if the number is even or odd
    public static boolean even_odd(int n) {
        if(n%2==0) {
            return true;
        }

        return false;
    }


    // Function To Check if the Year is leap or not
    public static boolean leap_year_cheker(int y) {
        if((y%4==0 && y%100!=0) || (y%400==0)) {
            return true;
        }

        return false;
    }


    // Function For the FizzBuzz game
    public static void fizzBuzz_Game(int n) {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.print(i + " ");
            }
        }
    }

}
