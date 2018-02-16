import java.util.ArrayList;
import java.util.Collection;

public class CassieHashMap<K,V> {

  private class Entry{
    K k;
    V v;
    private Entry(K ey, V alue){
	    k = ey;
	    v = alue;
	  }
    public K getKey(){
      return k;
    }
	  public V getVal(){
	    return v;
	  }
  }
  
  private Object[] entries;
  private int size;
	public CassieHashMap()
	{
		clear();
		
	}
	
	private int hash(K key){
	  return Math.abs(key.hashCode())%entries.length;
	}
	
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
		if(key==null)return null;
		int h = hash(key);
		Entry e = (Entry)entries[h];
		if ( e != null && e.getKey().equals(key)  ) return e.getVal();
		return null;
	}
	
	public V remove(K key)
	{
		if(key==null)return null;
		int h = hash(key);
		Entry t = (Entry)entries[h];
		if(t!=null && t.getKey().equals(key)){
		  size--;
		  entries[h]=null;
		  return t.getVal();
		}
		return null;
	}
	
	public void put(K key, V value)
	{
		if(key==null||value==null) return;
		int h = hash(key);
		if(entries[h]==null){
		  entries[h] = new Entry(key, value);
		  size++;
		  return;
		}
		if(((Entry)entries[h]).getKey().equals(key)){
		  entries[h] = new Entry(key, value);
		  return;
		}
		grow(2*entries.length);
		put(key, value);
	}
	
	public void grow(int s){
	  Object[] temp = new Object[s];
	  for(int i=0; i<entries.length; i++){
	    if(entries[i]!=null){
	      Entry e = (Entry)entries[i];
	      int p = Math.abs(e.getKey().hashCode())%temp.length;
	      V w = e.getVal();
	      if(temp[p]!=null){
	        grow(2*s);
	        return;
	      } 
	     temp[p]=e;
	    }
	    
	  }
	  
	  entries = temp;
	}
	
	public void clear()
	{
		entries = new Object[20];
		size=0;
	}
	
	public boolean containsKey(K key)
	{
		for(Object d: entries){
		  if(d!=null && key.equals(((Entry)d).k)) return true;
		}
	return false;
	}
	
	public boolean containsValue(V value)
	{
		for(Object f: entries){
		  if(f!=null && value.equals(((Entry)f).v)) return true;
		}
	return false;
	}
	
	public Collection<V> values()
	{
		ArrayList<V> vs = new ArrayList<V>();
		for(Object g: entries){
		  if(g!=null) vs.add(((Entry)g).v);
		}
		return vs;
	}
	
}
