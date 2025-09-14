import java.util.*;

/**
 * Utility class to find the longest valid string from a given list of strings,
 * based on allowed characters and non-repetitive consecutive characters.
 */
public class GetLongestString {

    /**
     * A set of valid characters allowed in the string.
     * Declared at class level so it can be reused by helper methods.
     */
    private static Set<Character> validSet;

    /**
     * Checks whether a given string is valid.
     * A valid string must:
     * <ul>
     *   <li>Contain only characters from {@code validSet}</li>
     *   <li>Not have two consecutive identical characters</li>
     * </ul>
     *
     * @param s the string to validate
     * @return true if the string is valid, false otherwise
     */
    private static boolean isValid(String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Check 1: character must be in the allowed set
            if (!validSet.contains(ch)) {
                return false;
            }

            // Check 2: no two consecutive characters can be the same
            if (i > 0 && ch == s.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Finds the longest valid string from the provided array of strings.
     * A valid string is defined by the {@link #isValid(String)} method.
     *
     * @param characters the list of valid characters
     * @param strings    the array of candidate strings
     * @return the longest valid string, or null if none are valid
     */
    public static String getLongestString(List<Character> characters, String[] strings) {
        validSet = new HashSet<>(characters);
        String longest = null;

        for (String s : strings) {
            if (isValid(s)) {
                if (longest == null || s.length() > longest.length()) {
                    longest = s;
                }
            }
        }
        return longest;
    }

    /**
     * Driver method to test the functionality.
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        List<Character> characters = Arrays.asList('A', 'B', 'C', 'D');
        String[] strings = {"AABCDA", "ABCDZADC", "ABCDBCA", "ABCDABDCA"};

        String result = getLongestString(characters, strings);
        System.out.println(result);  // Expected output: "ABCDABDCA"
    }
}
