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

    public void insert(Node<T> newNode){

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

    public T remove(T dataTobeRemoved){

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

    public void print(){

        Node temp = getHead();
        while (temp != null){
            System.out.println("("+temp.getData()+")");
            System.out.println("|");
            temp = temp.getNext();
        }
    }

}
