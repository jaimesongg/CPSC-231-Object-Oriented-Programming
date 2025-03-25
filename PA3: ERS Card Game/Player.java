import java.util.LinkedList;

public class Player {
    private int playerNum;
    private LinkedList<Card> hand;
    private String pattern;

    // overloaded method
    public Player(int playerNum, LinkedList<Card> hand, String pattern) {
        this.playerNum = playerNum;
        this.hand = hand;
        this.pattern = pattern;
    }

    public Card playCard() {
        if (!hand.isEmpty()) { // checks if hand is not emptu
            return hand.removeFirst(); //removes and returns first card in the hand
        }
        return null; // returns null if the hand is empty
    }

    // method for a player to slap the pile based on their pattern
    public boolean slaps(LinkedList<Card> pile) {
        switch (pattern) {
            case "doubles":
                return Game.doubles(pile);
            case "top bottom":
                return Game.topBottom(pile);
            case "sandwich":
                return Game.sandwich(pile);
            default:
                return false;
        }
    }

    public int getPlayerNum() {
        return playerNum;
    }

    public LinkedList<Card> getHand() {
        return hand;
    }

    public String getPattern() {
        return pattern;
    }

    @Override
    public String toString() {
        return "Player " + playerNum + " (" + pattern + "): " + hand;
    }
}
