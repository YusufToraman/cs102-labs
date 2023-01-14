package Sort;

import java.util.Random;

public class Quicksort {
    public static void main(String[] args) {
        int[] arr = {19, 12, 25, 31, 3, 4, 6, 9, 100, 84, 103};
        quicksort(arr, 0, arr.length - 1);
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i] + " ");
        }
    }
    
      private static void quicksort(int[] array, int lowIndex, int highIndex) {
    
        if (lowIndex >= highIndex) {
          return;
        }
        
        int pivot = array[lowIndex];
        swap(array, lowIndex, highIndex);
    
        int leftPointer = partition(array, lowIndex, highIndex, pivot);
    
        quicksort(array, lowIndex, leftPointer - 1);
        quicksort(array, leftPointer + 1, highIndex);
    
      }
    
      private static int partition(int[] array, int lowIndex, int highIndex, int pivot) {
        int leftPointer = lowIndex;
        int rightPointer = highIndex - 1;
    
        while (leftPointer < rightPointer) {
    
          // Walk from the left until we find a number greater than the pivot, or hit the right pointer.
          while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
            leftPointer++;
          }
    
          // Walk from the right until we find a number less than the pivot, or hit the left pointer.
          while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
            rightPointer--;
          }
    
          swap(array, leftPointer, rightPointer);
        }
        
        // This is different from what the video has, and fixes an issue where the last value could potentially be out of order. 
        // Thanks to viewer Wilson Barbosa for suggesting the fix!
        if(array[leftPointer] > array[highIndex]) {
          swap(array, leftPointer, highIndex);
        }
        else {
          leftPointer = highIndex;
        }
        
        return leftPointer;
      }
    
      private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
      }
}
