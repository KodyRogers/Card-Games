/**
 * An enumerated type for the card rank.
 *
 * @author Kody Rogers
 */
public enum Rank {
        ACE("A", 14),
        TWO("2", 2),
        THREE("3", 3),
        FOUR("4", 4),
        FIVE("5", 5),
        SIX("6", 6),
        SEVEN("7", 7),
        EIGHT("8", 8),
        NINE("9", 9),
        TEN("10", 10),
        JACK("J", 11),
        QUEEN("Q", 12),
        KING("K", 13);
        

        private final String display;
        private final int value;

        Rank(String display, int value) {
                this.display = display;
                this.value = value;
        }

        public int getValue() {
                return value;
        }

        @Override
        public String toString() {
                return this.display;
        }
        
}
