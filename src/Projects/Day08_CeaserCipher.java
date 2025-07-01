package Projects;

import java.util.Scanner;

public class Day08_CeaserCipher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean shouldContinue = true;

        while (shouldContinue) {
            System.out.print("Type 'encode' to encrypt, type 'decode' to decrypt:\n");
            String direction = scanner.nextLine().toLowerCase();

            System.out.print("Type your message:\n");
            String text = scanner.nextLine().toLowerCase();

            System.out.print("Type the shift number:\n");
            int shift = Integer.parseInt(scanner.nextLine());

            caesar(text, shift, direction);

            System.out.print("Type 'yes' if you want to go again. Otherwise, type 'no'.\n");
            String restart = scanner.nextLine().toLowerCase();
            if (restart.equals("no")) {
                shouldContinue = false;
                System.out.println("Goodbye");
            }
        }

        scanner.close();
    }

    public static void caesar(String originalText, int shiftAmount, String encodeOrDecode) {
        StringBuilder outputText = new StringBuilder();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        if (encodeOrDecode.equals("decode")) {
            shiftAmount *= -1;
        }

        for (int i = 0; i < originalText.length(); i++) {
            char letter = originalText.charAt(i);

            if (!Character.isLetter(letter)) {
                outputText.append(letter);
            } else {
                int originalIndex = alphabet.indexOf(letter);
                int shiftedIndex = (originalIndex + shiftAmount) % 26;

                if (shiftedIndex < 0) {
                    shiftedIndex += 26;
                }

                char shiftedChar = alphabet.charAt(shiftedIndex);
                outputText.append(shiftedChar);
            }
        }

        System.out.println("Here is the " + encodeOrDecode + "d result: " + outputText);
    }
}
