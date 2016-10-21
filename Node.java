/**
 * Created by jinyongsuk on 10/19/16.
 */
public class Node<T> {

    private Node<T> left, right, parent;
    private Node<T> next, previous;
    private T data;

    private void init(Node<T> l, Node<T> r, Node<T> p, Node<T> n){
        this.left = l;
        this.right = r;
        this.parent = p;
        this.next = n;
    }

    public Node(){
        init(null, null, null, null);
    }

    public Node(T data){
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    public Node(Node<T> l,Node<T> r, Node<T> p, Node<T> n){
        init(l, r, p, n);
    }

    public Node<T>[] getChildren(){
        return new Node[]{this.left, this.right, this.parent, this.next};
    }

    public boolean hasNext(){ return this.next != null? true : false; }

    public void setPrevious(Node<T> pre) { this.previous = pre;}

    public void setNext(Node<T> n) { this.next = n; }

    public void setLeft(Node<T> l){
        this.left = l;
    }

    public void setRight(Node<T> r){
        this.right = r;
    }

    public void setParent(Node<T> p){
        this.parent = p;
    }

    public void setData(T data){
        this.data = data;
    }

    public Node<T> getPrevious() { return this.previous;}

    public Node<T> getNext() { return this.next; }

    public Node<T> getLeftChild(){
        return this.left;
    }

    public Node<T> getRightChild(){
        return this.right;
    }

    public Node<T> getParent(){
        return this.parent;
    }

    public T getData(){
        return this.data;
    }

}
