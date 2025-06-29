package Projects;

import java.util.Random;
import java.util.Scanner;

public class Day04_RockPaperScissors {

    public static void main(String[] args) {
        System.out.println("*** Welcome to Rock, Paper, Scissors Game ***");

        Scanner sc = new Scanner(System.in);
        System.out.println("What do you choose? Type 0 for \"rock\", 1 for \"paper\" or 2 for \"scissors\"");
        int userChoice = sc.nextInt();
        System.out.println("User Chose: " + userChoice);

        Random rand = new Random();
        int computerChoice = rand.nextInt(0,2);
        System.out.println("Computer chose: " + computerChoice);

        // Check for User Input
        if(userChoice>=3 || userChoice < 0) {
            System.out.println("You typed an invalid number. You lose.");
        }

        // Game Decision Logic
        if(userChoice == computerChoice) {
            System.out.println("It's Draw");
        } else if (userChoice==0 && computerChoice==2) {
            System.out.println("You Win!!");
        } else if (computerChoice==0 && userChoice==2) {
            System.out.println("You Lose!!");
        } else if (userChoice>computerChoice) {
            System.out.println("You Win!!");
        } else {
            System.out.println("You Lose!!");
        }
    }
}
