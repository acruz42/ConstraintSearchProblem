public class CNode {

   public int c1 , c2;
   private CNode next;

   public CNode ( int constraint1 , int constraint2 ) {
      c1 = constraint1;
      c2 = constraint2;
      next = null;
   }

   public CNode getNext() {
      return next;
   }

   public void setNext( CNode n ) {
      next = n;
   }

}
