package Projects;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day09_FindHighestBidder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> bids = new HashMap<>();

        System.out.println("Welcome to the secret auction program.");

        boolean moreBidders = true;
        while (moreBidders) {
            System.out.print("What is your name? ");
            String name = scanner.nextLine();

            System.out.print("What's your bid? ");
            int amount = Integer.parseInt(scanner.nextLine());
            bids.put(name, amount);

            System.out.print("Are there any other bidders? Type 'yes' or 'no': ");
            String response = scanner.nextLine().toLowerCase();
            if (response.equals("no")) {
                moreBidders = false;
            }
            // Optionally clear screen here if desired
        }

        // Determine highest bid
        String highestBidder = null;
        int highestBid = -1;
        for (Map.Entry<String, Integer> entry : bids.entrySet()) {
            if (entry.getValue() > highestBid) {
                highestBid = entry.getValue();
                highestBidder = entry.getKey();
            }
        }

        System.out.println("\nCongratulations " + highestBidder + "! Your bid of $" + highestBid + " wins!");
        scanner.close();
    }
}
