import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem_01 {

    /**
     * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
     *
     * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
     *
     * Bonus: Can you do this in one pass?
     */
    public static void main(String[] args) {

        int k = 11;
        int[] numbers1 = null;
        int[] numbers2 = new int[0];
        int[] numbers3 = new int[2];
        int[] numbers4 = {1, 5, 4, 2, 6, 3};

        int[] num5 = {1, 4, 56 , 2, 3, 78, 4, 23, 1, 4, 3, 2, 5, 6, 2, 9 ,12, 9};
        int d = 27;

        //Test solution 1
        System.out.println("false = " + isAddUp(numbers1, k));
        System.out.println("false = " + isAddUp(numbers2, k));
        System.out.println("false = " + isAddUp(numbers3, k));
        System.out.println("true = " + isAddUp(numbers4, k));
        System.out.println("true = " + isAddUp(num5, d));


        //Test solution 2
        System.out.println("false = " + isAddUp2(numbers1, k));
        System.out.println("false = " + isAddUp2(numbers2, k));
        System.out.println("false = " + isAddUp2(numbers3, k));
        System.out.println("true = " + isAddUp2(numbers4, k));
        System.out.println("true = " + isAddUp2(num5, d));

        //Test solution 3
        System.out.println("false = " + isAddUp3(numbers1, k));
        System.out.println("false = " + isAddUp3(numbers2, k));
        System.out.println("false = " + isAddUp3(numbers3, k));
        System.out.println("true = " + isAddUp3(numbers4, k));
        System.out.println("true = " + isAddUp3(num5, d));
    }

    //Solution 3
    //lets store the differences of k and new numbers hat we get from the array
    static Set<Integer> diffs = new HashSet<>();
    static boolean isAddUp3(int[] arr, int k) {
        if (arr == null || arr.length == 0)
            return false;

        //a + b = k;
        //b = k - a;

        //add difference for first element
        int a = arr[0];
        int b1 = k - a;
        diffs.add(b1);

        for(int b = 1; b < arr.length; b++) {
            if (diffs.contains(arr[b]))
                return true;
            else
                diffs.add(k - arr[b]);
        }

        return false;
    }

    //Solution 1
    static boolean isAddUp(int[] arr, int k) {
        if (arr == null)
            return false;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == k)
                    return true;
            }
        }
        return false;
    }

    //Solution 2
    static boolean isAddUp2(int[] arr, int k) {
        if (arr == null)
            return false;

        int[] sortedArray = getSortedArray(arr);
        printArr(sortedArray);

        for (int i = 0; i < sortedArray.length - 1; i++) {
            for (int j = i + 1; j < sortedArray.length; j++) {
                if (sortedArray[i] + sortedArray[j] == k)
                    return true;
                if (sortedArray[i] + sortedArray[j] > k)
                    break;
            }
        }
        return false;

    }

    static int[] getSortedArray(int[] arr) {
        int[] copyArr = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (copyArr[i] < copyArr[j]) {
                    int temp = copyArr[i];
                    copyArr[i] = copyArr[j];
                    copyArr[j] = temp;
                }
            }
        }
        return copyArr;
    }

    static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //System.out.print(arr[i] + " ");
        }
    }
}
