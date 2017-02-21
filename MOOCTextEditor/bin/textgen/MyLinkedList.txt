package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		this.size = 0;
		this.head = new LLNode<E>();
		this.tail = new LLNode<E>();
		this.head.next = this.tail;
		this.tail.prev = this.head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if(element == null){
			throw new NullPointerException("The element was null.");
		}
		LLNode<E> newNode = new LLNode<E>(element);
		LLNode<E> prev = tail.prev;
		prev.next = newNode;
		newNode.prev = prev;
		newNode.next = tail;
		tail.prev = newNode;
		
		size++;
		return false;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		if(index < 0){
			throw new IndexOutOfBoundsException("The index was too low.");
		}else if(index >= size){
			throw new IndexOutOfBoundsException("The index was too high.");
		}
		// TODO: Implement this method.
		LLNode<E> target = head;
		for(int i = 0; i <= index; i++){
			target = target.next;
		}
	
		return target.data;

	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		if(element == null){
			throw new NullPointerException("The element was null.");
		}
		if(size > 0){
			if(index < 0){
				throw new IndexOutOfBoundsException("The index was too low.");
			}else if(index >= size){
				throw new IndexOutOfBoundsException("The index was too high.");
			}
		}
		


		LLNode<E> newNode = new LLNode<E>(element);
		LLNode<E> target = head;
		
		for(int i = 0; i < index; i++){
			target = target.next;
		}
		
		LLNode<E> target2 = target.next;
		
		target.next = newNode;
		newNode.prev = target;
		
		newNode.next = target2;
		target2.prev = newNode;
		size++;
		
		
		// TODO: Implement this method
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method

		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if(index < 0){
			throw new IndexOutOfBoundsException("The index was too low.");
		}else if(index >= size){
			throw new IndexOutOfBoundsException("The index was too high.");
		}
		LLNode<E> target = head;
		for(int i = 0; i <= index; i++){
			target = target.next;
		}
		
		target.prev.next = target.next;
		target.next.prev = target.prev;
		size--;
		E ret_val = target.data;
		target = null;
		return ret_val;

	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		if(index < 0){
			throw new IndexOutOfBoundsException("The index was too low.");
		}else if(index >= size){
			throw new IndexOutOfBoundsException("The index was too high.");
		}else if(element == null){
			throw new NullPointerException("The element was null.");
		}
		LLNode<E> target = head;
		for(int i = 0; i <= index; i++){
			target = target.next;
		}
		target.data = element;
		// TODO: Implement this method
		return element;
		
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor
	public LLNode(){
		this.data = null;
		this.prev = null;
		this.next = null;
	}

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
