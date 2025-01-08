/**
 * An enumerated type for the card suits.
 *
 * @author Kody Rogers
 */
public enum Suit {
    
    CLUB ("\u2667"),
    HEART("\u2665"),
    DIAMOND("\u2662"),
    SPADE("\u2660");

    private final String display;

    Suit(String display) {
        this.display = display;
    }

    @Override
    public String toString() {
        return this.display;
    }   
}
