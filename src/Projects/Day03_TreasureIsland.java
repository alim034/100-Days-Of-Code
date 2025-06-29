package Projects;

import java.util.Scanner;

public class Day03_TreasureIsland {
    public static void main(String[] args) {
        System.out.println("*** Welcome to Treasure Island Game ***");

        Scanner sc = new Scanner(System.in);

        System.out.println("You\\'re at a crossroad. Where do you want to go? Type \"left\" or \"right\"");
        String choice1 = sc.nextLine().toLowerCase();

        if(choice1.equals("left")) {
            System.out.println("'You\\'ve come to a lake. There is an island in the middle of the lake. Type \"wait\" to wait for a boat. Type \"swim\" to swim across.");
            String choice2 = sc.nextLine().toLowerCase();
            if(choice2.equals("wait")) {
                System.out.println("You arrive at the island unharmed. There is a house with 3 doors. One \"red\", one \"yellow\", one \"blue\". Which color do you choose?");
                String choice3 = sc.nextLine().toLowerCase();
                if(choice3.equals("red")) {
                    System.out.println("It's a room full of fire. Game Over.");
                } else if(choice3.equals("yellow")) {
                    System.out.println("You found the treasure. You win!");
                } else if (choice3.equals("blue")) {
                    System.out.println("You enter a room of beasts. Game Over.");
                } else {
                    System.out.println("You chose a door that doesn't exist. Game Over.");
                }
            } else {
                System.out.println("You got attacked by an angry trout. Game Over.");
            }
        } else {
            System.out.println("You fell into a hole. Game Over.");
        }
    }
}
