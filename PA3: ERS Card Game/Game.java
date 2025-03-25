import java.util.LinkedList;

public class Game {
    private LinkedList<Player> players; // list of players in game
    private LinkedList<Card> pile; // pile of cards in game
    private Dealer dealer; // dealer object responsible for dealing cards
    private LinkedList<Player> playersToRemove; // list of players to be removed from game
    private String[] patterns = {"doubles", "top bottom", "sandwich"}; // array of patterns for special cards

    // constructor to initialize game with a specified number of players
    public Game(int numPlayers) {
        players = new LinkedList<>(); 
        pile = new LinkedList<>(); 
        playersToRemove = new LinkedList<>(); 

        // creates players and assigns random patterns to them
        for (int i = 1; i <= numPlayers; i++) {
            players.add(new Player(i, new LinkedList<>(), patterns[(int) (Math.random() * patterns.length)]));
        }
        dealer = new Dealer(); 
        dealCards(); // deal cards to players
    }

    // method to deal cards to players
    private void dealCards() {
        for (Player player : players) {
            LinkedList<Card> hand = dealer.deals(dealer.size() / players.size()); // deal cards evenly among players
            player.getHand().addAll(hand); // adds dealt cards to player's hand
        }
    }
    // method to start and play the game
    public int play() {
        System.out.println("Starting the game...");
        int turnCount = 1;
        /* BEGIN CODE FROM CHATGBT: PROMPT ASKED: "how do i make a while loop that stops after a certain number of turns?" */
        while (players.size() > 1 && turnCount <= 20) { // while loop continue game until there's only one player left or max turns reached
            System.out.println("Turn " + turnCount++);
            System.out.println("Number of players remaining: " + players.size());
            Player currentPlayer = players.getFirst(); // get current players
            System.out.println("Current player: " + currentPlayer);
            Card playedCard = currentPlayer.playCard(); // player plays a card
            if (playedCard == null) {
                players.removeFirst(); // removes player if they have no more cards
                System.out.println(currentPlayer + " has no more cards and is removed from the game.");
                continue;
            }
            /* END OF CODE FROM CHATGBT */
            
            pile.add(playedCard); // add played card to pile
            System.out.println(currentPlayer + " plays: " + playedCard);
            boolean faceCardPlayed = (playedCard.getValue() >= Card.JACK && playedCard.getValue() <= Card.ACE); //check if face card is played
            if (faceCardPlayed) {
                System.out.println("Face card played.");
                handleFaceCard(currentPlayer); 
            } else {
                System.out.println("Regular card played.");
                handleRegularCard(currentPlayer); 
            }
    
            printGamePlayRecord(); // prints current game state
            System.out.println("End of turn.");
        }
    
        if (players.size() == 1) {
            Player winner = players.getFirst();
            System.out.println("\nPlayer " + winner.getPlayerNum() + " wins the game!");
            return winner.getPlayerNum(); // returns the winner's number
        } else {
            Player winner = findWinnerByMostCards(); // find winner based on most cards if game ends due to max turns
            if (winner != null) {
                System.out.println("\nPlayer " + winner.getPlayerNum() + " wins the game!");
                return winner.getPlayerNum();
            } else {
                System.out.println("Game ended in a tie.");
                return -1; // indicates tie or no clear winner
            }
        }
    }
    
    // method to find the winner based on the most cards if game ends due to max turns
    private Player findWinnerByMostCards() {
        Player winner = null;
        int maxCards = -1;
        for (Player player : players) {
            int numCards = player.getHand().size();
            if (numCards > maxCards) {
                maxCards = numCards;
                winner = player;
            } else if (numCards == maxCards) {
                return null; // returns null in case of a tie
            }
        }
        return winner;
    }

    // method to print the current game state
    private void printGamePlayRecord() {
        System.out.println("Current pile: " + pile);
        System.out.println("Players:");
        for (Player player : players) {
            System.out.println(player);
        }
        System.out.println();
    }

    // method to handle actions for face cards
    private void handleFaceCard(Player currentPlayer) {
        LinkedList<Card> hand = currentPlayer.getHand();
        if (hand.isEmpty()) {
            System.out.println(currentPlayer + "'s hand is empty!");
            playersToRemove.add(currentPlayer); // add player to removal list
            return;
        }
    
        int chances = getChances(hand.getFirst().getValue()); // calculate chances based on face card value
        Player nextPlayer = nextPlayer(currentPlayer); // get the next player
        boolean faceCardSlapped = false;
        for (int i = 0; i < chances && !hand.isEmpty(); i++) {
            Card nextCard = nextPlayer.playCard(); // next player plays a card
            if (nextCard == null) {
                System.out.println(nextPlayer + "'s hand is empty!");
                playersToRemove.add(nextPlayer); // adds player to removal list
                break;
            }
            pile.add(nextCard);
            System.out.println(nextPlayer + " plays: " + nextCard);
            if (nextCard.getValue() >= Card.JACK && nextCard.getValue() <= Card.ACE) {
                System.out.println(nextPlayer + " plays a face card! No slap opportunity.");
                faceCardSlapped = true;
                break;
            }
        }
        if (!faceCardSlapped) {
            currentPlayer.getHand().addAll(pile);
            pile.clear();
            System.out.println(currentPlayer + " wins the face card round!");
        }
    }

    // method to handle actions for regular cards
    private void handleRegularCard(Player currentPlayer) {
        Player nextPlayer = nextPlayer(currentPlayer);
        Card topCard = pile.getLast();
        boolean slapped = nextPlayer.slaps(pile); // check if next player slaps the pile
        if (slapped) {
            nextPlayer.getHand().addAll(pile);
            pile.clear();
            System.out.println(nextPlayer + " slaps and wins the pile!");
        } else {
            System.out.println(nextPlayer + " misses the slap!");
            if (nextPlayer.getHand().isEmpty()) {
                playersToRemove.add(nextPlayer); // add player to removal list
                players.remove(nextPlayer); // remove player from game
                System.out.println(nextPlayer + " has no more cards and is removed from the game.");
                if (players.size() == 1) {
                    return;
                }
            }
        }
    
        players.removeAll(playersToRemove); // remove players from the removal list
        playersToRemove.clear(); // clear the removal list for the next round
    }
    

    // method to calculate chances based on face card value
    private int getChances(int cardValue) {
        if (cardValue >= Card.JACK && cardValue <= Card.ACE) {
            return cardValue - Card.JACK + 1;
        }
        return 0;
    }

    // method to get the next player in the player list
    private Player nextPlayer(Player currentPlayer) {
        int currentIndex = players.indexOf(currentPlayer);
        int nextIndex = (currentIndex + 1) % players.size();
        return players.get(nextIndex);
    }

    public LinkedList<Player> getPlayers() {
        return players;
    }

    public LinkedList<Card> getPile() {
        return pile;
    }

    public Dealer getDealer() {
        return dealer;
    }

    // static methods to check for special patterns
    public static boolean topBottom(LinkedList<Card> pile) {
        return pile.getFirst().equals(pile.getLast());
    }

    public static boolean doubles(LinkedList<Card> pile) {
        return pile.size() >= 2 && pile.get(pile.size() - 1).equals(pile.get(pile.size() - 2));
    }

    public static boolean sandwich(LinkedList<Card> pile) {
        return pile.size() >= 3 && pile.get(pile.size() - 3).equals(pile.get(pile.size() - 1));
    }
}
