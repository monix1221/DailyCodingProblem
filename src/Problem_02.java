public class Problem_02 {

    /**
     * Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.
     *
     * For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].
     *
     * Follow-up: what if you can't use division?
     * @param args
     */
    public static void main(String[] args) {

        int[] num1 = null;
        int[] num2 = new int[0];
        int[] num3 = new int[2];
        int[] num4 = {1, 2, 3, 4, 5};
        int[] num5 = new int[]{3, 2, 1};
        int[] num6 = new int[]{4, 5, 6, 7, 0, 3, 2, 1, 4, 5, 6};
        int[] num7 = new int[]{4, 5, 6, 7, 0, 3, 2, 0, 4, 5, 6};

        System.out.println("\n1)\t int[] num1 = null;");
        printArr(getProduct(num1));
        System.out.println("\n2)\t int[] num2 = new int[0];");
        printArr(getProduct(num2));
        System.out.println("\n3)\t int[] num3 = new int[2];");
        printArr(getProduct(num3));
        System.out.println("\n4)\t int[] num4 = {1, 2, 3, 4, 5};");
        printArr(getProduct(num4));
        System.out.println("\n5)\t int[] num5 = new int[]{3, 2, 1};");
        printArr(getProduct(num5));
        System.out.println("\n5)\t int[] num6 = new int[]{4, 5, 6, 7, 0, 3, 2, 1, 4, 5, 6};");
        printArr(getProduct(num6));
        System.out.println("\n5)\t int[] num7 = new int[]{4, 5, 6, 7, 0, 3, 2, 0, 4, 5, 6};");
        printArr(getProduct(num7));

    }

    //Solution 1
    static int[] getProduct(int[] arr) {
        if (arr == null || arr.length == 0)
            return null;
        printArr(arr);
        System.out.println();
        //lets count product
        //if contains one 0, then dont count it and return array with zeros and product for index with 0
        //if contains more then one zero, then return empty array
        int product = 1;
        int firstZeroIndex = -1;
        boolean moreThanOneZero = false;

        for (int i = 0; i < arr.length; i++) {
            if (moreThanOneZero)
                break;

            if (arr[i] == 0 && firstZeroIndex == -1) {
                firstZeroIndex = i;
                continue;
            } else if (arr[i] == 0 && firstZeroIndex != -1) {
                moreThanOneZero = true;
            }

            product *= arr[i];
        }

        int[] prodArr = new int[arr.length];
        if (moreThanOneZero)
            return prodArr;

        if (firstZeroIndex != -1) {
            prodArr[firstZeroIndex] = product;
            return prodArr;
        }

        for (int i = 0; i < prodArr.length; i++) {
            prodArr[i] = product / arr[i];
        }
        return prodArr;
    }

    //Solution 2 - without division
    static int[] getProduct2(int[] arr) {
        if (arr == null)
            return null;
        int[] sol = new int[arr.length];

        for (int i = 0 ; i < arr.length; i++) {
            int prod = 1;
            for (int j = 0; j < arr.length; j++) {
                if (j != i) {
                    prod *= arr[j];
                }
            }
            sol[i] = prod;
        }
        return sol;
    }

    static void printArr(int[] arr) {
        if (arr == null)
            return;
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
