package o9_sort.merge;

import java.util.Arrays;

public class MergeSort {

    public static int[] merge(int [] array1, int[] array2){         //both arrays have to be sorted
        int [] combined = new int [array1.length + array2.length];
        int index = 0;                                              //index of combined array
        int i = 0;                                                  //index of first array
        int j = 0;                                                  //index of second array

        while (i < array1.length && j < array2.length){
            if (array1[i] < array2[j]){
                combined[index] = array1[i];
                i++;
            } else {
                combined[index] = array2[j];
                j++;
            }
            index++;
        }

        while (i < array1.length){
            combined[index] = array1[i];
            index++;
            i++;
        }

        while (j < array2.length){
            combined[index] = array2[j];
            index++;
            j++;
        }

    return combined;
    }

    public static int[] mergeSort(int[] array){
        if (array.length == 1) return array;

        int midIndex = array.length/2;
        int [] left = mergeSort(Arrays.copyOfRange(array, 0, midIndex));
        int [] right = mergeSort(Arrays.copyOfRange(array, midIndex, array.length));

        return merge(left, right);
    }

    public static void main(String[] args) {

        int[] originalArray = {3,4,1,2};

        int[] sortedArray = mergeSort(originalArray);

        System.out.println("\nOriginal array: " + Arrays.toString(originalArray));
        System.out.println("\nSorted array: " + Arrays.toString(sortedArray));

    }

}
