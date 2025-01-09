import java.util.*;
public class PokerGame {
        
        public static void main(String[] args) {
                PokerGame game = new PokerGame();
                game.start();
        }

        private Deck deck;
        private List<Player> players;
        private static final int HAND_SIZE = 2;
        private static final int COMMUNITY_CARDS = 5;

        public PokerGame() {
                this.deck = new Deck();
                this.players = new ArrayList<>();
        }

        public void start() {

                for (int i = 0; i < 2; i ++) {
                        String a = "Player" + i;
                        players.add(new Player(a)); 
                }

                deck.shuffle();

                for (Player player : players) {
                        for (int i = 0; i < HAND_SIZE; i++) {
                                player.addCard(deck.dealCard());
                        }
                }

                System.out.println("\nPlayers' Hands:");
                for (Player player : players) {
                        System.out.println(player);
                }

        }

        public void demo() {
                System.out.println(deck.toString());
                deck.shuffle();
                System.out.println(deck.toString());
        }


}
