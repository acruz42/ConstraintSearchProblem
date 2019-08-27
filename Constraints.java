public class Constraints implements Cloneable {

   private CNode head;
   private CNode tail;
   public int size;

   public Constraints() {
      head = null;
      tail = null;
      size = 0;
   }

   public int size() {
      return size;
   }

   public CNode getHead( ) {
      return head;
   }

   public CNode getTail( ) {
      return tail;
   }

   public boolean isEmpty() {
      if ( size == 0 )
         return true;
      return false;
   } // end isEmpty method

   public void addNode( int c1 , int c2 ) {
      CNode newest = new CNode(c1 , c2 ) ;
      if ( isEmpty() )
         head = newest;
      else
         tail.setNext(newest);
      tail = newest;
      size++;
   }

} // end class
