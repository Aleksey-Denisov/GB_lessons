package ProjAlgAndStructData.less4.module;

public class SelfHashMap<K, V>{
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private static final int DEFAULT_LENGTH = 16;
    private int arrayLength;
    private int size;
    private float loadFactor;
    private Node<K, V>[] tables;
    public SelfHashMap() {
        this(DEFAULT_LENGTH, DEFAULT_LOAD_FACTOR);
    }
    public SelfHashMap(int length) {
        this(length, DEFAULT_LOAD_FACTOR);
    }
    public SelfHashMap(int length, float loadFactor) {
        if (length <= 0) {
            throw new IllegalArgumentException("Длина инициализации должна быть больше 0");
        }
        if (loadFactor <= 0) {
            throw new IllegalArgumentException("Коэффициент нагрузки должен быть больше 0");
        }
        this.arrayLength = length;
        this.loadFactor = loadFactor;
        //реализация через веселый костыль от разработчиков Хеш Мапа
        //Данная аннотация убирает косяк небезопасного конвертирования типов и все замечательно
        //при этом переменную нужно объявить и инциализировать
        @SuppressWarnings({"unchecked"})
        Node<K,V>[] newTab = (Node<K,V>[])new Node[length];
        tables = newTab;
    }
    //Получение значения по ключу
    public V get(K key) {
        int index = indexForArray(hash(key), arrayLength);
        Node<K, V> node = tables[index];
        for (Node<K, V> n = node; n != null; n = n.getNext()) {
            if ((key == null && null == n.getKey()) || (key != null && key.equals(n.getKey()))) {
                return n.getValue();
            }
        }
        return null;
    }
    //Добавление данных
    public V put(K key, V value) {
        int hashCode = hash(key);
        int index = indexForArray(hashCode, arrayLength);
        // Если текущая позиция
        Node<K, V> node = tables[index];
        if (node == null) {
            tables[index] = new Node<>(key, value, hashCode, null);
        } else {
            for (Node<K, V> n = node; n != null; n = n.getNext()) {
                // Если ключ уже существует
                K nodeKey = n.getKey();
                if ((key == null && null == nodeKey) || (key != null && key.equals(nodeKey))) {
                    System.out.println("Данный ключ уже существует");
                }
                // Ключ не существует, если он считается последним в очереди, создается новый Узел и помещается в конец очереди
                if (n.getNext() == null) {
                    n.setNext(new Node<>(key, value, hashCode, null));
                    break;
                }
            }
        }
        // Определяем, будет ли увеличен массив
        if (++size > arrayLength * loadFactor) {
            resize();
        }
        return null;
    }
    //Возвращаем длину массива
    public int size() {
        return size;
    }
    //меняем значения по ключу
    public void replays(K key, V value){
        int index = indexForArray(hash(key), arrayLength);
        Node<K, V> node = tables[index];
        for (Node<K, V> n = node; n != null; n = n.getNext()) {
            if ((key == null && null == n.getKey()) || (key != null && key.equals(n.getKey()))) {
                n.setValue(value);
            }else{
                System.out.println("Указанного ключа не существует");
            }
        }
    }
    //Удаляем элемент из списка
    public V remove(K key){
        Node<K,V> e;
        return (e = removeNode(hash(key), key, null, false, true)) == null ?
            null : e.getValue();
    }
    private Node<K,V> removeNode(int hash, K key, V value,
                                boolean matchValue, boolean movable) {
        Node<K,V>[] tab; Node<K,V> p; int n, index;
        if ((tab = tables) != null && (n = tab.length) > 0 &&
            (p = tab[index = (n - 1) & hash]) != null) {
            Node<K,V> node = null, e; K k; V v;
            if (p.getHashCode() == hash &&
                ((k = p.getKey()) == key || (key != null && key.equals(k))))
                node = p;
            else if ((e = p.getNext()) != null) {
                do {
                    if (e.getHashCode() == hash && ((k = e.getKey()) == key || (key != null && key.equals(k)))) {
                            node = e;
                            break;
                        }
                        p = e;
                    } while ((e = e.getNext()) != null);
            }
            if (node != null && (!matchValue || (v = node.getValue()) == value ||
                                 (value != null && value.equals(v)))) {
                if (node == p)
                    tab[index] = node.getNext();
                else
                    p.setNext(node.getNext());
                --size;
                return node;
            }
        }
        return null;
    }
    //Для отображения
    public void printer(){
        for(int idElement = 0; idElement < tables.length; idElement++){
            if(tables[idElement] != null)
                System.out.println(tables[idElement]);
        }
    }
    //Проверка существует ли запись по ключу
    public boolean containsKey(K key) {
        return getNode(key) != null;
    }
    private Node<K,V> getNode(K key) {
        Node<K,V>[] tab; Node<K,V> first, e; int n, hash; K k;
        if ((tab = tables) != null && (n = tab.length) > 0 &&
            (first = tab[(n - 1) & (hash = hash(key))]) != null) {
            if (first.getHashCode() == hash &&
                ((k = first.getKey()) == key || (key != null && key.equals(k))))
                return first;
            if ((e = first.getNext()) != null) {
                do {
                    if (e.getHashCode() == hash &&
                        ((k = e.getKey()) == key || (key != null && key.equals(k))))
                        return e;
                } while ((e = e.getNext()) != null);
            }
        }
        return null;
    }
    //Проверка существует ли запись по значению
    public boolean containsValue(V value) {
        Node<K,V>[] tab; V v;
        if ((tab = tables) != null && size > 0) {
            for (Node<K,V> e : tab) {
                for (; e != null; e = e.getNext()) {
                    if ((v = e.getValue()) == value ||
                        (value != null && value.equals(v)))
                        return true;
                }
            }
        }
        return false;
    }
    private int hash(K key) {
        return key == null ? 0 : key.hashCode();
    }
    private int indexForArray(int hashCode, int arrayLength) {
        int index = Math.abs(hashCode) % arrayLength;
        return index;
    }
    private void resize() {
        int newLength = arrayLength * 2;
        @SuppressWarnings({"unchecked"})
        Node<K, V>[] newTables = (Node<K,V>[])new Node[newLength];
        if (tables != null) {
            for (int j = 0; j < arrayLength; ++j) {
                Node<K,V> e;
                if ((e = tables[j]) != null) {
                    tables[j] = null;
                    if (e.getNext() == null)
                        newTables[e.getHashCode() & (arrayLength - 1)] = e;
                    else {
                        Node<K,V> loHead = null, loTail = null;
                        Node<K,V> hiHead = null, hiTail = null;
                        Node<K,V> next;
                        do {
                            next = e.getNext();
                            if ((e.getHashCode() & arrayLength) == 0) {
                                if (loTail == null)
                                    loHead = e;
                                else
                                    loTail.setNext(e);
                                loTail = e;
                            }
                            else {
                                if (hiTail == null)
                                    hiHead = e;
                                else
                                    hiTail.setNext(e);
                                hiTail = e;
                            }
                        } while ((e = next) != null);
                        if (loTail != null) {
                            loTail.setNext(null);
                            newTables[j] = loHead;
                        }
                        if (hiTail != null) {
                            hiTail.setNext(null);
                            newTables[j + arrayLength] = hiHead;
                        }
                    }
                }
            }
        }
        tables = newTables;
        arrayLength = newLength;
    }
}
