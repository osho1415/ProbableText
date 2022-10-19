
/**
 * Use a hash table with separate chaining hashing to implement a portion of
 * interface java.util.Map<K, V>
 */

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class OurHashMap<K, V> implements OurMap<K, V> {

	// Map a key to a value as one object.
	public class HashNode {
		private K key;
		private V value;

		public HashNode(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	// Instance variables
	private static final int TABLE_SIZE = 20000;
	private LinkedList<HashNode>[] lists;
	int n;

	@SuppressWarnings("unchecked")
	public OurHashMap() {
		// TODO Initialize an array of TABLE_SIZE empty LinkedList<HashNode> objects

		lists = (LinkedList<HashNode>[]) new LinkedList<?>[TABLE_SIZE];

		for (int index = 0; index < TABLE_SIZE; index++) {
			lists[index] = new LinkedList<HashNode>();
		}

		n = 0;
	}

	// Precondition: Type K must override hashCode() like String
	// and Integer already do. This methods returns 0..TABLE_SIZE-1
	private int hashCode(K key) {
		// String's hashCode gets arithmetic overflow so it is often negative.
		// This is why we use Math.abs().

		return Math.abs(key.hashCode()) % TABLE_SIZE;
	}

	// If the key is not in use, map the key and the value by adding a
	// new HashNode to the correct LinkedList. Then return null.
	//
	// If there was a mapping to the key, replace and return
	// the existing value that was previously mapped to the key.
	public V put(K key, V value) {

		int index = hashCode(key);
		HashNode newPair = new HashNode(key, value);

		if (containsKey(key)) {

			HashNode temp = null; 
			int listIndex = 0;
			V tempValue = null;

			// searching for the key.
			while (listIndex < lists[index].size()) {

				temp = lists[index].get(listIndex);
				if (temp.key.equals(key)) {
					// getting the value.
					tempValue = temp.value;
					break;
				}
				listIndex++;

			}

			// getting the index of key.
			int indexOfKey = listIndex;

			// erasing previous key-value pair.
			lists[index].remove(indexOfKey);

			// rewriting new key-value pair.
			lists[index].addFirst(newPair);

			return tempValue;
		}

		// adding key-value pair.
		lists[index].addFirst(newPair);
		n++;

		return null;
	}

	// Return the number of mappings put into an OurMap object.
	public int size() {
		return n;
	}

	// Return the value to which key is mapped if the key is found.
	// If the key is not in this hash table, return null.
	public V get(K key) {

		if (!containsKey(key)) {
			return null;
		}

		int index = hashCode(key);

		HashNode temp = null; 
		int listIndex = 0;

		// searching for the key.
		while (listIndex < lists[index].size()) {
			temp = lists[index].get(listIndex);
			if (temp.key.equals(key)) {
				return temp.value;
			}
			listIndex++;

		}

		return null;
	}

	// Return true if a mapping with key already exists in this Map.
	// If the key is not in this hash table, return false.
	public boolean containsKey(K key) {

		int index = hashCode(key);

		if (lists[index].isEmpty()) {
			return false;

		} else {

			HashNode temp = null; 
			int listIndex = 0;

			// searching for the key.
			while (listIndex < lists[index].size() ) {
				
				temp = lists[index].get(listIndex);
				if (temp.key.equals(key)) {
					return true;
				} 
				listIndex ++;	
				
			}
		}

		return false;
	}

	// Returns a Set view of the keys contained in this map.
	public Collection<K> keySet() {

		Set<K> aSet = new HashSet<K>();

		for (int index = 0; index < TABLE_SIZE; index++) {

			if (!lists[index].isEmpty()) {
				
				HashNode temp = null; 
				int listIndex = 0;
	
				// going through every key in the linked list. 
				while (listIndex < lists[index].size()) {
					
					temp = lists[index].get(listIndex);
					aSet.add(temp.key);
					listIndex++;
	
				}
			}
		}

		return aSet;
	}

}
