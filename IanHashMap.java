import java.util.ArrayList;
import java.util.Collection;

//Ian Travis

public class PaschalHashMap<K,V> {
  
  private Object[] nodes;
  private int size;

	public PaschalHashMap()
	{
		nodes=new Object[20];
		size=0;
	}
	
	private int getIndex(K k){
	  if(k==null)return -1;
	  return Math.abs(k.hashCode())%nodes.length;
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
	  if((nodes[getIndex(key)]!=null)&&(((Node)(nodes[getIndex(key)])).key.equals(key)))return ((Node)nodes[getIndex(key)]).value;
	  return null;
	}
	
	public V remove(K key)
	{
	  V answer=null;
	  if(key==null)return null;
		if((nodes[getIndex(key)]!=null)&&(((Node)(nodes[getIndex(key)])).key.equals(key))){answer=((Node)(nodes[getIndex(key)])).value;}else{return null;}
		nodes[getIndex(key)]=null;
		size--;
		return answer;
	}
	
	public void put(K key, V value)
	{
	  if(key==null)return;
		if(nodes[getIndex(key)]==null){
		  nodes[getIndex(key)]=new Node(key, value);
		  size++;
		  return;
		}
		if(((Node)(nodes[getIndex(key)])).key.equals(key)){
		  ((Node)(nodes[getIndex(key)])).value=value;
		  return;
		}
		Collection<Node> values=getNodes();
		clear(nodes.length*2);
		for(Node node:values){
		  put(node.key, node.value);
		}
		put(key, value);
	}
	
	public void clear()
	{
		nodes=new Object[20];
		size=0;
	}
	
	public void clear(int s)
	{
		nodes=new Object[s];
		size=0;
	}
	
	public boolean containsKey(K key)
	{
	  if(key==null)return false;
		if(nodes[getIndex(key)]!=null){
		  if(((Node)(nodes[getIndex(key)])).key.equals(key)){
		    return true;
		  }
		}
		return false;
	}
	
	public boolean containsValue(V value)
	{
		for(Object node:nodes){
		  if(node!=null&&((value==null&&((Node)node).value==null)||((Node)node).value.equals(value)))return true;
		}
		return false;
	}
	
	public Collection<Node> getNodes()
	{
		ArrayList<Node> answer = new ArrayList<Node>();
		for(Object node:nodes){
		  if(node!=null)answer.add((Node)node);
		}
		return answer;
	}
	
	public Collection<V> values()
	{
		ArrayList<V> answer = new ArrayList<V>();
		for(Object node:nodes){
		  if(node!=null)answer.add(((Node)node).value);
		}
		return answer;
	}
	
	private class Node{
	  
	  public Node(K k, V v){
	    key = k;
	    value=v;
	  }
	  
	  K key;
	  V value;
	}
	
}
