package pgdp.threads;

import java.util.concurrent.RecursiveAction;

public class BetterParallelMergeSort extends RecursiveAction {

    // Create an attribute for saving the original array
    private Comparable[] mainArray;
    // Attributes for saving starting and ending indexes of the part of the array to sort
    int left, right;

    // First constructor which will be called only once
    public BetterParallelMergeSort(Comparable[] array) {
        // Call another constructor with indexes as arguments for recursion
        this(array, 0, array.length - 1);
    }

    // Use the second constructor for the recursive calls
    public BetterParallelMergeSort(Comparable[] array, int left, int right) {
        // Change the attribute values to the ones provided in the arguments
        this.mainArray = array;
        this.left = left;
        this.right = right;
    }

    @Override
    protected void compute() {
        // Calculate the length of the current array
        int length = right - left;
        // If the current array length is equal or more than 12500 it should be split again
        // Array size can be 100000 divided by powers of 2 (50000, 25000, 12500, 6250, 3125...)
        // 25000, 12500 and 6250 almost give identical results, so I'll stick with the middle one
        if (length >= 12500) {
            // Store the middle index for the array
            int middle = (right + left) / 2;
            // Call ParallelMergeSort again for these two arrays
            invokeAll(new BetterParallelMergeSort(mainArray, left, middle), new BetterParallelMergeSort(mainArray, middle + 1, right));
            MergeSort.merge(mainArray, new Comparable[mainArray.length], left, middle, right);
        }
        else {
            // After the splitting is done merge both arrays into one
            MergeSort.mergesort(mainArray, new Comparable[mainArray.length], left, right);
        }
    }

}
