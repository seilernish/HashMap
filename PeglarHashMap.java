import java.util.ArrayList;
import java.util.Collection;

public class KieselHashMap<K,V> {

  Object[] bank = new Object[20];
  int size = 0;
  
  private class Lock
  {
    K key;
    V value;
    
    public Lock(K kim, V val)
    {
      key = kim;
      value = val;
    }
    
  }

	public KieselHashMap()
	{
		clear();
	}
	
	public int size()
	{
		return size;
	}
	
	public boolean isEmpty()
	{
		return size == 0;
	}
	
	public V get(K key)
	{
		if ( key == null ) return null;
		int address = Math.abs(key.hashCode()%bank.length);
		Lock l = (Lock)bank[address];
		if ( l == null || !l.key.equals(key) ) return null;
		return l.value;
	}
	
	public V remove(K key)
	{
		if ( key == null ) return null;
		int address = Math.abs(key.hashCode()%bank.length);
		Lock l = (Lock)bank[address];
		if ( l == null || !l.key.equals(key) ) return null;
		bank[address] = null;
		return l.value;
	}
	
	public void put(K key, V value)
	{
		if(key==null) {
		  return;
		}
	  int heck = Math.abs(key.hashCode())%bank.length;
	  if(bank[heck]!=null){
	    if(((Lock)bank[heck]).key.equals(key)){
	      bank[heck] = new Lock(key, value);
	    } else {
	      Object[] t = bank;
	      bank = new Object[bank.length*2];
	      size = 0;
	      for(Object ob: t){
	        if(ob!=null) {
	          put(((Lock)ob).key,((Lock)ob).value);
	        }
	      }
	      put(key, value);
	    }
	  }
	  
	}
	public void clear()
	{
		bank = new Object[20];
    size = 0;
	}
	
	public boolean containsKey(K key)
	{
	  if ( key == null ) return false;
		int address = Math.abs(key.hashCode()%bank.length);
		Lock l = (Lock)bank[address];
		if ( l == null || !l.key.equals(key) ) return false;
		return true;
	}
	
	public boolean containsValue(V value)
	{
		for ( Object thing : bank )
		{
		  if ( thing != null)
		  {
		    Lock l = (Lock)thing;
		    if ( thing.equals(value) ) {
		      return true;
		    }
		  }
		}
		return false;
	}
	
	public Collection<V> values()
	{
		ArrayList<V> nwah = new ArrayList<V>();
		for(Object thing: bank){
		  if(thing!=null) {
		    nwah.add(((Lock)thing).value);
		  }
		}
		return nwah;
	}
}
