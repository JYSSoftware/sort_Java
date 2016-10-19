import com.sun.scenario.effect.Merge;

/**
 * Created by jinyongsuk on 10/14/16.
 */
public class MergeSort {

    private int[] helperArray;

    public MergeSort() {
        this.helperArray= null;
    }


    /*
    * mergeSort
    * description: take integer array from user and call overloaded function mergeSort(int[], int, int)
    * @param : int[] array - array to be sorted
    * @return : a sorted array
    * */
    public  int[] mergeSort(int [] array){

        this.helperArray = new int[array.length];
        this.mergeSort(array, 0, array.length -1);


        return array;
    }

    /*
    * mergeSort
    * description: cut down the array size half recursively. and call merge function
    *               to sort array.
    * @param: int[] array - array to be sorted
    *           int low - leftmost index of array, recursively changes to proper mini
    *                       size array's left index
    *           int high - rightmost index of array, recursively changes to proper mini
    *                       size array's right index
    * @return : return sorted array
    * */
    private int[] mergeSort(int [] array, int low, int high){
        int mid = (low + high) / 2;
        if (low < high) {
            mergeSort(array, low, mid);
            mergeSort(array, mid + 1, high);
            merge(array, low, high, mid);
        }

        return array;
    }

    /*
    * merge
    * description: after cut down the array size to each element, keep comparing to left/right side of element
    *               and merge it into sorted order and return the sorted array.
    * @param: int[] array - to be sorted
    *           int low - lowest index of array
    *           int high - highest index of array
    *           int mid - mid index of low and high
    * @return return merged & sorted array
    * */
    public void merge(int [] array, int low, int high, int mid) {

        for (int i = low;  i <= high ; i++){
            this.helperArray[i] = array[i];
        }
        int left = low, right = mid + 1, current = low;
        int temp;
        while (left <=  mid && right <= high){
            temp = array[current];

            if (this.helperArray[left] <= this.helperArray[right]){
                array[current] = this.helperArray[left];
                left++;
            }
            else{

                array[current] = this.helperArray[right];
                right++;
            }
            current++;
        }
        for (int i = 0; i <= mid - left; i++){
            array[current + i] = this.helperArray[left + i];
        }
    }

}
