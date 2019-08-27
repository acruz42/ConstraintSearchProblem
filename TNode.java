public class TNode
{
   // instance variables
   public int element;
   private TNode parent;
   public TNode succ[];
   private boolean status;
   public int level;
   

   // constructor
   public TNode (int e, TNode dad , int branchFactor , int lv ) {
      element = e;
      parent = dad;
      succ = new TNode [ branchFactor ];
      status = false;
      level = lv;
   }

   public TNode getParent( ){
      return parent;
   }

   public TNode getSucc( int i ) {
      return succ[i];
   }

   public void setSucc( TNode e , int addr ) {
      succ[addr] = e;
   }

   public String toString() {
      StringBuilder sb = new StringBuilder( "Node Element " + element + "\n" );
      for( int i = 0 ; i < succ.length ; i++ ) {
         sb.append( "Succ "+ i +" is " );
         if ( succ[i] == null )
            sb.append("null\n");
         else
            sb.append( succ[i].element + "\n");
         
      }
      return sb.toString();
   }

   public boolean hasSuccs() {
      for( int i = 0 ; i < succ.length ; i++ ) {
         if( succ[i] == null )
            return true;
      }
      return false;
   }

   public boolean visited() {
      return status;
   }

   public void visit() {
      status = true;
   }

} // end class TNode