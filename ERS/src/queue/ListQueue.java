package queue;

public class ListQueue<T> implements Queue<T>
{
   private int count;
   private LinearNode<T> front, rear;

   //-----------------------------------------------------------------
   //  Creates an empty queue.
   //-----------------------------------------------------------------
   public ListQueue()
   {
      count = 0;
      front = rear = null;
   }

   //-----------------------------------------------------------------
   //  Adds the specified element to the rear of this queue.
   //-----------------------------------------------------------------
   public void enqueue (T element)
   {
      LinearNode<T> node = new LinearNode<T>(element);

      if (count == 0)
	  {
         front = node;
		  rear = front;
	  }
      else
         rear.setNext(node);

      rear = node;
      count++;
   }
	
	public void addLinkedQueue (ListQueue<T> que)
	{
		if (count == 0) 
		{
			front = que.front;
			rear = que.rear;
			count = que.count;
		}
		else 
		{
			rear.setNext(que.front);
			rear = que.rear;
			count += que.count;
		}
	}
   //-----------------------------------------------------------------
   //  The front element is taken out of the queue and returned
   //  @throws EmptyCollectionException - if the queue is empty, a value can't be returned
   //-----------------------------------------------------------------
   public T dequeue () throws EmptyCollectionException 
   {
   		if(front == null)
   			throw new EmptyCollectionException("Queue is empty"); 
    	LinearNode<T> node = front;
	    if (count == 1) {
			front = null;
			rear = null;
		}
	   else {
		    front = front.getNext();
	   }

    	count--;
    	return node.getElement();
    	
   }
   //-----------------------------------------------------------------
   //  The front element is returned but not taken out of the queue
   //  @throws EmptyCollectionException - if the queue is empty, a value can't be returned
   //-----------------------------------------------------------------
   public T first () throws EmptyCollectionException 
   {
    	if(front == null)
    		throw new EmptyCollectionException("Queue is empty");
    	return front.getElement();
   }
   //-----------------------------------------------------------------
   //  returns true if the queue is empty
   //-----------------------------------------------------------------
   public boolean isEmpty() 
   {
    	return front == null;
   }
   //-----------------------------------------------------------------
   //  Returns the amount of elements that are in the linked queue
   //-----------------------------------------------------------------
   public int size() 
   { 
   		return count;
   }
   //-----------------------------------------------------------------
   //  returns the toString of the first element
   //-----------------------------------------------------------------
   public String toString() 
   {
	   LinearNode<T> temp = front;
	   String result = "";
	   while (temp != rear) {
		   result += ((temp.getElement()).toString() + "\n");
		   temp = temp.getNext();
	   }
	   result += ((rear.getElement()).toString() + "\n");
    	return result;
   }
}