import java.util.Arrays;
import java.util.Random;

public class Main {
    //creates a random list of integers from 1, 100
    static int[] arr = new Random().ints(50, 1, 100).toArray();

    public static int partition(int low, int high){
        //gets lowest position
        int newFlipIdx = low - 1;
        int pivot = arr[high];

        //interates between low and high, exclusive
        for(int i = low; i < high; i++){
            //checks if the index value is less than pivot
            if(arr[i] < pivot){
                //if it is, swap to left, and go one spot over, on flip index
                newFlipIdx++;
                swap(newFlipIdx, i);
            }
        }
        
        //final swap of pivot
        swap(newFlipIdx + 1, high);
        return newFlipIdx+1;
    }

    //swaps global arr
    public static void swap(int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    
    public static void quickSort(int low, int high){
        //if the bounds are equal or lower exceeds high, it skips
        if(low >= high) return;

        //finds pivot
        int pivot = partition(low, high);

        //runs on left and right halves
        quickSort(low, pivot - 1);
        quickSort(pivot + 1, high);
    
    }
    
    public static void main(String[] args){
        System.out.println(Arrays.toString(arr));
        quickSort(0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}