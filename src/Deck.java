import java.util.*;

public class Deck {
        private List<Card> cards;

        public Deck() {
                cards = new ArrayList<>();
                for (Suit suit: Suit.values()) {
                        for (Rank rank: Rank.values()) {
                                Card card = new Card(rank, suit);
                                cards.add(card);
                        }
                }
        }

        public void shuffle() {
                Collections.shuffle(cards);
        }

        public Card dealCard() {
                if (cards.isEmpty()) {
                        throw new IllegalStateException("No cards left in the deck");
                }
                return cards.remove(cards.size() - 1);
        }

        @Override
        public String toString() {
                String a = "Deck: \n";
                for (int i = 0; i < this.cards.size(); i++) {
                        a += this.cards.get(i).toString() + " ";
                }
                return a;
        }

}
