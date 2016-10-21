/**
 * Created by jinyongsuk on 10/17/16.
 */
public class Heap{

    private int[] heapArray = null;
    private int heapSize = 0;
    private int max = 0;
    private int min = 0;
    private boolean isMinHeap = false;

    private void init(int[] array, boolean isMinHeap){

        this.heapSize = array == null ? 0 : array.length;
        this.isMinHeap = isMinHeap;
    }

    public Heap(){
        init(null, true);
    }

    public Heap(int[] array){
        init(array, true);
    }

    public Heap(int[] array, boolean isMinHeap){
        init(array, isMinHeap);
    }

    private void minHeapify(int current){

        int p = getParentIndex(current);
        int l = getLeftChildrenIndex(current);
        int r = getRightChildrenIndex(current);
        int min = current;

        if (l <= this.heapSize && this.heapArray[current] > this.heapArray[l]){
            min = l;
        }

        if (r <= this.heapSize && this.heapArray[current] > this.heapArray[r]){

            if (this.heapArray[l] > this.heapArray[r])
                min = r;
        }

        if (min != current){
            swap(min, current);
        }

        if (current == p) return;

        if (l <= this.heapSize || r <= this.heapSize)
            minHeapify(p);

    }

    private void maxHeapify(int current){

        int p = getParentIndex(current);
        int l = getLeftChildrenIndex(current);
        int r = getRightChildrenIndex(current);
        int max = current;

        if (l <= this.heapSize && this.heapArray[current] < this.heapArray[l]){
            max = l;
        }

        if (r <= this.heapSize && this.heapArray[current] < this.heapArray[r]){
            if (this.heapArray[l] < this.heapArray[r])
               max = r;
        }

        if (max != current)
            swap(max, current);

        if (current == p) return;

        if (l <= this.heapSize || r <= this.heapSize)
            maxHeapify(p);

    }

    public int[] buildHeap(int [] array, boolean isMin){

        this.heapSize = array.length;
        this.isMinHeap = isMin;
        increaseSize(array);
        int index = this.heapSize/2;

        if (isMin) {
            while (index >= 1) {
                minHeapify(index);
                index--;
            }
            this.min = this.heapArray[1];

        }
        else {
            while (index >= 1) {
                maxHeapify(index);
                index--;
            }
            this.max = this.heapArray[1];
        }

        return this.heapArray;
    }

    private void swap(int current, int dest){
        int tmp = this.heapArray[dest];
        this.heapArray[dest] = this.heapArray[current];
        this.heapArray[current] = tmp;
    }

    private void increaseSize(int[] array){
        this.heapArray = new int[array.length + 1];
        for (int i = 0; i < array.length; i++){
            this.heapArray[i+1] = array[i];
        }
    }

    public boolean isMinHeap(){ return this.isMinHeap; }

    public int getMax(){return this.max;}
    public int getMin(){return this.min;}

    public  int[] getHeapArray(){ return( this.heapArray == null? null : this.heapArray ); }

    private int getParentIndex(int index){ return ( (index <= 1)? 1 : index / 2);}

    private int getLeftChildrenIndex(int index){return index * 2;}

    private int getRightChildrenIndex(int index){return index * 2 + 1;}

}
