package Projects;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Day11_BlackjackGame {

    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();

    public static int dealCard() {
        int[] cards = {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
        return cards[rand.nextInt(cards.length)];
    }

    public static int calculateScore(List<Integer> cards) {
        int sum = 0;
        for (int card : cards) sum += card;

        // Blackjack
        if (sum == 21 && cards.size() == 2) return 0;

        // Adjust Ace (11 → 1)
        if (sum > 21 && cards.contains(11)) {
            cards.set(cards.indexOf(11), 1);
            sum = 0;
            for (int card : cards) sum += card;
        }
        return sum;
    }

    public static String compare(int userScore, int compScore) {
        if (userScore == compScore) return "Draw 🙃";
        if (compScore == 0) return "You lose, opponent has Blackjack 😱";
        if (userScore == 0) return "You win with a Blackjack 😎";
        if (userScore > 21) return "You went over. You lose 😭";
        if (compScore > 21) return "Opponent went over. You win 😁";
        if (userScore > compScore) return "You win 😃";
        return "You lose 😤";
    }

    public static void playGame() {
        List<Integer> userCards = new ArrayList<>();
        List<Integer> compCards = new ArrayList<>();

        userCards.add(dealCard());
        userCards.add(dealCard());
        compCards.add(dealCard());
        compCards.add(dealCard());

        boolean gameOver = false;

        while (!gameOver) {
            int userScore = calculateScore(userCards);
            int compScore = calculateScore(compCards);

            System.out.println("Your cards: " + userCards + ", score: " + userScore);
            System.out.println("Computer's first card: " + compCards.get(0));

            if (userScore == 0 || compScore == 0 || userScore > 21) {
                gameOver = true;
            } else {
                System.out.print("Type 'y' to get another card, 'n' to pass: ");
                String choice = sc.nextLine();
                if (choice.equals("y")) {
                    userCards.add(dealCard());
                } else {
                    gameOver = true;
                }
            }
        }

        // Computer draws until score >= 17
        int compScore = calculateScore(compCards);
        while (compScore != 0 && compScore < 17) {
            compCards.add(dealCard());
            compScore = calculateScore(compCards);
        }

        int userScore = calculateScore(userCards);
        System.out.println("Your final hand: " + userCards + ", final score: " + userScore);
        System.out.println("Computer's final hand: " + compCards + ", final score: " + compScore);
        System.out.println(compare(userScore, compScore));
    }

    public static void main(String[] args) {
        while (true) {
            System.out.print("Play a game of Blackjack? (y/n): ");
            String play = sc.nextLine();
            if (!play.equalsIgnoreCase("y")) {
                System.out.println("Goodbye!");
                break;
            }
            playGame();
            System.out.println();
        }
    }
}
