public class Card {
    public int value;
    public int suit;
   
    public static final int HEARTS = 0;
    public static final int SPADES = 1;
    public static final int CLUBS = 2;
    public static final int DIAMONDS = 3;
   
    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;
    public static final int ACE = 14;
   
    //default constructore creating Ace of Spades
    public Card() {
        value = 14; //Ace
        suit = 1; //Spades
    }
   
    //overloaded constructor
    public Card(int value, int suit) {
        this.value = value;
        this.suit = suit;
    }
   
    //copy constructor
    public Card(Card other) {
        this.value = other.value;
        this.suit = other.suit;
    }
   
    //toString method
    public String toString() {
        String suitString = "";
        String valueString = "";
   
        switch (suit) {
        case HEARTS:
            suitString = "Hearts";
        break;
        case SPADES:
            suitString = "Spades";
        break;
        case CLUBS:
            suitString = "Clubs";
        break;
        case DIAMONDS:
            suitString = "Diamonds";
        break;
        }
    
        switch (value) {
        case JACK:
            valueString = "Jack";
        break;
        case QUEEN:
            valueString = "Queen";
        break;
        case KING:
            valueString = "King";
        break;
        case ACE:
            valueString = "Ace";
        break;
        default:
            valueString = Integer.toString(value);
        break;
    }
   
        return valueString + " of " + suitString;
    }
   
    //equals method
    public boolean equals(Card other) {
        return this.value == other.value;
    }
   
    //mutators
    public int getValue() {
        return value;
    }
   
    public void setValue(int value) {
        this.value = value;
    }
   
    public int getSuit() {
        return suit;
    }
   
    public void setSuit(int suit) {
        this.suit = suit;
    }
   }
