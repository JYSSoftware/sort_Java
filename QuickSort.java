
/**
 * Created by jinyongsuk on 10/15/16.
 */
public class QuickSort extends Main {


    /*
    * quickSort
    * description: calling overloaded function quickSort(int[], int, int)
    * @param : int[] array - array to be sorted
    *           boolean isAscending - ascending or descending (default descending
    * @return : none
    * */
    public int[] quickSort( int[] array, boolean isAscending){
        return(this.quickSort(array, 0, array.length - 1, isAscending));
    }

    /*
    * quickSort
    * description: overloaded function quickSort(int[]) recursive function
    *               that sorting elements.
    * @param : int [] array - array to be sorted
    *           int low - lowest index position to be looked up
    *           int high - highest index position to be looked up
    *           boolean isAscending - ascending or descending (default descending)
    * */
    private int[] quickSort( int[] array, int low, int high, boolean isAscending){

        int partitionIndex = particiton(array, low, high, isAscending);

        if (low < partitionIndex - 1) { //sort left half
            quickSort(array, low, partitionIndex - 1, isAscending);
        }

        if (partitionIndex < high){ //sort right half
            quickSort(array, partitionIndex, high, isAscending);
        }
        return array;
    }

    /*
    * particition in ascending order (if wants descending change pivot check to opposite)
    * description: split array into 2 pieces
    * @param : int[] array : array to be sorted,
    *           int low - lowest index position to be looked up
    *           int high - highest index position to be looked up
    *           bool isAscending - check if ascending or descending (default descending)
     *
    * @return : return starting index of 2nd partition
    * */
    private int particiton(int[] array, int low, int high, boolean isAscending){

        int pivot = array[( low + high ) / 2]; //Pick pivot point
        int left = low, right = high;

        //run loop while left index is less than right index
        while(left <= right){

            if (isAscending) {
                while (pivot < array[left]) left++; //find left index
                while (pivot > array[right]) right--; //find right index
            }else{
                while (pivot > array[left]) left++; //find left index
                while (pivot < array[right]) right--; //find right index
            }

            //if there exist elements to be swap, then swap with right partition index
            if (left<=right){
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;
                left++;
                right--;
            }
            //else there is nothing to be swap
        }

        //return left index which is partitioned position.
        return left;
    }
}
