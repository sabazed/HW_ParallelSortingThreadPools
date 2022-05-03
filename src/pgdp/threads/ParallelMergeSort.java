package pgdp.threads;

import java.util.concurrent.RecursiveAction;

public class ParallelMergeSort extends RecursiveAction {

    // Create an attribute for saving the original array
    private Comparable[] mainArray;
    // Attributes for saving starting and ending indexes of the part of the array to sort
    int left, right;

    // First constructor which will be called only once
    public ParallelMergeSort(Comparable[] array) {
        // Call another constructor with indexes as arguments for recursion
        this(array, 0, array.length - 1);
    }

    // Use the second constructor for the recursive calls
    public ParallelMergeSort(Comparable[] array, int left, int right) {
        // Change the attribute values to the ones provided in the arguments
        this.mainArray = array;
        this.left = left;
        this.right = right;
    }

    @Override
    protected void compute() {
        // Calculate the middle point between the arrays where they split
        int middle = (left + right) / 2;
        // Don't split the array if its length is 3 or less
        if (right > left + 2)
        {
            // Invoke both left and right array sorting methods so the threads can process them
            invokeAll(new ParallelMergeSort(mainArray, left, middle), new ParallelMergeSort(mainArray, middle + 1, right));
        }
        // After the splitting is done merge both arrays into one
        MergeSort.merge(mainArray, new Comparable[mainArray.length], left, middle, right);
    }

}
