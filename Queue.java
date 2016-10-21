/**
 * Created by jinyongsuk on 10/19/16.
 */
public class Queue<T> {

    int size;
    Node<T> first, last;

    public void init(){
        this.size = 0;
        this.first = null;
        this.last = null;
    }

    public Queue(){
        init();
    }

    public void push(T value){

        Node<T> newNode = new Node<>(value);
        if (isEmpty()){
            this.first = newNode;
        }else{
            newNode.setNext(this.last);
        }
        this.last = newNode;
        this.size++;
    }

    public T dequeue(){

        Node temp = this.last;
        T removedValue = this.first.getData();

        if (isEmpty()){
            return null;
        }
        else if (this.size == 1){
            this.last = null;
            this.first = null;
            return removedValue;
        }else {
            Node pre = temp;
            temp = temp.getNext();

            while (temp.getNext() != null){
                pre = pre.getNext();
                temp = temp.getNext();
            }
            pre.setNext(null);
            this.size--;
            removedValue = (T)temp.getData();
            this.first = pre;
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
