package collections;

public class HashNode<K, V> {
	
	
    private K key;
    private V value;
    private int hash;
   

    public HashNode(K k, V v, int hash){
        key = k;
        value = v;
        this.hash=hash;
       
    }

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public int getHash() {
		return hash;
	}

	public void setHash(int hash) {
		this.hash = hash;
	}

	
	
	

    
    
	
	

}
