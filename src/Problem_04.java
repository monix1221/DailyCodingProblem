import java.util.HashSet;
import java.util.Set;

public class Problem_04 {

    /**
     * Given an array of integers, find the first missing positive integer in linear time and constant space.
     * In other words, find the lowest positive integer that does not exist in the array.
     * The array can contain duplicates and negative numbers as well.
     *
     * For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
     *
     * You can modify the input array in-place.
     * @param args
     */
    public static void main(String[] args) {

        int[] input1 = null;
        int[] input2 = new int[0];
        int[] input3 = new int[2];
        int[] input4 = new int[]{3, 4, -1, -1};
        int[] input5 = new int[]{1, 2, 0};

        System.out.println("input 1: " + getMissingValue(input1));
        System.out.println("input 2: " + getMissingValue(input2));
        System.out.println("input 3: " + getMissingValue(input3));
        System.out.println("input 4: " + getMissingValue(input4));
        System.out.println("input 5: " + getMissingValue(input5));

    }

    static int getMissingValue(int[] arr) {
        if (arr == null || arr.length == 0)
            return -1;

        if (arr.length == 1) {
            if (arr[0] <= 0)
                return 1;
            else
                return arr[0] + 1;
        }

        int minPositive = arr[0];
        int maxPositive = arr[0];
        boolean isNegativeNumberPresent = false;

        Set<Integer> values = new HashSet<>();

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] <= 0)
                isNegativeNumberPresent = true;

            if (minPositive <= 0 && arr[i] > 0) {
                minPositive = arr[i];
            }

            if (minPositive > 0 && arr[i] > 0 && arr[i] < minPositive) {
                minPositive = arr[i];
            }


            if (maxPositive <= 0 && arr[i] > 0) {
                maxPositive = arr[i];
            }

            if (maxPositive > 0 && arr[i] > 0 && arr[i] > maxPositive) {
                maxPositive = arr[i];
            }

            System.out.println("max = " + maxPositive + ", min = " + minPositive);

            values.add(arr[i]);
        }

        int start = isNegativeNumberPresent? 1 : minPositive;
        for (int i = start + 1; i <= maxPositive; i++) {
            if (!values.contains(i)) {
                return i;
            }
        }

        return maxPositive + 1;
    }

}
