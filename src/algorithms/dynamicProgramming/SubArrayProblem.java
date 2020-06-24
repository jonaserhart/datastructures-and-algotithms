package algorithms.dynamicProgramming;

import java.util.Arrays;

public class SubArrayProblem {

    public static void main(String[] args) {
        var arr = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int[] indicesDynamic = subArrayDynamic(arr);
        printSubArrayFromToIndex(arr, indicesDynamic[0], indicesDynamic[1]);
    }

    /**
     * Computes the maximum subarray of an array <code>arr</code>
     * with dynamic programming
     * <br/>
     * <br/>
     * Complexity: O(n)
     * @param arr input array
     * @return an array containing the starting and ending index
     * of the subarray with the maximum sum
     */
    public static int[] subArrayDynamic(int[] arr) {
        int maxSum = 0;
        int maxCurrentSum = 0;
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= maxCurrentSum + arr[i]) {
                maxCurrentSum += arr[i];
            }
            else {
                startIndex = i;
                maxCurrentSum = arr[i];
            }
            if (maxCurrentSum <= maxSum) continue;
            maxSum = maxCurrentSum;
            endIndex = i;
        }
        return new int[]{startIndex, endIndex};
    }

    private static void printSubArrayFromToIndex(int[] arr, int startIndex, int endIndex) {
        int[] result = new int[endIndex - startIndex + 1];
        int resultIndex = 0;
        for (int index = startIndex; index <= endIndex; index++ ) {
            result[resultIndex] = arr[index];
            resultIndex++;
        }
        System.out.println(Arrays.toString(result));
    }

}
