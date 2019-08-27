import java.util.*;
import java.io.*;

public class program2 {

   public static boolean satisfiesCons ( int n[] , Constraints c ) {
      CNode walk = c.getHead();
      while ( walk != null ) {
         if ( n[ walk.c1 - 1 ] == n[ walk.c2 - 1 ] ) {
            return false;
         }
         walk = walk.getNext();
      }
      return true;
   }

   public static boolean forwardCheck ( int n[] , Constraints c , int level ) {
      CNode walk = c.getHead();
      while ( walk != null ) {
         if ( walk.c1 < level && walk.c2 < level ) {
            if ( n[ walk.c1 - 1 ] == n[ walk.c2 - 1 ] )
               return true;
         }
         walk = walk.getNext();
      }
      return false;
   }

   public static void DFS( Tree sigma , Constraints con , int a[] , int vars , int colors ) {
      int count = 0 , count1 = 0;
      ArrayStack s = new ArrayStack();

      TNode temp1 = sigma.root();
      while ( temp1.hasSuccs() ) {
         for ( int i = 0 ; i < colors ; i++ )
            sigma.addNode( temp1, i, i + 1 , colors , 0 );
      }

      for( int i = sigma.root().succ.length - 1 ; i >= 0 ; i-- )
         s.push(sigma.root().succ[ i ]);

      while( !s.isEmpty() ) {
         count1++;
         TNode x = s.pop();
         if ( x.level < vars - 1 ) {
            while ( x.hasSuccs() ) {
               for ( int j = 0 ; j < colors ; j++ )
                  sigma.addNode( x, j, j + 1 , colors , x.level + 1);
            }
         }

         if( x.visited() == false ) {
            a[ x.level ] = x.element;

            if ( x.level == a.length - 1 ) {
               count++;
               if ( satisfiesCons( a , con ) ) {
                  System.out.println( "Number of complete states/assignments reached: " +  count );
                  System.out.println( "Number of nodes expanded: " +  count1 );
                  return;
               }
            }
            else if ( forwardCheck ( a , con , x.level ) ) {
               continue;
            }
            x.visit();
            for( int i = x.succ.length - 1 ; i >= 0 ; i-- )
               if( x.succ[i] != null )
                  if ( !(x.succ[i].visited() ) )
                     s.push(x.succ[i]);
         }
      }
      System.out.println( "Number of complete states/assignments reached: " +  count );
      System.out.println( "Number of nodes expanded: " +  count1 );
      for( int i = 0 ; i < a.length ; i++ )
         a[i] = -1;
      return;
   }

   public static void main ( String args[] ) throws FileNotFoundException {

      Scanner scan = new Scanner( System.in );
      System.out.println( "Enter the name of the file to take input from" );
      String fileName = scan.nextLine();
      File inputFile = new File( fileName );
      Scanner fileScan = new Scanner( inputFile );

      if ( fileScan.hasNext() ) ;
      else {
         scan.close();
         fileScan.close();
         System.out.println( "The file could not be opened or has no data." );
         return;
      } // end else

      int numVars = fileScan.nextInt();
      int numEdges = fileScan.nextInt();
      int numColors = fileScan.nextInt();
      int consFreq[] = new int [ numVars + 1 ];

      Constraints cons = new Constraints();
      for( int i = 1 ; i <= numEdges ; i++ ) {
         int c1 = fileScan.nextInt();
         int c2 = fileScan.nextInt();
         cons.addNode(c1, c2);
         consFreq[ c1 ]++;
         consFreq[ c2 ]++;
      }

      scan.close();
      fileScan.close();

      int test[] = new int[numVars];

      long iteration = (long) Math.pow( numColors , numVars );
      System.out.println( "There are " + iteration + " possible states (SIGMA) , albeit not all correct." );

      TNode root = new TNode( -1 , null , numColors , -1 );
      Tree mytree = new Tree( root );

      DFS( mytree , cons , test , numVars , numColors);
      Node answer = new Node( test );

      if( test[0] == -1 )
         System.out.println( "No answer was found" );
      else
         System.out.println( "Found an Answer:\n" + answer );

   }
}

/*

*/