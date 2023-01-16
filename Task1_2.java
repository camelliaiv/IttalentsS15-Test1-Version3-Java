import java.util.Scanner;

public class Task1_2 {
    public static void main(String[] args) {

        int tries = 0;
        int pairs = 0;
        int angles = 0;

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Throw a dices: ");
            String text = sc.nextLine();
            String[] dices = text.split(" ");
            if (!validateDices(dices)) {
                continue;
            }
            tries++;

            int numberOfShapes = findNumber(dices[0]);
            int numberOfAngles = findNumber(dices[1]);
            angles += numberOfAngles;

            if (numberOfAngles == numberOfShapes) {
                pairs++;
            } else {
                pairs = 0;
            }

            if (pairs == 3) {
                System.out.println("Total throws: " + tries + "\n" + "The total number of angles: " + angles);
                break;
            }
        }
    }

    private static int findNumber(String dice) {
        switch (dice.toLowerCase()) {
            case "triangle":
            case "three":
                return 3;
            case "square":
            case "four":
                return 4;
            case "pentagon":
            case "five":
                return 5;
            case "hexagon":
            case "six":
                return 6;
            default:
                return -1;
        }
    }

    private static boolean validateDices(String[] dices) {
        if (dices.length != 2) {
            return false;
        }
        if (!validateAngleDice(dices[0])) {
            return false;
        }
        if (!validateShapeDice(dices[1])) {
            return false;
        }
        return true;
    }

    private static boolean validateShapeDice(String dice) {
        switch (dice.toLowerCase()) {
            case "triangle":
            case "square":
            case "pentagon":
            case "hexagon":
                return true;
            default:
                return false;
        }
    }

    private static boolean validateAngleDice(String dice) {
        switch (dice.toLowerCase()) {
            case "three":
            case "four":
            case "five":
            case "six":
                return true;
            default:
                return false;
        }
    }

}
