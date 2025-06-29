package Projects;

import java.util.Scanner;

public class Day01_BandNameGenerator {

    public static void main(String[] args) {
        System.out.println("***Welcome to the Band Name Generator***");

        Scanner sc = new Scanner(System.in);
        System.out.println("Which city did you grow up in?");
        String cityName = sc.nextLine();

        System.out.println("Enter Your Pet Name");
        String petName = sc.nextLine();

        // Your Band Name is:
        System.out.println("Band Name Is: ");
        System.out.println(cityName + " " + petName);
    }
}
