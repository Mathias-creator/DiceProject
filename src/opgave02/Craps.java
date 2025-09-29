package opgave02;
import java.util.Scanner;
public class Craps {
    private static int rollCount = 0;

    public static void main(String[] args) {
        System.out.println("Velkommen til spillet, rul en terning.");
        printRules();
        System.out.println();

        playCraps();

        System.out.println();
        System.out.println("Tak for at spille, craps.");
    }

    private static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Regler for craps");
        System.out.println("Første kast (come out roll):");
        System.out.println("- 7 eller 11: Vinder med det samme");
        System.out.println("- 2, 3 eller 12: Taber med det samme");
        System.out.println("- 4, 5, 6, 8, 9, 10: Etablerer 'point'");
        System.out.println("Efter point etableres:");
        System.out.println("- Kaster point igen: Vinder");
        System.out.println("- Kaster 7: Taber");
        System.out.println("=====================================================");
    }

    private static void playCraps() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("spil craps (ja/nej)");
        String answer = scanner.nextLine();
        while (!answer.equals("nej")) {
            int face = rollDie();
            int face2 = rollDie();
            int comeOutRoll = face + face2;
            System.out.println("Du rullede: " + comeOutRoll);
            System.out.println();
            if (comeOutRoll == 7 || comeOutRoll == 11) {
                System.out.println("Vinderkast! du har vundet");
            } else if  (comeOutRoll == 2 || comeOutRoll == 3 || comeOutRoll == 12) {
                System.out.println("taberkast! du har tabt");
            } else {
                int point = comeOutRoll;
                System.out.println("point samlet" + point);
                System.out.println("Nu skal du rulle for at score point...");
                boolean won = rollForPoint(point);
            }

            System.out.print("Rul en terning? ('ja/nej') ");
            answer = scanner.nextLine();
        }
        scanner.close();
    }

    public static boolean rollForPoint(int point) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("tryk enter for al rulle terningerne...");
            scanner.nextLine();
            int face = rollDie();
            int face2 = rollDie();
            int roll = face + face2;

            System.out.println("Du rullede: " + face + " og " + face2 + " = " + roll );

            if (roll == point) {
                return true;
            } else if (roll == 7){
                return false;
            } else {
                System.out.println("Rullede " + roll + " Fortsætter...");
            }
        }
    }
    private static int rollDie() {
        return (int) (Math.random() * 6 + 1);
    }


}

