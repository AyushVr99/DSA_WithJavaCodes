import java.util.ArrayList;

public class HashSetImplementation {
    static class HashSet<K>{
        private static final Object constValueObject = new Object();
        private HashMapImplementation.HashMap<K, Object> map;

        public HashSet(){
            map = new HashMapImplementation.HashMap<>();
        }

        public void add(K key){
            map.put(key, constValueObject);
        }
        public boolean contains(K key){
            return map.containsKey(key);
        }
        public boolean isEmpty(){
            return map.isEmpty();
        }
        public void remove(K key) {
            map.remove(key);
        }
        public ArrayList<K> keys(){
            return map.keySet();
        }
    }

    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Delhi");
        hashSet.add("Mumbai");
        hashSet.add("Bengaluru");
        hashSet.add("Delhi");
        System.out.println(hashSet.contains("Chandigarh"));
        hashSet.remove("Delhi");
        System.out.println(hashSet.keys());
    }
}
