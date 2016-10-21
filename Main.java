/**
 * Created by jinyongsuk on 10/16/16.
 */
public class Main {

    public static void main(String [] args){
        //MergeSort m1 = new MergeSort();
        //QuickSort q1 = new QuickSort();

        int[] test = {45,23,11,89,77,98,4,28,65,43};


        /*
        Heap h1 = new Heap();
        h1.buildHeap(test, false);
        System.out.println("max Heap");
        print(h1.getHeapArray());

        Heap h2 = new Heap();
        h2.buildHeap(test, true);
        System.out.println("min Heap");
        print(h2.getHeapArray());
        */

        Queue<Integer> q1 = new Queue<>();
        for (int x : test){
            q1.push(x);
        }

        q1.print();

        for (int i = 0; i < test.length; i++){
            System.out.println( "popped : "+q1.dequeue());
        }

        q1.print();

        /*
        LinkedList<Integer> l1 = new LinkedList<Integer>();
        for (int x : test){
            l1.insert(new Node<Integer>(x));
        }
        l1.print();

        l1.remove(11);
        l1.print();

        */
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

    public static boolean isPrime(int n){

        for (int i = 2; i < n/2; i++){
            System.out.println(i);
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }

}
