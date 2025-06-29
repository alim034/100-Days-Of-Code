package Projects;

import java.util.Scanner;

public class Day02_TipCalculator {
    public static void main(String[] args) {
        System.out.println("*** Welcome to Tip Calculator ***");

        Scanner sc = new Scanner(System.in);

        System.out.println("What was the total bill? $");
        double toalBill = sc.nextDouble();

        System.out.println("What percentage tip would you like to give? 10, 12, or 15? ");
        int tipPercent = sc.nextInt();

        System.out.println("How many people to split the bill?");
        int person = sc.nextInt();


        double totalTip = tipPercent/100.0;
        double billWithTip = toalBill*(1+totalTip);

        double billPerPerson = billWithTip / person;

        String finalAmount = String.format("%.2f", billPerPerson);

        System.out.print("Each person should pay: " +finalAmount);
    }
}
