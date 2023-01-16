import java.util.Scanner;

public class Task2_2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String firstText = sc.nextLine();
        String secondText = sc.nextLine();
        findMissingWord(firstText, secondText);
    }

    private static void findMissingWord(String firstText, String secondText) {
        String[] firstWords = firstText.split(" ");
        checkForPointAndCommas(firstWords);
        compareTheWords(firstWords, 0, secondText, false);
    }

    private static void compareTheWords(String[] firstWords, int index, String secondText, boolean hasMatch) {
        if (index == firstWords.length) {
            if (!hasMatch) {
                System.out.println("No differences found.");
            }
            return;
        }

        if (!(secondText.toLowerCase().contains(firstWords[index].toLowerCase()))) {
            System.out.print((!hasMatch) ? "The word/s is/are: " + firstWords[index] : ", " + firstWords[index]);
            hasMatch = true;
        }

        compareTheWords(firstWords, ++index, secondText, hasMatch);
    }

    private static void checkForPointAndCommas(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].endsWith(".") || words[i].endsWith(",")) {
                words[i] = words[i].substring(0, words[i].length() - 1);
            }
        }
    }

}
