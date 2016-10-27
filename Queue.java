/**
 * Created by jinyongsuk on 10/19/16.
 * Insertion : O(1)
 * Delete : O(1)
 *
 */
public class Queue<T> {

    int size;
    Node<T> front, last;

    public void init(){
        this.size = 0;
        this.front = null;
        this.last = null;
    }

    public Queue(){
        init();
    }

    public void push(T value){

        Node<T> newNode = new Node<>(value);
        if (isEmpty()){
            this.last = this.front = newNode;
        }else{
            this.front.setNext(newNode);
        }
        this.front = newNode;
        this.size++;
    }

    public T dequeue(){

        if (isEmpty()){
            throw new NullPointerException();
        }

        T removedValue = this.last.getData();
        if (this.front == this.last){
            this.front = this.last = null;
            return removedValue;
        } else {
            Node temp = this.last;
            this.last = this.last.getNext();
            removedValue = (T)temp.getData();
            temp.setNext(null);
            return removedValue;
        }
    }

    public void print(){
        Node tmp = this.last;
        while (tmp != null){
            System.out.println("printing ["+tmp.getData()+"]");
            tmp = tmp.getNext();
        }
    }

    public boolean isEmpty(){
        return this.size == 0? true : false;
    }

    public int getSize(){
        return this.size;
    }
}
