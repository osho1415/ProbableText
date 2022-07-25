/**
* interface OurMap has these five of the major methods of java.util.Map:
 *  1) put<K,V> 
 *  2) size
 *  3) get<K>
 *  4) boolean containsKey(K)
 *  5) keySet()
 * 
 * @author Rick Mercer
 *
 * @param <K>
 *          The key for each mapping. This should be Integer or String.
 * @param <V>
 *          The value that gets mapped to K key.
 */
import java.util.Collection;

public interface OurMap<K, V> {

  // If there was a mapping to the key, replace and return
  // the existing value that was previously mapped to the key.
  public V put(K key, V value);
  
  // Return the number of mappings put into an OurMap object.
  public int size();

  // Return the value to which key is mapped if the key is found.
  // If the key is not in this hash table, return null.
  public V get(K key);

  // Return true if a mapping with key already exists in this Map.
  // If the key is not in this hash table, return false.
  public boolean containsKey(K key);
  
  // Returns a Set view of the keys contained in this map.
  public Collection<K> keySet();
}