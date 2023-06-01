package ProjAlgAndStructData.less4.module;

public class Node<K,V> {
    private K key;
    private V value;
    private Node<K,V> next;
    private int hashCode;

    public Node(K key, V value, int hashCode, Node<K, V> next){
        this.key = key;
        this.value = value;
        this.hashCode = hashCode;
        this.next = next;
    }
    public K getKey(){
        return key;
    }
    public V getValue(){
        return value;
    }
    public int getHashCode(){
        return hashCode;
    }
    public Node<K,V> getNext(){
        return next;
    }
    public V setValue(V value){
        this.value = value;
        return value;
    }
    public Node<K,V> setNext(Node<K,V> next){
        this.next = next;
        return next;
    }
    @Override
    public String toString(){
        return key + "=" + value;
    }
}
