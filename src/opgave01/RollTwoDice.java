package opgave01;

import java.util.Scanner;

public class RollTwoDice {
    private static int rollCount = 0;
    private static int totalSum = 0;
    private static int pairs = 0;
    private static int highestNumber = 0;
    private static int[] faceCounts = new int[6];

    public static void main(String[] args) {
        System.out.println("Velkommen til spillet, rul en terning.");
        printRules();
        System.out.println();

        playTwoDice();

        System.out.println();
        System.out.println("Tak for at spille, rul en terning.");
    }

    private static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Regler for rul en terning");
        System.out.println("Spilleren ruller en terning, så længde man lyster.");
        System.out.println("=====================================================");
    }

    private static int playTwoDice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Rul to terninger? ('ja/nej') ");
        String answer = scanner.nextLine();
        while (!answer.equals("nej")) {
            int face1 = rollDie();
            int face2 = rollDie();
            int midSum = face1+face2;
            System.out.println("Du rullede: " + face1 + " " + "og" + " " + face2);
            System.out.println();
            System.out.println("sum for dette rul " + midSum);
            //De næste 9 linjer er statistik, kan de rykkes til updateStatistics() metoden?
            totalSum += midSum;
            if (face1 == face2) {
                pairs++;
            }
            if (highestNumber <= midSum){
                highestNumber = midSum;
            }
            faceCounts[face1-1]++;
            faceCounts[face2-1]++;

            updateStatistics();

            System.out.print("Rul en terning? ('ja/nej') ");
            answer = scanner.nextLine();
        }
        printStatistics();
        scanner.close();
        return totalSum;
    }

    public static int rollDie() {
        return (int) (Math.random() * 6 + 1);
    }

    private static void updateStatistics() {
        rollCount++;
    }

    private static void printStatistics() {
        System.out.println("\nResults:");
        System.out.println("-------");
        System.out.printf("%17s %4d\n", "Antal rul:", rollCount);
        System.out.println("din samlede sum for alle rul: " + totalSum);
        System.out.println("antal par rullet i alt: " + pairs);
        System.out.println("højeste rullede antal øjne: " + highestNumber);
        System.out.println("antal gange hver værdi forekommer:");
        for (int i = 0; i < faceCounts.length; i++) {
            System.out.println((i+1) + "'ere: " + faceCounts[i]);
        }

    }

}
