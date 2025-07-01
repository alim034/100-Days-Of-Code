package Projects;

import java.util.Scanner;
import java.util.Random;

public class Day12_NumberGuessingProject {
        static final int EASY_LEVEL_TURNS = 10;
        static final int HARD_LEVEL_TURNS = 5;

        // Function to check user's guess
        public static int checkAnswer(int guess, int actualAnswer, int turns) {
            if (guess > actualAnswer) {
                System.out.println("Too high.");
                return turns - 1;
            } else if (guess < actualAnswer) {
                System.out.println("Too low.");
                return turns - 1;
            } else {
                System.out.println("You got it! The answer was " + actualAnswer);
                return turns;
            }
        }

        // Function to set difficulty
        public static int setDifficulty(Scanner scanner) {
            System.out.print("Choose a difficulty. Type 'easy' or 'hard': ");
            String level = scanner.nextLine().toLowerCase();
            if (level.equals("easy")) {
                return EASY_LEVEL_TURNS;
            } else {
                return HARD_LEVEL_TURNS;
            }
        }

        // Main game logic
        public static void game() {
            Scanner scanner = new Scanner(System.in);
            Random rand = new Random();

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I'm thinking of a number between 1 and 100.");
            int answer = rand.nextInt(100) + 1;
            System.out.println("(Pssst, the correct answer is " + answer + ")");

            int turns = setDifficulty(scanner);
            int guess = 0;

            while (guess != answer && turns > 0) {
                System.out.println("You have " + turns + " attempts remaining to guess the number.");
                System.out.print("Make a guess: ");
                guess = scanner.nextInt();
                scanner.nextLine(); // Clear input buffer

                turns = checkAnswer(guess, answer, turns);

                if (turns == 0 && guess != answer) {
                    System.out.println("You've run out of guesses, you lose.");
                } else if (guess != answer) {
                    System.out.println("Guess again.\n");
                }
            }

            scanner.close();
        }

        public static void main(String[] args) {
            game();
        }
}
