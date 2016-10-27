/**
 * Created by jinyongsuk on 10/19/16.
 */
public class Stack<T> {

    Node<T> tail;
    int size;

    private void init(Node<T> tail, int size){
        this.tail = tail;
        this.size = size;
    }

    Stack(){
        init(null, 0);
    }

    public void push(T data){

        Node<T> newNode = new Node<>(data);
        if (isEmpty()){
            this.tail = newNode;
            this.size++;

        }else{
            newNode.setNext(this.tail);
            this.tail = newNode;
            size++;
        }
    }

    public T pop(){

        T removedData;
        if (isEmpty()) return null;
        else {
            Node<T> nextNode = this.tail.getNext();
            removedData = this.tail.getData();
            this.tail.setNext(null);
            this.tail = nextNode;
            return removedData;
        }
    }

    public Stack<T> reverse(){
        Stack<T> newStack = new Stack<>();
        if (isEmpty()) return null;
        else {
            while (!isEmpty())
            {
                newStack.push(this.pop());
            }
            return newStack;
        }
    }

    public Node<T> getTop(){
        return this.tail;
    }

    public boolean isEmpty(){
        return this.size == 0 ? true : false;
    }

}
