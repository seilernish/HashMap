import java.util.ArrayList;
import java.util.Collection;

public class KitHashMap<K,V> {
  private Object[] items = new Object[20];
  private int size = 0;
  
	public int size()
	{
		return size;
	}
	
	public boolean isEmpty()
	{
		return size==0;
	}
	
	public V get(K key)
	{
	  //Edge case
	  if(key==null) return null;
	  
	  //Find the hash of the key
		int hash = Math.abs(key.hashCode()%items.length);
		
		if(items[hash]==null) return null;
		
		//Return the item, casted to.
		return ((Item)items[hash]).value;
	}
	
	public V remove(K key)
	{
	  //Edge case
	  if(key==null) return null;
	  
	  //Get the item.
		int hash = Math.abs(key.hashCode())%items.length;
		if(items[hash]==null)return null;
		Item temp = (Item)items[hash];
		
		//If that item was in the list, decrement the size.
		if(temp!=null) size--;
		
		//Remove the item from the list.
		items[hash]=null;
		
		//Cast and return.
		return temp.value;
	}
	
	public void put(K key, V value)
	{
	  //Edge case
	  if(key==null) return;
	  
	  //Get the hash of the key
	  int hash = Math.abs(key.hashCode())%items.length;
	  
	  //If there's something in that spot already
	  if(items[hash]!=null){
	    //If it has the same key
	    if(((Item)items[hash]).key.equals(key)){
        //Put the item in
	      items[hash] = new Item(key, value);
	    }
	    else{
	      //Double the array size, then re-hash everything inside.
	      Object[] temp = items;
	      items = new Object[items.length*2];
	      size = 0;
	      for(Object o: temp){
	        if(o!=null)put(((Item)o).key,((Item)o).value);
	      }
	      put(key, value);
	    }
	  }
	  else{
	    //Put the item in and increase the size by one.
	    items[hash] = new Item(key, value);
	    size++;
	  }
	  
	  return;
	}
	
	public void clear()
	{
		items = new Object[20];
		size = 0;
		return;
	}
	
	public boolean containsKey(K key)
	{
    for(Object o: items){
      if(o!=null){
		    K compareKey = ((Item)o).key;
		    if(key.equals(compareKey)) return true;
      }
		}
		return false;
	}
	
	public boolean containsValue(V value)
	{
		for(Object o: items){
		  if(o!=null){
		    V compareVal = ((Item)o).value;
  		  if(value.equals(compareVal)) return true;
		  }
		}
		return false;
	}
	
	public Collection<V> values()
	{
		ArrayList<V> vals = new ArrayList<V>();
		for(Object o: items){
		  if(o!=null)vals.add(((Item)o).value);
		}
		return vals;
	}
	
	private class Item{
	  public K key;
	  public V value;
	  private Item(K theKey, V item){
	    key = theKey;
	    value = item;
	  }
	}
}
