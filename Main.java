/**
 * Created by jinyongsuk on 10/16/16.
 */
public class Main {

    public static void main(String [] argv){
        MergeSort m1 = new MergeSort();
        QuickSort q1 = new QuickSort();

        int[] test = {45,23,11,89,77,98,4,28,65,43};


        Heap h1 = new Heap();
        h1.buildHeap(test, false);
        System.out.println("max Heap");
        print(h1.getHeapArray());

        Heap h2 = new Heap();
        h2.buildHeap(test, true);
        System.out.println("min Heap");
        print(h2.getHeapArray());


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
