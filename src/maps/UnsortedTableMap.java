package maps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class UnsortedTableMap<K,V> extends AbstractMap<K,V> {

    private ArrayList<MapEntry<K,V>> table = new ArrayList<>();

    public UnsortedTableMap() { }

    private int findIndex(K key){
        int n = table.size();
        for (int j = 0; j < n; j++){
            if(table.get(j).getKey().equals(key))
                return j;
        }
        return -1;
    }

    @Override
    public int size() {
        return table.size();
    }

    @Override
    public V get(K key) {
        var index = findIndex(key);
        if(index == -1) return null;
        return table.get(index).getValue();
    }

    public boolean containsKey(K k){
        for (var key: keySet()) {
            if(key.equals(k))
                return true;
        }
        return false;
    }

    @Override
    public V getOrDefault(K key) {
        return null;
    }

    public V put(K key, V value){
        int j = findIndex(key);
        if(j != -1) return table.get(j).getValue();
        table.add(new MapEntry<>(key, value));
        return null;
    }

    @Override
    public V remove(K key) {
        int j = findIndex(key);
        int n = size();
        if(j == -1) return null;
        var answer = table.get(j).getValue();
        if(j != n-1){
            table.set(j, table.get(n-1));
        }
        table.remove(n-1);
        return answer;
    }

    private class EntryIterator implements Iterator<Entry<K,V>>{

        private int j = 0;

        @Override
        public boolean hasNext() {
            return j < table.size();
        }

        @Override
        public Entry<K, V> next() {
            if (table.size() == j) throw new NoSuchElementException();
            return table.get(j++);
        }
    }

    private class EntryIterable implements  Iterable<Entry<K,V>>{

        @Override
        public Iterator<Entry<K, V>> iterator() {
            return new EntryIterator();
        }
    }

    @Override
    public Iterable<Entry<K, V>> entrySet() {
        return new EntryIterable();
    }
}
