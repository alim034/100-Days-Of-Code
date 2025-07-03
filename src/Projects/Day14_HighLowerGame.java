package Projects;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Day14_HighLowerGame {

    // class to hold the person data
    static class Person {
        String pName;
        String pDescription;
        String pCountry;
        int pFollowers;

        Person(String pName, String pDescription, String pCountry, int pFollowers) {
            this.pName = pName;
            this.pCountry = pCountry;
            this.pDescription = pDescription;
            this.pFollowers = pFollowers;
        }

        public String toString() {
            return pName + ", " + pDescription + ", " +pCountry;
        }
    }


    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();

        // Creation of the Person
        Person p1 = new Person("Virat Kohli", "Cricketer", "India", 270);
        Person p2 = new Person("MS Dhoni", "Cricketer", "India", 45);
        Person p3 = new Person("Rohit Sharma", "Cricketer", "India", 35);
        Person p4 = new Person("Hardik Pandya", "Cricketer", "India", 28);
        Person p5 = new Person("KL Rahul", "Cricketer", "India", 15);
        Person p6 = new Person("Shubman Gill", "Cricketer", "India", 12);
        Person p7 = new Person("Ravindra Jadeja", "Cricketer", "India", 10);
        Person p8 = new Person("Suryakumar Yadav", "Cricketer", "India", 9);
        Person p9 = new Person("Yuzvendra Chahal", "Cricketer", "India", 8);
        Person p10 = new Person("Jasprit Bumrah", "Cricketer", "India", 7);


        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        list.add(p6);
        list.add(p7);
        list.add(p8);
        list.add(p9);
        list.add(p10);

        // Random and Scanner
        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        // initial score
        int score = 0;
        boolean isPlaying = true;
        // Get First Person
        Person firstPerson = list.get(random.nextInt(list.size()));


        while (isPlaying) {
            // Get Sencond Person
            Person secondPerson;
            do {
                secondPerson = list.get(random.nextInt(list.size()));
            } while (firstPerson==secondPerson);


            System.out.println("Who Has More Followers???");
            System.out.println("A: " + firstPerson);
            System.out.println("B: " + secondPerson);
            System.out.println("Type \"A\" or \"B\" : ");
            String guess = sc.nextLine().toUpperCase();

            boolean isCorrect = false;
            if(guess.equals("A") && firstPerson.pFollowers >= secondPerson.pFollowers) {
                isCorrect = true;
            } else if (guess.equals("B") && secondPerson.pFollowers >= firstPerson.pFollowers){
                isCorrect =true;
            }

            if(isCorrect) {
                score++;
                System.out.println("Correct! Current Score:" + score);
                firstPerson = (guess.equals("A") ? firstPerson : secondPerson);
            } else {
                System.out.println("Wrong! Final Score: " + score);
                isPlaying = false;
            }
        }
    }
}
