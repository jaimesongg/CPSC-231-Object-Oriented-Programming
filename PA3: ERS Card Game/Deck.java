import java.util.LinkedList;
import java.util.Random;

public class Deck {
    public LinkedList<Card> cards;

    public Deck() {
        cards = new LinkedList<Card>();

        for (int suit = 0; suit < 4; suit++) {
            for (int value = 2; value < 15; value++) {
                cards.add(new Card(value, suit));
            }
        }
    }

    public Deck(Deck other) {
        cards = new LinkedList<Card>();
        for (Card card : other.cards) {
            cards.add(new Card(card));
        }
    }

    public String toString() {
    String output = "";

        for (Card card : cards) {
            output += card.toString() + "\n";
        }
        return output;
    }

    public int size() {
        return cards.size();
    }

    public Card deal() {
        Random randy = new Random();
        int index = randy.nextInt(cards.size());
        return cards.remove(index);
    }
}
