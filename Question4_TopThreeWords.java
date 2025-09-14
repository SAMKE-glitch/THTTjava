import java.util.*;

/**
 * Utility class to find the three most common words in a sentence.
 */
public class Question4_TopThreeWords {

    /**
     * Returns the three most common words in a sentence, sorted alphabetically if frequencies are equal.
     *
     * <p>Steps:
     * <ol>
     *   <li>Split the sentence into words</li>
     *   <li>Count frequencies using a HashMap</li>
     *   <li>Sort words by frequency descending, then alphabetically ascending if frequency is the same</li>
     *   <li>Take the top 3 words</li>
     * </ol>
     * </p>
     *
     * @param sentence the input sentence
     * @return list of top three most frequent words
     */
    public static List<String> topThreeWords(String sentence) {
        // Step 1: Split the sentence into words
        String[] words = sentence.split("\\s+");

        // Step 2: Count frequencies using a HashMap
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        // Step 3: Sort items by frequency descending, then alphabetically ascending
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(freqMap.entrySet());
        entryList.sort((a, b) -> {
            int freqCompare = b.getValue().compareTo(a.getValue()); // frequency descending
            if (freqCompare != 0) {
                return freqCompare;
            }
            return a.getKey().compareTo(b.getKey()); // alphabetically ascending
        });

        // Step 4: Take the top 3 words
        List<String> top3 = new ArrayList<>();
        for (int i = 0; i < Math.min(3, entryList.size()); i++) {
            top3.add(entryList.get(i).getKey());
        }

        return top3;
    }

    /**
     * (Main Entry Method) Driver method to test the topThreeWords function.
     */
    public static void main(String[] args) {
        String sentence = "hi there care to discuss algorithm basis or how to solve algorithm or";
        List<String> result = topThreeWords(sentence);
        System.out.println(result);  // Expected: [algorithm, or, to]

        // Additional test case
        String sentence2 = "apple banana apple orange banana banana";
        System.out.println(topThreeWords(sentence2));  // Expected: [banana, apple, orange]
    }
}
