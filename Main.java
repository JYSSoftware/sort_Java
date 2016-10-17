/**
 * Created by jinyongsuk on 10/16/16.
 */
public class Main {

    public static void main(String [] argv){
        MergeSort m1 = new MergeSort();
        QuickSort q1 = new QuickSort();

        int[] test = {45,23,11,89,77,98,4,28,65,43};


        int [] mResult = m1.mergeSort(test);

        System.out.println("Merge Sort");
        print(mResult);

        int [] qResult = q1.quickSort(test);

        System.out.println("Quick Sort");
        print(qResult);

    }

    /*
  * print
  * description : print all element
  * @param: int[] array - array to be printed
  * */
    public static void print(int[] array){
        for (int item : array){
            System.out.println( "["+ item + "]");
        }
    }

}
