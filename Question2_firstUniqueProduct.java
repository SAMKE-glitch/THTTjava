import java.util.*;

/**
 * Utility class to find the first unique product in an array.
 * A product is considered unique if it appears exactly once in the array.
 */
public class Question2_firstUniqueProduct {

    /**
     * Finds the first product in the array that occurs only once.
     * <ul>
     *   <li>Uses a HashMap to count occurrences of each product.</li>
     *   <li>Scans the array in original order to return the first with count == 1.</li>
     * </ul>
     *
     * @param products array of product names
     * @return the first unique product, or null if none exists
     */
    public static String firstUniqueProduct(String[] products) {
        // Map to store counts of each product
        Map<String, Integer> countMap = new HashMap<>();

        // First pass: build frequency map
        for (String product : products) {
            countMap.put(product, countMap.getOrDefault(product, 0) + 1);
        }

        // Second pass: return the first product with count == 1
        for (String product : products) {
            if (countMap.get(product) == 1) {
                return product;
            }
        }

        // No unique product found
        return null;
    }

    /**
     * Driver Entry method to test the functionality.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        String[] products = {"Apple", "Computer", "Apple", "Bag"};

        String result = firstUniqueProduct(products);
        System.out.println(result);
    }
}
