package collections;


public class HashTable<K,V> implements IHashTable<K,V>{
	
	
    public static final int AMOUNT = 1000;
	private HashNode<K,V>[] hashTable;
	private int sizeTable;
	
	
	@SuppressWarnings("unchecked")
	public HashTable(int sizeTable){
		this.sizeTable=sizeTable;
		hashTable = new HashNode[sizeTable];
    }
	
	@Override
	public HashNode<K,V>[] getHashTable() {
		return hashTable;
	}
	
	@Override
	public void setHashTable(HashNode<K,V>[] hashTable) {
		this.hashTable = hashTable;
	}
	
	
	@Override
	public int getSizeTable() {
		return sizeTable;
	}

	@Override
	public void setSizeTable(int sizeTable) {
//		hashTable[sizeTable];
		this.sizeTable = sizeTable;
	}


	@Override
	public void add(V newElement, K key) {
		int hash = getSlot(key, 1,1);
		HashNode<K, V> node = new HashNode<K, V>(key, newElement,hash);
		
		hashTable[hash] = node;
	}
	
	@Override
	public void remove(V newElement, K key) {
		int slot=getSlot(key, 1, 1);
		
		hashTable[slot]=null;
	
	}
	@Override
	public HashNode<K,V> search(K key) {
		
		int slot=getSlot(key, 1, 1);
		
		
		return hashTable[slot];
	}
	@Override
	public int size() {
		
		return hashTable.length;
	}
	@Override
	public boolean isEmpty() {
	
			boolean empty=false;
			
			for(int i=0;i<size()&&!empty;i++) {
				
				if(hashTable[i]!=null) {
					empty=true;
				}
			}
			return empty;
		}


	
	
	@Override
	public int getSlot(K key, int c1, int c2) {
		
		
		int hashFunction = key.hashCode() % hashTable.length;
		int slot=0;
		int i=0;
		int quadratic=0;
		int hash=hashFunction;
		    
			if(hashTable[hashFunction]==null) {
				slot=hashFunction;
			}else {
				boolean esta= false;
				while((hashTable[hash]!=null)&&!esta&&hash<hashTable.length) {
					if(hashTable[hash].getKey().hashCode()==key.hashCode()) {
						esta=true;
					}
					else {
				i++;
				quadratic=(int) ((hashFunction+ (c1*i)+(c2*(Math.pow(i, 2))))%hashTable.length);
				hash =quadratic;
					}
				}
				slot= hash;
			}
		return slot;
	}
	
	
	
//	public static void main(String[] args) {
//		IHashTable<Integer, String> n= new HashTable<Integer, String>(1);
//		n.setSizeTable(7);
//		
//
//		n.add("David", 36648);
//		n.add("Laura", 34745);
//		n.add("Douglas", 13359);
//		n.add("Huertas", 3);
//		n.add("kaka", 7);
//		
//		
//		for(int i=0; i<n.getHashTable().length;i++) {
//			if(n.getHashTable()[i]!=null){
//			System.out.println(n.getHashTable()[i].getValue()+" "+i);
//			
//			}
//		
//			
//		}
//		
//		System.out.println("buscado  "+n.search(7).getValue());
//		
//		}
		
		
	}
	

	
	
	
	


