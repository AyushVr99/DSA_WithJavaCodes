import java.util.*;

public class HashMapImplementation {
    static class HashMap<K, V> {

        private class Node {
            K key;
            V value;
            public Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }
        private int n; //number of nodes
        private final int N; //number of buckets
        private LinkedList<Node>[] mapStructure;

        @SuppressWarnings("unchecked")
        public HashMap(){
            this.N = 6;
            this.mapStructure = new LinkedList[6];
            for(int i=0; i<6; i++){
                mapStructure[i] = new LinkedList<>();
            }
        }

        private int getIndex(K key){
            int bi = key.hashCode();
            return Math.abs(bi) % N;
        }
        private int searchAtIndexInLL(int bi, K key){
            for (int i = 0; i < mapStructure[bi].size(); i++) {
                Node node = mapStructure[bi].get(i);
                if(node.key == key){
                    return i;
                }
            }
            return -1;
        }
        private void rehash(){
            LinkedList<Node>[] oldStructure = mapStructure;
            mapStructure = new LinkedList[N * 3];

            for (int i = 0; i < mapStructure.length; i++) {
                mapStructure[i] = new LinkedList<>();
            }

            for (int i = 0; i < oldStructure.length; i++) {
                for (int j = 0; j < oldStructure[i].size(); j++) {
                    Node node = oldStructure[i].get(j);
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value){
            int bucketIndex = getIndex(key);
            int nodeIndex = searchAtIndexInLL(bucketIndex, key);

            if (nodeIndex == -1){
                mapStructure[bucketIndex].add(new Node(key, value));
            }
            else{
                Node node = mapStructure[bucketIndex].get(nodeIndex);
                node.value = value;
            }

            double rehashParameter = (double)n / N;

            if( rehashParameter > 2.0){
                rehash();
            }
        }
        public V get(K key){
            int bucketIndex = getIndex(key);
            int nodeIndex = searchAtIndexInLL(bucketIndex, key);
            return (nodeIndex != -1) ? mapStructure[bucketIndex].get(nodeIndex).value :  null;
        }

        public boolean containsKey(K key){
            int bucketIndex = getIndex(key);
            int nodeIndex = searchAtIndexInLL(bucketIndex, key);
            return nodeIndex != -1;
        }

        public V remove(K key){
            int bucketIndex = getIndex(key);
            int nodeIndex = searchAtIndexInLL(bucketIndex, key);
            if (nodeIndex == -1) return null;

            LinkedList<Node> list = mapStructure[bucketIndex];
            Node node =  list.remove(nodeIndex);
            return node.value;
        }
        public boolean isEmpty(){
            return n==0;
        }
        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();
            for (int i = 0; i < mapStructure.length; i++) {
                for (int j = 0; j < mapStructure[i].size(); j++) {
                    Node node = mapStructure[i].get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }

    }
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();

        map.put("India", "New Delhi");
        map.put("Uttar Pradesh", "Lucknow");
        map.put("Karnataka", "Bengaluru");

        System.out.println(map.containsKey("India"));
        System.out.println(map.remove("Karnataka"));

        for (String key : map.keySet()){
            System.out.println(map.get(key));
        }

        System.out.println(map.isEmpty());


    }
}
