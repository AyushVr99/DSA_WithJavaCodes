import java.util.*;

public class HashMapImplementation
{
	static class HashMap<K,V> {
		private class Node {
			K key;
			V value;
			public Node(K key, V value) {
				this.key = key;
				this.value = value;
			}
		}

		private int n; //no. of nodes
		private int N; //no. of buckets
		private LinkedList<Node>[] mapStructure;

		@SuppressWarnings("unchecked")
		public HashMap() {
			this.N = 6;
			this.mapStructure = new LinkedList[N];

			for(int i=0; i<N; i++) {
				this.mapStructure[i] = new LinkedList<>();
			}
		}

		private int getBucketIndex(K key) {
			if(key == null) return 0;
			return Math.floorMod(key.hashCode(), N);
		}

		private int searchInLinkedList(int bi, K key) {

			int i = 0;

			for (Node node : mapStructure[bi]) {
				if(Objects.equals(node.key, key)) {
					return i;
				}
				i++;
			}
			return -1;

		}

		private void insertNode(K key, V value) {

			int bucketIndex = getBucketIndex(key);

			mapStructure[bucketIndex].add(new Node(key, value));

			n++;
		}

		private void rehash() {
			LinkedList<Node>[] oldStructure = mapStructure;

			N = N * 2;

			@SuppressWarnings("unchecked")
			LinkedList<Node>[] newStructure = new LinkedList[N];

			mapStructure = newStructure;

			for (int i = 0; i < N; i++) {
				mapStructure[i] = new LinkedList<>();
			}

			n = 0;

			for (LinkedList<Node> bucket : oldStructure) {

				for (Node node : bucket) {
					insertNode(node.key, node.value);
				}
			}
		}

		public void put(K key, V value) {
			int bi = getBucketIndex(key);
			int nodeIndex = searchInLinkedList(bi, key);

			if(nodeIndex == -1) {
				mapStructure[bi].add(new Node(key, value));
				n++;
			}
			else {
				Node node =  mapStructure[bi].get(nodeIndex);
				node.value = value;
			}

			double loadFactor = (double)n / N;

			if(loadFactor > 0.75) {
				rehash();
			}
		}

		public V remove(K key) {
			int bi = getBucketIndex(key);
			int nodeIndex = searchInLinkedList(bi, key);
			if (nodeIndex == -1) {
				return null;
			}
			LinkedList<Node> list = mapStructure[bi];
			Node node = list.remove(nodeIndex);
			n--;
			return node.value;

		}

		public boolean isEmpty() {
			return n == 0;
		}

		public boolean containsKey(K key) {

			int bucketIndex = getBucketIndex(key);

			int nodeIndex = searchInLinkedList(bucketIndex, key);

			return nodeIndex != -1;
		}

		public V get(K key) {
			int bi = getBucketIndex(key);
			int nodeIndex = searchInLinkedList(bi, key);

			if (nodeIndex == -1) {
				return null;
			}

			return mapStructure[bi].get(nodeIndex).value;
		}

		public ArrayList<K> keySet() {

			ArrayList<K> keys = new ArrayList<>();

			for(LinkedList<Node> list : mapStructure) {
				for(Node node : list) {
					keys.add(node.key);
				}
			}

			return keys;
		}

		public int size() {
			return n;
		}
	}
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();

		// Normal keys
		map.put("India", "New Delhi");
		map.put("Uttar Pradesh", "Lucknow");
		map.put("Karnataka", "Bengaluru");

		// Null key
		map.put(null, "Null Key Value");

		System.out.println("India: " + map.get("India"));

		System.out.println("Null key: " + map.get(null));

		System.out.println("Contains India: "
		                   + map.containsKey("India"));

		System.out.println("Contains null: "
		                   + map.containsKey(null));

		System.out.println("Removed Karnataka: "
		                   + map.remove("Karnataka"));

		System.out.println("Removed null: "
		                   + map.remove(null));

		System.out.println("Contains null after remove: "
		                   + map.containsKey(null));

		System.out.println("\nRemaining entries:");

		for (String key : map.keySet()) {

			System.out.println(
			    key + " -> " + map.get(key)
			);
		}

		System.out.println("\nSize: " + map.size());

		System.out.println("Is empty: " + map.isEmpty());
	}
}
