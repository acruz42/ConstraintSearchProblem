public class Tree {

   // instance variables
   private TNode root;
   private int size;

   // constructor 
   public Tree( TNode newRoot ) {

      root = newRoot;
      size = 1;
   }

   public void addNode( TNode parent , int addr , int e , int brFac , int lv ) {
      TNode add = new TNode( e , parent , brFac , lv ); 
      parent.setSucc( add , addr);
      size++;
   }

   public TNode addRoot( TNode n) {

      if (!isEmpty( )) throw new IllegalStateException( "Tree is not empty");
      root = n;
      size = 1;
      return root;
   }

   public int size( ) {

      return size;
   }

   /** returns true if the tree has no nodes, otherwise returns false
   */
   public boolean isEmpty( ) {

      return size == 0;
   }

   public TNode root( ) {

      return root;
   }

   public boolean isRoot( TNode n ) {

      return root == n;
   }

      /** returns the number of levels separating a given node
       from the root of the tree */

   public int depth( TNode aNode) {
      // base case  
      if (isRoot( aNode ))
         return 0;

      // recursive step
      return 1 + depth( aNode.getParent( ) );
   }

   public void inOrderTraversal( TNode startNode ) {

      System.out.print( startNode.element + "  " );

      for( int i = 0 ; i < startNode.succ.length ; i++ ) {
         if (startNode.succ[i] != null ) 
            inOrderTraversal( startNode.succ[i] );
      }

   } // end inOrderTraversal method

} // end class BinaryTree