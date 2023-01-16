public class Task4_2 {
    public static void main(String[] args) {

        char[][] array = {
                {'X', 'R', 'A', 'S', 'T', 'A', 'T', 'V', 'C', 'R'},
                {'R', 'P', 'A', 'S', 'T', 'A', 'T', 'V', 'C', 'R'},
                {'A', 'L', 'A', 'A', 'E', 'A', 'E', 'Z', 'E', 'R'},
                {'A', 'O', 'A', 'A', 'D', 'O', 'G', 'E', 'A', 'R'},
                {'A', 'T', 'A', 'R', 'A', 'R', 'A', 'L', 'R', 'R'},
                {'T', 'A', 'T', 'T', 'A', 'T', 'V', 'D', 'R', 'J'},
                {'A', 'S', 'O', 'N', 'A', 'T', 'A', 'A', 'R', 'A'},
                {'X', 'R', 'A', 'S', 'T', 'A', 'T', 'V', 'R', 'V'},
                {'A', 'R', 'A', 'R', 'A', 'R', 'A', 'R', 'R', 'A'},
                {'A', 'R', 'A', 'R', 'A', 'R', 'A', 'R', 'R', 'R'}
        };

        String[] words = {"PLOT", "ZELDA", "SONATA", "DOG", "JAVA"};

        boolean result = checkWords(array, words, 0);
        System.out.println((result) ? "All words are contained in the matrix." : "Not all words are contained in the matrix.");
    }

    private static boolean checkWords(char[][] array, String[] words, int index) {
        if (index == words.length) {
            return true;
        }

        boolean hasMatchRow = searchMatchRow(array, words[index]);
        boolean hasMatchCol = searchMatchCol(array, words[index]);

        if (!hasMatchRow && !hasMatchCol) {
            return false;
        }
        return checkWords(array, words, ++index);
    }

    private static boolean searchMatchCol(char[][] array, String word) {
        boolean hasMatch = false;

        int index = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (index == word.length() - 1 && word.charAt(index) != array[j][i]) {
                    hasMatch = false;
                    break;
                }
                if (index == word.length() - 1 && word.charAt(index) == array[j][i]) {
                    break;
                }
                if (word.charAt(index) == array[j][i]) {
                    hasMatch = true;
                    index++;
                }
            }
            if (hasMatch) {
                break;
            }
        }
        return hasMatch;
    }

    private static boolean searchMatchRow(char[][] array, String word) {

        boolean hasMatch = false;

        int index = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (index == word.length() - 1 && word.charAt(index) != array[i][j]) {
                    hasMatch = false;
                    break;
                }
                if (index == word.length() - 1 && word.charAt(index) == array[i][j]) {
                    break;
                }
                if (word.charAt(index) == array[i][j]) {
                    hasMatch = true;
                    index++;
                }
            }
            if (hasMatch) {
                break;
            }
        }
        return hasMatch;
    }
}
