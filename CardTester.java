/**
 * This is a class that tests the Card class.
 *
 *  Briana Berger
 *  06/09/2018
 */

public class CardTester
{
   /**
    * The main method in this class checks the Card operations for consistency.
    * @param args is not used.
    */
   public static void main(String[] args) {

      /* *** TO BE IMPLEMENTED IN ACTIVITY 1 *** */

      // Establish new cards
      Card aceHearts = new Card("ace", "hearts", 1);
      Card tenHearts = new Card("10", "hearts", 10);
      Card fourSpades = new Card("4", "spades", 4);

      // Test card 1 and methods
      System.out.println("**** Tests Card 1: ace of hearts ****");
      System.out.println("  rank: " + aceHearts.rank());
      System.out.println("  suit: " + aceHearts.suit());
      System.out.println("  pointValue: " + aceHearts.pointValue());
      System.out.println("  toString: " + aceHearts.toString());
      System.out.println();

      // Test card 2
      System.out.println("**** Tests Card 2: 10 of hearts ****");
      System.out.println("  rank: " + tenHearts.rank());
      System.out.println("  suit: " + tenHearts.suit());
      System.out.println("  pointValue: " + tenHearts.pointValue());
      System.out.println("  toString: " + tenHearts.toString());
      System.out.println();

      // Test card 3
      System.out.println("**** Tests Card 3: 4 of spades ****");
      System.out.println("  rank: " + fourSpades.rank());
      System.out.println("  suit: " + fourSpades.suit());
      System.out.println("  pointValue: " + fourSpades.pointValue());
      System.out.println("  toString: " + fourSpades.toString());
      System.out.println();
      
      // Test matches() method
      System.out.println("**** Testing Matches Between Card 1 and Card 2 ****");
      boolean equality = aceHearts.matches(tenHearts);
      System.out.println("Matching: " + equality);
   }
}
