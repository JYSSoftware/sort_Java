/**
 * Created by jinyongsuk on 10/17/16.
 * <my implementation>
 *  	           insert  	  deleteMin  	  remove  	  findMin     findMax
 * binary heap	  O(log n)	   O(log n)	      O(log n)	   O(1)         O(1)
 *
 *
 * <when use Priority Queue with array or linkedList>
 *  	            insert  	  deleteMin  	  remove  	  findMin
 * ordered array	 O(n)	        O(1)	        O(n)	    O(1)
 * ordered list	     O(n)	        O(1)	        O(1)	    O(1)
 * unordered array   O(1)	        O(n)	        O(1)	    O(n)
 * unordered list	 O(1)	        O(n)	        O(1)	    O(n)
 */
public class Heap extends Collection{

    private int[] heapArray;
    private int heapSize;
    private int max;
    private int min;
    private boolean isMinHeap;

    private void init(int[] array, boolean isMinHeap){

        this.heapSize = array == null ? 0 : array.length;
        this.isMinHeap = isMinHeap;
        this.max = 0;
        this.min = 0;
    }

    /*
    *  Heap - default constructor
    *  description: init all property with default setting
    *               default of heap property is minHeap
    *
    * */
    public Heap(){
        init(null, true);
    }

    /*
    *  Heap(int[] array) - copy constructor
    *  description: init all property with default setting
    *               default of heap property is minHeap
    *  @param - int[] array : array to be heap structure
    *
    * */
    public Heap(int[] array){
        init(array, true);
    }

    /*
    *  Heap(int[] array, boolean isMinHeap) - copy constructor
    *  description: init all property with default setting
    *               default of heap property is minHeap
    *  @param - int[] array : array to be heap structure
    *           boolean isMinHeap : take option for Min/Max heap
    *
    * */
    public Heap(int[] array, boolean isMinHeap){
        init(array, isMinHeap);
    }

    @Override
    int size() {
        return this.heapSize;
    }

    @Override
    boolean isEmpty() {
        return this.size() == 0? true : false;
    }

    @Override
    boolean remove(Object element) {

        if (isEmpty()) return false;
        this.heapArray[1] = this.heapArray[this.heapSize];

        buildHeap(this.heapArray, isMinHeap);
        return true;
    }

    public void add(int element){
        if (this.heapArray == null){
            this.heapArray = new int []{element};
            this.heapSize = 1;
            return;
        }

        if (this.heapArray.length == heapSize){
            doubleSize();
        }

        //add at last index
        this.heapArray[++this.heapSize] = element;
        if (this.isMinHeap()) minHeapify(this.heapSize/2);
        else maxHeapify(this.heapSize/2);

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

    private void doubleSize(){
        int[] newArray = new int[2 * this.heapArray.length];
        System.arraycopy(this.heapArray, 0, newArray, 0, this.heapArray.length);
        this.heapArray = newArray;
    }

    public boolean isMinHeap(){ return this.isMinHeap; }

    public int getMax(){return this.max;}
    public int getMin(){return this.min;}

    public  int[] getHeapArray(){ return( this.heapArray == null? null : this.heapArray ); }

    private int getParentIndex(int index){ return ( (index <= 1)? 1 : index / 2);}

    private int getLeftChildrenIndex(int index){return index * 2;}

    private int getRightChildrenIndex(int index){return index * 2 + 1;}
}
