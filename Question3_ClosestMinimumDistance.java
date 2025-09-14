public class Question3_ClosestMinimumDistance {

    /**
     * Finds the distance between the two closest minimum values in the array.
     *
     * @param arr the input array of integers
     * @return the smallest distance between two occurrences of the minimum
     */
    public static int closestMinDistance(int[] arr) {
        // Step 1: Find the minimum value
        int minVal = Integer.MAX_VALUE;
        for (int num : arr) {
            if (num < minVal) {
                minVal = num;
            }
        }

        // Step 2: Traverse again to find closest indices
        int prevIndex = -1;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == minVal) {
                if (prevIndex != -1) {
                    minDistance = Math.min(minDistance, i - prevIndex);
                }
                prevIndex = i;
            }
        }

        return minDistance;
    }

    // Test cases
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 1, 4, 5, 2};
        System.out.println("Expected: 3 | Got: " + closestMinDistance(arr1));

        int[] arr2 = {5, 6, 2, 7, 2, 9};
        System.out.println("Expected: 2 | Got: " + closestMinDistance(arr2));

        int[] arr3 = {10, 1, 3, 1, 7, 1};
        System.out.println("Expected: 2 | Got: " + closestMinDistance(arr3));

        int[] arr4 = {2, 2, 2, 2};
        System.out.println("Expected: 1 | Got: " + closestMinDistance(arr4));
    }
}
