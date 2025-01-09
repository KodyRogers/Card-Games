import java.util.*;

public class Player {
        
        private String name;
        private List<Card> hand;

        public Player(String name) {
                this.name = name;
                this.hand = new ArrayList<>();
        }

        public void addCard(Card card) {
                hand.add(card);
        }

        @Override
        public String toString() {
                return name + "'s hand: " + hand;
        }

}
