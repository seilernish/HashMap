import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;

import java.util.Collection;


public class HashMapTester {

	private KieselHashMap<String, Integer> map = null;

	@Before
	public void setUp() throws Exception {
		map = new KieselHashMap<String, Integer>();
	}

	@After
	public void tearDown() throws Exception {
		map = null;
	}

	@Test
	public void newIsEmpty() {
		assertTrue("assert#1",map.isEmpty());
	}

	@Test
	public void newIsZero() {
		assertEquals("assert#1",0, map.size());
	}

	@Test
	public void newNull() {
		assertNull("assert#1",map.get("hi"));
	}

	@Test
	public void KentNoahAlpha() {
		assertEquals("assert#1",0,map.size());
		for(int i = 1; i < 10; i++)
		{
			map.put("k"+i, i);
		}
		assertEquals("assert#2",9,map.size());
		assertEquals("assert#3",new Integer(4),map.get("k4"));
		assertEquals("assert#4",9,map.size());
		assertEquals("assert#5",new Integer(4),map.get("k4"));
		assertEquals("assert#6",9,map.size());
		assertEquals("assert#7",new Integer(4),map.remove("k4"));
		assertEquals("assert#8",8,map.size());
		assertEquals("assert#9",null,map.get("k4"));
		assertEquals("assert#10",8,map.size());
	}
	
	@Test
	public void KentNoahBeta() {
		for(int i = 0; i < 2000; i++)
		{
			map.put("k"+i, i);
		}
		assertEquals("assert#1",2000,map.size());
		for(int i = 10; i < 1990; i++)
		{
			map.remove("k"+i);
		}
		assertEquals("assert#2",20,map.size());
		assertEquals("assert#3",new Integer(5),map.get("k5"));
		map.put("k5", 6);
		assertEquals("assert#4",new Integer(6),map.get("k5"));
		assertEquals("assert#5",20,map.size());
	}
	
	@Test
	public void KentNoahGamma() {
		for(int i = 0; i < 100; i++)
		{
			map.put("k"+i, i);
		}
		Collection<Integer> stuff = map.values();
		assertNotNull("assert#1",stuff);
		assertEquals("assert#2",100,stuff.size());
		for ( Integer i : stuff )
		{
			assertNotNull("assert#3",i);
		}
	}
	
	@Test
	public void KentNoahDelta() {
		assertNull("assert#1",map.get("Hello world!"));
		assertNull("assert#2",map.remove("Hello world!"));
		assertTrue("assert#3", map.size()==0 );
	}
	
	@Test
	public void kieselTestAlpha() {
	  map.put("K1",2018);
	  for ( int i = 2; i < 20002; i++)
	  {
	    assertNull("assert#1",map.get("K"+i));
	  }
	  assertNotNull("assert#2",map.get("K1"));
	}
	
	@Test
	public void evilKieselTest() {
		metaPyramid(1, 60);
	}

	private void metaPyramid(int here, int top) {
		pyramid(1, here);
		if (here < top) {
			metaPyramid(here + 1, top);
			pyramid(1, here);
		}
	}

	private void pyramid(int here, int top) {
		// System.out.println(here);
		map.put("U" + here + top, here);
		if (here < top) {
			pyramid(here + 1, top);
			// System.out.println(here);
			assertEquals("assert#1",new Integer(here), map.get("U" + here + top));
			map.put("D" + here + top, here);
			assertEquals("assert#2",new Integer(here), map.remove("D" + here + top));
		} else {
			assertEquals("assert#3",new Integer(here), map.remove("U" + here + top));
		}
	}

	@Test
	public void checkEduardoSeanKieselAlpha() {
		for (int i = 1; i <= 1500; i++) {
			map.put("Stuff" + i, i);
		}
		Collection<Integer> items = map.values();
		for (int i = 1; i <= 1500; i++) {
			assertTrue("assert#1",items.contains(i));
			assertTrue("assert#2",map.containsValue(i));
			assertTrue("assert#3",map.containsKey("Stuff" + i));
		}
	}

	@Test
	public void checkEduardoSeanAlpha() {
		map.put("K1", 1);
		assertEquals("assert#1",1, map.size());
		map.clear();
		assertEquals("assert#2",0, map.size());
		assertNull("assert#3",map.get("K1"));
		assertEquals("assert#4",0, map.size());
		map.remove("K1");
		assertEquals("assert#5",0, map.size());
	}

	@Test
	public void checkEduardoSeanBeta() {
		map.put("K1", 1);
		map.clear();
		assertFalse("assert#1",map.containsValue(1));
		map.put("K2", 2);
		assertEquals("assert#2",1, map.size());
		assertEquals("assert#3",new Integer(2), map.remove("K2"));
		assertEquals("assert#4",0, map.size());
		assertEquals("assert#5",null, map.remove("K2"));
		assertEquals("assert#6",0, map.size());

	}

	@Test
	public void checkClearCassieIsaac() {
		map.put("human", 15);
		map.clear();
		Collection<Integer> values = map.values();
		assertNotNull("assert#1",values);
		assertEquals("assert#2",0, values.size());
		map.clear();
		values = map.values();
		assertNotNull("assert#3",values);
		assertEquals("assert#4",0, values.size());
	}

	@Test
	public void checkPutKitIan() {
		map.put("K1", 1);
		assertEquals("assert#1",1, map.size());
		assertEquals("assert#2",new Integer(1), map.get("K1"));
		map.put("K1", 2);
		assertEquals("assert#3",1, map.size());
		assertEquals("assert#4",new Integer(2), map.get("K1"));
	}

	@Test
	public void checkTenMitchellWilsonJasonAidan() {
		for (int i = 1; i <= 100; i++) {
			map.put("K" + i, i);
		}
		assertTrue("assert#1",map.containsValue(61));
		assertTrue("assert#2",map.containsKey("K42"));
		assertNull("assert#3",map.get("K101"));
		assertNotNull("assert#4",map.get("K3"));
		assertEquals("assert#5",new Integer(3), map.get("K3"));
		map.clear();
		assertEquals("assert#6",0, map.size());
		assertTrue("assert#7",map.isEmpty());
		assertFalse("assert#8",map.containsValue(71));
		assertFalse("assert#9",map.containsKey("K12"));
	}

}
