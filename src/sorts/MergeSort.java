package sorts;

import java.util.*;

public class MergeSort {
  public static void main(String[] args) {
    int[] toSort = {5, 2, 44, 23, 1, 6, 32, 8, 10, 15, 41, 22, 25, 13};
    for (int i = 0; i < toSort.length; ++i) {
      System.out.print(toSort[i] + " ");
    }
    System.out.println("");
    int[] result = new int[toSort.length];
    
    // get sorted array
    result = mergeSort(toSort);
    for (int i = 0; i < result.length; ++i) {
      System.out.print(result[i] + " ");
    }
    System.out.println("");
  }
  
  
  /**
   * This function will take an integer array
   * as an argument and will merge the
   * result of halving the array until
   * we are left with n single element arrays,
   * our base case.
   * 
   * The function merge() will do the work
   * of sorting the halves.
   * @param toSort
   * @return
   */
  public static int[] mergeSort(int[] toSort) {
    if (toSort.length == 1) return toSort;
    int mid = toSort.length / 2;
    int[] left = Arrays.copyOfRange(toSort, 0, mid);
    int[] right = Arrays.copyOfRange(toSort, mid, toSort.length);
    return merge(mergeSort(left), mergeSort(right));
  }
  
  /**
   * This function will take two
   * sorted halves of an integer
   * array as arguments and construct
   * an array of size
   * toMergeL.length + toMergeR.length
   * that is sorted by combining
   * the two pre-sorted arrays.
   * @param toMergeL
   * @param toMergeR
   * @return
   */
  public static int[] merge(int[] toMergeL, int[] toMergeR) {
    // initialize array of size toMergeL.length + toMergeR.length
    // as well as index arrays.
    int[] result = new int[toMergeL.length + toMergeR.length];
    int leftIndex = 0, rightIndex = 0, resultIndex = 0;
    while (leftIndex < toMergeL.length && rightIndex < toMergeR.length) {
      // while there are elements to process from both subarrays
      if (toMergeL[leftIndex] <= toMergeR[rightIndex]) {
        // if the current element from the left subarray
        // is less than or equal to the current element
        // from the right subarray, the next element
        // that goes in our resulting merged array
        // is from the left subarray
        result[resultIndex] = toMergeL[leftIndex];
        
        // move indices forward
        ++resultIndex;
        ++leftIndex;
      } else {
        // if the current element from the left subarray
        // is greater than the the current element
        // from the right subarray, the next
        // element that goes in our resulting
        // merged array is from the right subarray
        result[resultIndex] = toMergeR[rightIndex];
        
        // move indices forward
        ++resultIndex;
        ++rightIndex;
      }
    }
    
    // after the above while loop, one of the arrays will not be
    // fully processed, so our program will go in one of the two
    // below if statement blocks to finish pushing the result of the
    // values from one of the two sorted subarrays into our resulting
    // sorted array.
    if (leftIndex < toMergeL.length) {
      while (leftIndex < toMergeL.length) {
        // while there are elements in the leftsubarray
        // to append to our resulting array
        result[resultIndex] = toMergeL[leftIndex];
        
        // move forward indices.
        resultIndex++;
        leftIndex++;
      }
    }
    if (rightIndex < toMergeR.length) {
      while (rightIndex < toMergeR.length) {
        // while there are elements in the rightsubarray
        // to append to our resulting array
        result[resultIndex] = toMergeR[rightIndex];
        
        // move forward indices.
        ++resultIndex;
        ++rightIndex;
      }
    }
    return result;
  }
}
