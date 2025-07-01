package Projects;

import java.util.*;

public class Day07_HangmanGame {

    private static final String[] WORD_LIST = {
            "ant", "baboon", "badger", "bat", "bear", "beaver", "camel", "cat",
            "clam", "cobra", "cougar", "coyote", "crow", "deer", "dog", "donkey",
            "duck", "eagle", "ferret", "fox", "frog", "goat", "goose", "hawk",
            "lion", "lizard", "llama", "mole", "monkey", "moose", "mouse", "mule",
            "newt", "otter", "owl", "panda", "parrot", "pigeon", "python", "rabbit",
            "ram", "rat", "raven", "rhino", "salmon", "seal", "shark", "sheep",
            "skunk", "sloth", "snake", "spider", "stork", "swan", "tiger", "toad",
            "trout", "turkey", "turtle", "weasel", "whale", "wolf", "wombat", "zebra"
    };
    private static final int MAX_MISSES = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("H A N G M A N");

        boolean playAgain;
        do {
            String secret = getRandomWord();
            Set<Character> correct = new HashSet<>();
            Set<Character> missed = new LinkedHashSet<>();
            boolean gameOver = false;

            while (!gameOver) {
                displayState(secret, correct, missed);
                System.out.print("Guess a letter: ");
                String input = scanner.nextLine().trim().toLowerCase();
                if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                    System.out.println("Please enter a single letter.");
                    continue;
                }
                char guess = input.charAt(0);
                if (correct.contains(guess) || missed.contains(guess)) {
                    System.out.println("You have already guessed '" + guess + "'.");
                    continue;
                }

                if (secret.indexOf(guess) >= 0) {
                    correct.add(guess);
                    if (isWordGuessed(secret, correct)) {
                        displayState(secret, correct, missed);
                        System.out.println("Yes! The secret word is \"" + secret + "\"! You have won!");
                        gameOver = true;
                    }
                } else {
                    missed.add(guess);
                    if (missed.size() >= MAX_MISSES) {
                        displayState(secret, correct, missed);
                        System.out.println("You have run out of guesses! The word was \"" + secret + "\".");
                        gameOver = true;
                    }
                }
            }

            System.out.print("Do you want to play again? (yes or no): ");
            playAgain = scanner.nextLine().trim().toLowerCase().startsWith("y");
        } while (playAgain);
        System.out.println("Thanks for playing!");
        scanner.close();
    }

    private static String getRandomWord() {
        Random rand = new Random();
        return WORD_LIST[rand.nextInt(WORD_LIST.length)];
    }

    private static boolean isWordGuessed(String secret, Set<Character> correct) {
        for (char c : secret.toCharArray()) {
            if (!correct.contains(c)) {
                return false;
            }
        }
        return true;
    }

    private static void displayState(String secret, Set<Character> correct, Set<Character> missed) {
        // Display current guessed word
        for (char c : secret.toCharArray()) {
            System.out.print(correct.contains(c) ? c + " " : "_ ");
        }
        System.out.println();
        // Display missed letters
        System.out.print("Missed letters: ");
        for (char c : missed) {
            System.out.print(c + " ");
        }
        System.out.println("  (" + missed.size() + " / " + MAX_MISSES + " misses)");
    }
}
