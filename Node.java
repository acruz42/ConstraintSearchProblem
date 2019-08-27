public class Node {

   public int lands[];
   private Node next;

   public Node ( int size[] ) {
      lands = size;
      next = null;
   }

   public String toString() {
      StringBuilder sb = new StringBuilder("");
      for( int i = 0 ; i < lands.length ; i++ ) {
         String blah = "Territory " + ( i + 1 ) + " = " + ( lands[ i ] ) + "\n";
         sb.append(blah);
      }
      return sb.toString();
   }

}
