package queue;

public class EmptyCollectionException extends RuntimeException
{
   //------------------------------------------------------------------
   //  Sets up this exception with an appropriate message.
   //------------------------------------------------------------------
   public EmptyCollectionException (String message)
   {
      super (message);
   }
}