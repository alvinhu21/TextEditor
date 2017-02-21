/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		// TODO: Add more tests here
		
		try{
			int b = list1.remove(6);
			fail("Check bounds");
		}catch(IndexOutOfBoundsException e){
			
		}
		
		try{
			int c = list1.remove(-2);
			fail("Check element is null");
		}catch(IndexOutOfBoundsException e){
			
		}
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		list1.add(15);
		assertEquals("AddEnd: check added element is correct ", (Integer)15, list1.get(list1.size()-1));
		assertEquals("Remove: check size is correct ", (Integer)4, (Integer)list1.size());
		list1.add(22);
		assertEquals("AddEnd: check added element is correct ", (Integer)22, list1.get(list1.size()-1));
		assertEquals("Remove: check size is correct ", (Integer)5, (Integer)list1.size());
		list1.add(38);
		assertEquals("AddEnd: check added element is correct ", (Integer)38, list1.get(list1.size()-1));
		assertEquals("Check size is correct ", (Integer)6, (Integer)list1.size());
		
		try{
			list1.add(null);
			fail("Check element is null");
		}catch(NullPointerException e){
			
		}
		

	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test

		list1.add(12);
		assertEquals("Size: check size is correct", (Integer)4,(Integer)list1.size());
		list1.add(24);
		assertEquals("Size: check size is correct", (Integer)5,(Integer)list1.size());
		list1.add(23);
		assertEquals("Size: check size is correct", (Integer)6,(Integer)list1.size());
		list1.remove(0);
		assertEquals("Size: check size is correct", (Integer)5,(Integer)list1.size());
		list1.remove(0);
		assertEquals("Size: check size is correct", (Integer)4,(Integer)list1.size());
		list1.remove(0);
		assertEquals("Size: check size is correct", (Integer)3,(Integer)list1.size());
		
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		list1.add(2,15);
		assertEquals("AddAtIndex: check the element at index is correct", (Integer)15, (Integer)list1.get(2));
		assertEquals("Remove: check size is correct ", 4, list1.size());
		list1.add(1,18);
		assertEquals("AddAtIndex: check the element at index is correct", (Integer)18, (Integer)list1.get(1));
		assertEquals("Remove: check size is correct ", 5, list1.size());
		list1.add(3,14);
		assertEquals("AddAtIndex: check the element at index is correct", (Integer)14, (Integer)list1.get(3));
		assertEquals("Remove: check size is correct ", 6, list1.size());
		try{
			list1.add(15,29);
			fail("Check bounds");
		}catch(IndexOutOfBoundsException e){
			
		}
		
		try{
			list1.add(-4,33);
			fail("Check bounds");
		}catch(IndexOutOfBoundsException e){
			
		}

		try{
			list1.add(0,null);
			fail("Check element is null");
		}catch(NullPointerException e){
			
		}
		
		try{
			list1.add(1,null);
			fail("Check element is null");
		}catch(NullPointerException e){
			
		}
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
		list1.set(0, 15);
		assertEquals("Set: check element 0 is correct", (Integer)15,list1.get(0));
		list1.set(1, 23);
		assertEquals("Set: check element 1 is correct", (Integer)23,list1.get(1));
		list1.set(2, 36);
		assertEquals("Set: check element 2 is correct", (Integer)36,list1.get(2));
		// TODO: implement this test
		try{
			list1.set(10,24);
			fail("Check bounds");
		}catch(IndexOutOfBoundsException e){
			
		}
		try{
			list1.set(-5,21);
			fail("Check bounds");
		}catch(IndexOutOfBoundsException e){
			
		}
		
		try{
			list1.set(0,null);
			fail("Check element is null");
		}catch(NullPointerException e){
			
		}
		
		try{
			list1.set(1,null);
			fail("Check element is null");
		}catch(NullPointerException e){
			
		}
	    
	}
	
	
	// TODO: Optionally add more test methods.
	
}
