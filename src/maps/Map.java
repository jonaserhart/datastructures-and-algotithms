package maps;

public interface Map<K,V> {
    int size();
    boolean isEmpty();
    V get(K key);
    V getOrDefault(K key);
    V remove (K key);
    Iterable<K> keySet();
    Iterable<V> values();
    Iterable<Entry<K,V>> entrySet();
}
