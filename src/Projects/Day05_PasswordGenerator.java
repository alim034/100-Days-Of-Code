package Projects;

import java.util.*;

public class Day05_PasswordGenerator {
    public static void main(String[] args) {
        System.out.println("*** Welcome To Password Generator ***");

        // Global Variables
        String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*()-_=+[]{};:,.<>?/";

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("How many letters would you like in your password? ");
        int numLetters = sc.nextInt();

        System.out.print("How many symbols? ");
        int numSymbols = sc.nextInt();

        System.out.print("How many numbers? ");
        int numNumbers = sc.nextInt();

        // Easy level
        List<Character> password = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        // for letters
        for(int i=0; i<numLetters; i++) {
            char ch = letters.charAt(rand.nextInt(letters.length()));
            sb.append(ch);
            password.add(ch);
        }

        // for symbols
        for (int i = 0; i < numSymbols; i++) {
            char ch = symbols.charAt(rand.nextInt(symbols.length()));
            sb.append(ch);
            password.add(ch);
        }

        // for numbers
        for (int i = 0; i < numNumbers; i++) {
            char ch = numbers.charAt(rand.nextInt(numbers.length()));
            sb.append(ch);
            password.add(ch);
        }

        System.out.println("Your password (Easy Level): " + password);


        // Hard Level: Shuffle characters
        Collections.shuffle(password);
        StringBuilder hardPassword = new StringBuilder();
        for (char ch : password) {
            hardPassword.append(ch);
        }

        System.out.println("Your password (Hard Level): " + hardPassword);
    }
}
