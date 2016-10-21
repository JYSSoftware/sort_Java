import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * Created by jinyongsuk on 10/20/16.
 */
class HashEntry<T> extends Node{
    String key;
    HashEntry next;
    T data;
    HashEntry(String key, T data){
        this.key = key;
        this.data = data;
        this.next = null;
    }
}

public class HashTable<T> {
    private int size;
    private HashEntry[] table;
    private int TABLE_SIZE;

    public HashTable(int ts){
        this.TABLE_SIZE = ts;
        this.size = 0;
        this.table = new HashEntry[ts];
        clearAll();
    }

    public T add(String key, T value){

        int hash = hashFunction(key);

        if (this.table[hash] == null){
            this.table[hash] = new HashEntry(key, value);
        }else{
            HashEntry<T> current = this.table[hash];
            while (current.next != null && !current.key.equals(key)){
                current = current.next;
            }

            if (current.key.equals(key)){
                current.data = value;
            }else {
                current.next = new HashEntry(key, value);
            }
        }

        size++;
        return value;
    }

    public T get(String key){
        int hash = hashFunction(key);
        if (this.table[hash] == null){
            throw null;
        }
        else{
            HashEntry<T> current = this.table[hash];
            while (current.next != null && !current.key.equals(key)){
                current = current.next;
            }
            if (current == null){
                return null;
            }else{
                return current.data;
            }
        }
    }

    public void remove(String key){
        int hash = hashFunction(key);

        if (this.table[hash] == null)
            return;

        else{
            HashEntry<T> previous = null;
            HashEntry<T> current = this.table[hash];

            while (current.next != null && !current.key.equals(key)){
                previous = current;
                current = current.next;
            }

            if (current.key.equals(key)){
                if (previous == null){
                    this.table[hash] = current.next;
                }else {
                    previous.next = current.next;
                }
                this.size--;
            }

        }

    }


    public void clearAll(){
        for (int i = 0; i < this.TABLE_SIZE; i++){
            table[i] = null;
        }
    }

    public int hashFunction(String x){
        int val = x.hashCode();
        int hash = val % TABLE_SIZE;
        if (table[hash] != null){
            hash = 1 + val % getFirstLessPrime(TABLE_SIZE);
        }
        return hash;
    }

    private int getFirstLessPrime(int n){

        for (int i = n - 1; i >=2; i--){
            for (int j = 2; j <= i; j++ ){
                if (i == j){
                    return i;
                }
                if (i % j == 0){
                    break;
                }
            }
        }
        return 2;
    }
}




