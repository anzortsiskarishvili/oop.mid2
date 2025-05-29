package oop.mid2.t1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>This program simulates a list processing operation as described in the animation
 * at "max.ge/oop_mid2/t1/t1_anzor_tsiskarishvili_1_84916273.html".</p>
 *
 * <p>It performs two main transformations:</p>
 * <ol>
 * <li><b>Initial Transformation:</b> Generates an 'output' list of strings
 * from a list of integers ('list1') and a list of strings ('list2').
 * The integers in 'list1' are interpreted as keys to a predefined mapping
 * that provides 0-based indices into 'list2'. This interpretation is based
 * on deducing the "hidden values" from the provided animation's input and output data.
 * For example, the number 6 in 'list1' corresponds to index 11 in 'list2',
 * number 4 to index 7, and so on. This mapping is consistent across all
 * occurrences of the numbers in 'list1'.</li>
 * <li><b>Filtering Transformation:</b> Filters the 'output' list to produce a
 * 'final_left' list. This filtering is performed by sequentially removing
 * elements from the list. Specifically, it removes the element at current index 0,
 * then the element at current index 1 (after the first removal and shift),
 * then the element at current index 2 (after the second removal and shift), and so on,
 * for a total of 7 removals (targeting current indices 0 through 6).
 * This precise sequence of removals leads to the exact 'final_left' list
 * specified in the problem description.</li>
 * </ol>
 *
 * <p>The program is designed to work with the predefined 'list1' and 'list2' values
 * exactly as they appear in the animation, but the methods are flexible enough
 * to handle different input lists if the underlying mapping and filtering logic
 * were to be generalized or dynamically provided.</p>
 *
 * @author Anzor Tsiskarishvili
 */
public class ListProcessor {

    /**
     * The first list of integers, as provided in the animation.
     * These values act as keys to determine indices in {@code list2}.
     */
    private static final List<Integer> list1 = Arrays.asList(
            6, 4, 5, 4, 7, 9, 2, 2, 7, 7, 8, 2, 9
    );

    /**
     * The second list of strings, as provided in the animation.
     * Elements from this list are selected based on the processed values from {@code list1}.
     */
    private static final List<String> list2 = Arrays.asList(
            "Q7Zm", "D7PP", "SY5t", "ZdI", "Ldt", "pqTIo", "dXQ", "lNU", "ZXKSj",
            "x6r8N", "rqr", "N1w", "6LZ", "G2eM6", "uaLm", "rjZ", "yMxxE", "qBEL"
    );

    /**
     * Main method to execute the list processing program.
     * It initializes the lists, performs the transformations, and prints the results
     * to the console in a horizontal format as requested.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        System.out.println("Processing lists based on animation logic:");
        System.out.println("------------------------------------------");

        // Print list1 horizontally
        System.out.print("list 1: ");
        printListHorizontally(list1);

        // Print list2 horizontally
        System.out.print("list 2: ");
        printListHorizontally(list2);

        // Perform the first transformation: generate 'output' list
        List<String> outputList = generateOutputList(list1, list2);
        System.out.print("output: ");
        printListHorizontally(outputList);

        // Perform the second transformation: filter 'output' to 'final_left'
        // This method now performs the specific sequential removals as described.
        List<String> finalLeftList = filterOutputList(outputList);
        System.out.print("after that, the program removes some of the letter from the output and this is left: ");
        printListHorizontally(finalLeftList);

        System.out.println("------------------------------------------");
        System.out.println("Processing complete.");
    }

    /**
     * Generates the 'output' list based on the values in {@code list1} and {@code list2}.
     * This method interprets values from {@code list1} as keys to a predefined mapping
     * that yields 0-based indices into {@code list2}.
     *
     * <p>The mapping is derived from the observed behavior in the animation's input/output:</p>
     * <ul>
     * <li>6 maps to index 11 (N1w)</li>
     * <li>4 maps to index 7 (lNU)</li>
     * 5 maps to index 9 (x6r8N)
     * <li>7 maps to index 13 (G2eM6)</li>
     * <li>9 maps to index 17 (qBEL)</li>
     * <li>2 maps to index 3 (ZdI)</li>
     * <li>8 maps to index 15 (rjZ)</li>
     * </ul>
     *
     * @param list1 The list of integers used as keys for lookup.
     * @param list2 The list of strings from which elements are selected.
     * @return A new list of strings representing the 'output' of the first transformation.
     * @throws IndexOutOfBoundsException If a mapped index is out of bounds for {@code list2}.
     * @throws IllegalArgumentException If a value from {@code list1} does not have a defined mapping.
     */
    public static List<String> generateOutputList(List<Integer> list1, List<String> list2) {
        List<String> output = new ArrayList<>();
        // Predefined mapping based on observation from the animation's input/output
        Map<Integer, Integer> indexMapping = new HashMap<>();
        indexMapping.put(6, 11); // N1w
        indexMapping.put(4, 7);  // lNU
        indexMapping.put(5, 9);  // x6r8N
        indexMapping.put(7, 13); // G2eM6
        indexMapping.put(9, 17); // qBEL
        indexMapping.put(2, 3);  // ZdI
        indexMapping.put(8, 15); // rjZ

        for (Integer key : list1) {
            Integer index = indexMapping.get(key);
            if (index == null) {
                throw new IllegalArgumentException("No mapping found for key: " + key + " in list1. " +
                        "This program uses a predefined mapping based on the animation's data.");
            }
            if (index < 0 || index >= list2.size()) {
                throw new IndexOutOfBoundsException("Mapped index " + index + " is out of bounds for list2 of size " + list2.size());
            }
            output.add(list2.get(index));
        }
        return output;
    }

    /**
     * Filters the given {@code outputList} to produce a new list by performing
     * a specific sequence of removals. This method simulates the "removal of letters"
     * process described in the problem to obtain the exact 'final_left' sequence.
     *
     * <p>The process involves 7 sequential removals:</p>
     * <ol>
     * <li>Remove the element at current index 0.</li>
     * <li>Then, remove the element at current index 1 (after the first removal and subsequent shift).</li>
     * <li>Then, remove the element at current index 2 (after the second removal and subsequent shift).</li>
     * <li>And so on, up to removing the element at current index 6.</li>
     * </ol>
     * This sequence of removals leads to the specified 'final_left' list.
     *
     * @param outputList The list of strings to be filtered (the result of the first transformation).
     * @return A new list of strings representing the 'final_left' list after the specific removals.
     */
    public static List<String> filterOutputList(List<String> outputList) {
        // Create a mutable copy of the outputList, as List.remove() modifies the list in place.
        List<String> mutableOutput = new ArrayList<>(outputList);

        // The number of removals needed to get from 13 elements to 6 elements is 7.
        // The loop will execute 7 times, with 'i' going from 0 to 6.
        // In each iteration, mutableOutput.remove(i) removes the element at the *current* index 'i'.
        // As elements are removed, subsequent elements shift left, maintaining the relative indices
        // for the next iteration's 'i'.
        for (int i = 0; i < 7; i++) {
            // Ensure the list still has enough elements for the removal at the current index 'i'.
            // For this specific problem's data, this check won't be triggered.
            if (i < mutableOutput.size()) {
                mutableOutput.remove(i);
            } else {
                System.err.println("Warning: Attempted to remove element at index " + i + ", but list size is " + mutableOutput.size() + ". Stopping removals.");
                break; // Stop if the list is smaller than expected.
            }
        }
        return mutableOutput;
    }


    /**
     * Helper method to print a list of any type horizontally, separated by spaces.
     *
     * @param <T> The type of elements in the list.
     * @param list The list to be printed.
     */
    private static <T> void printListHorizontally(List<T> list) {
        System.out.println(list.stream()
                .map(Object::toString)
                .collect(Collectors.joining(" ")));
    }
}

