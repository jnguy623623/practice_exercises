package cis44project;

import java.util.Arrays;
import java.util.EmptyStackException;

public final class ArrayStack<T> implements StackInterface<T>
{
	private T[] stack;    // Array of stack entries
	private int topIndex; // Index of top entry
    private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;
	
	
	private int[] list = new int[10];
	
	public ArrayStack()
	{
      this(DEFAULT_CAPACITY);
 	} // end default constructor
	
	public ArrayStack(int initialCapacity)
	{
      
      // The cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
      T[] tempStack = (T[])new Object[initialCapacity];
      stack = tempStack;
		topIndex = -1;
      initialized = true;
	} // end constructor

	public void push(T newEntry)
	{
		
		stack[topIndex + 1] = newEntry;
		topIndex++;
	} // end push

	public T peek()
	{
		
		if (isEmpty())
			throw new EmptyStackException();
		else
         return stack[topIndex];
	} // end peek

	public T pop()
	{
		
		if (isEmpty())
			throw new EmptyStackException();
		else
		{
			T top = stack[topIndex];
			stack[topIndex] = null;
			topIndex--; 
         return top;
		} // end if
   } // end pop

   public boolean isEmpty()
	{
		return topIndex < 0;
	} // end isEmpty
	
	public void clear()
	{
		
     
      // Remove references to the objects in the stack,
      // but do not deallocate the array
		while (topIndex > -1)
      {
			stack[topIndex] = null;
         topIndex--;
      } // end while
      //	Assertion: topIndex is -1	
	} // end clear
   
	
} // end ArrayStack