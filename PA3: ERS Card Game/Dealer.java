import java.util.LinkedList;
public class Dealer{
    public Deck m_deck;

    //default constuctor
    public Dealer(){
        m_deck = new Deck();
    }

    //copy constructor
    public Dealer(Deck copyDeck){
        m_deck = copyDeck;
    }

    //deals method
    public LinkedList<Card> deals(int n){
        LinkedList<Card> hand = new LinkedList<Card>();
        for(int i=0; i < n; i++){

            int cardPosition = (int)(Math.random()*m_deck.cards.size());
            hand.add(m_deck.cards.get(cardPosition));
            m_deck.cards.remove(cardPosition);
        }

        return hand;
    }

    //size method
    public int size(){
        return m_deck.cards.size();
    }

    //toString method
    public String toString(){
        return m_deck.cards.toString();
    }
}