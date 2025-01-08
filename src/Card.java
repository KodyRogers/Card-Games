/**
 * Represents a single card in the game.
 *
 * @author Kody Rogers
 */

public class Card {

        private Rank rank;
        private Suit suit;

        public Card(Rank rank, Suit suit) {
                this.rank = rank;
                this.suit = suit;
        }

        @Override
        public String toString() {
                String a = rank.toString() + suit.toString();
                return a;
        }

        

}
