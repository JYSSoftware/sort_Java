/**
 * Created by jinyongsuk on 10/19/16.
 */
public class LinkedList<T> extends Node<T> {

    private int size;
    private Node<T> head;

    LinkedList(){
        this.size = 0;
        this.head = null;
    }

    public void add(Node<T> newNode){

        Node pt;

        if (this.head == null || this.size == 0) {
            this.head = newNode;
            this.size++;
            return;
        }

        pt = findEnd();

        pt.setNext(newNode);
        this.size++;
    }

    public void insert(int index, T data){

        Node<T> temp = this.head;
        if (isEmpty()){
            this.head = new Node<>(data);
            return;
        }
        else if (index == 0){
            temp = new Node<>(data);
            temp.setNext(this.head);
            this.head = temp;
            return;
        }

        int counter = index;

        while (counter > 0){

            counter--;
            if (counter == 0){
                Node<T> newNode = new Node<>(data);
                newNode.setNext(temp.getNext());
                temp.setNext(newNode);
                this.size++;
                return;
            }
            temp = temp.getNext();
        }
    }

    public T remove(T dataTobeRemoved){

        if (isEmpty()) throw new NullPointerException();

        Node pt1 = getHead();
        while (pt1.hasNext()){
            if (pt1.getNext().getData() == dataTobeRemoved){
                Node tmp = pt1.getNext();
                pt1.setNext(tmp.getNext());
                tmp.setNext(null);
                this.size--;
                return (T)tmp.getData();
            }
            pt1 = pt1.getNext();
        }

        return null;
    }

    public Node<T> get(int index){
        Node pt = this.head;
        if (isEmpty()) throw new NullPointerException();

        int counter = index;

        while (counter > 0){
            counter--;
            pt = pt.getNext();
        }
        return pt;
    }

    public Node<T> getHead(){
        return this.head;
    }

    public Node<T> findEnd(){
        Node pt1 = getHead();

        //if this list size is 1 or 0 then only 1 head node or null
        if (this.size <= 1){
            return pt1; //return null or head node
        }

        while (pt1.hasNext()){
                pt1 = pt1.getNext();
        }
        return pt1;
    }

    public int getSize(){ return this.size; }

    public boolean isEmpty(){ return this.size == 0? true : false; }

    public void print(){

        Node temp = getHead();
        while (temp != null){
            System.out.println("("+temp.getData()+")");
            System.out.println("|");
            temp = temp.getNext();
        }
    }

}
