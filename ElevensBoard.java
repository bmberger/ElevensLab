import java.util.List;
import java.util.ArrayList;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 *
 *
 *  < Briana Berger >
 *  < 04/10/2018 >
 */

public class ElevensBoard extends Board
{
   //  The size (number of cards) on the board.
   private static final int BOARD_SIZE = 9;

   // The ranks of the cards for this game to be sent to the deck.
   private static final String[] RANKS =
      {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

   // The suits of the cards for this game to be sent to the deck.
   private static final String[] SUITS =
      {"spades", "hearts", "diamonds", "clubs"};

   // The values of the cards for this game to be sent to the deck.
   private static final int[] POINT_VALUES =
      {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};

   /**
    * Creates a new ElevensBoard instance.
    */
   public ElevensBoard() 
   {
       super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
   }

   /**
    * Determines if the selected cards form a valid group for removal.
    * In Elevens, the legal groups are (1) a pair of non-face cards
    * whose values add to 11, and (2) a group of three cards consisting of
    * a jack, a queen, and a king in some order.
    * @param selectedCards the list of the indices of the selected cards.
    * @return true if the selected cards form a valid group for removal;
    *         false otherwise.
    */
   public boolean isLegal(List<Integer> selectedCards)
   {
       /*boolean temp = true;
       if(selectedCards.size() == 2)
       {
           if(POINT_VALUES[selectedCards.get(0)] + POINT_VALUES[selectedCards.get(1)] == 11)
           {
               return true;
           }
       }
       else if(selectedCards.size() == 3)
       {
           for(int i = 0; i < selectedCards.size(); i++)
           {
               if(!(RANKS[selectedCards.get(i)].equals("jack") || RANKS[selectedCards.get(i)].equals("queen") || RANKS[selectedCards.get(i)].equals("king")))
               {
                   return false;
               }
           }
           return true;
       }
       return false;*/
       if (selectedCards.size() == 2) 
       {
           return containsPairSum11(selectedCards);
       }
       else if (selectedCards.size() == 3) 
       {
           return containsJQK(selectedCards);
       }
       return false;
   }

   /**
    * Determine if there are any legal plays left on the board.
    * In Elevens, there is a legal play if the board contains
    * (1) a pair of non-face cards whose values add to 11, or (2) a group
    * of three cards consisting of a jack, a queen, and a king in some order.
    * @return true if there is a legal play left on the board;
    *         false otherwise.
    */
   public boolean anotherPlayIsPossible() {
      return containsJQK(cardIndexes()) || containsPairSum11(cardIndexes());
   }

   /**
    * Check for an 11-pair in the selected cards.
    * @param selectedCards selects a subset of this board.  It is list
    *                      of indexes into this board that are searched
    *                      to find an 11-pair.
    * @return true if the board entries in selectedCards
    *              contain an 11-pair; false otherwise.
    */
   private boolean containsPairSum11(List<Integer> selectedCards)
   {
       for (int i = 0; i < selectedCards.size() - 1; i++)
       {
           for (int j = i + 1; j < selectedCards.size(); j++) 
           {
               if (cardAt(selectedCards.get(i)).pointValue() + cardAt(selectedCards.get(j)).pointValue() == 11)
               {
                   return true;
	       }
	   }
       }
       return false;
   }

   /**
    * Check for a JQK in the selected cards.
    * @param selectedCards selects a subset of this board.  It is list
    *                      of indexes into this board that are searched
    *                      to find a JQK group.
    * @return true if the board entries in selectedCards
    *              include a jack, a queen, and a king; false otherwise.
    */
   private boolean containsJQK(List<Integer> selectedCards)
   {
       boolean J = false;
       boolean Q = false;
       boolean K = false;
       for(int i = 0; i < selectedCards.size(); i++)
       {
           if (cardAt(selectedCards.get(i)).rank().equals("jack"))
           {
               J = true;
           }
	   if (cardAt(selectedCards.get(i)).rank().equals("queen"))
	   {
	       Q = true;
	   }
	   if (cardAt(selectedCards.get(i)).rank().equals("king"))
	   {
	       K = true;
	   }
       }
       return (J && Q && K);
   }
}
