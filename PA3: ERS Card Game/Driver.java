public class Driver {
    public static void main(String[] args) {
        Game game = new Game(4);
        System.out.println("Starting game with " + game.getPlayers().size() + " players.");
        System.out.println("Players: " + game.getPlayers());
        System.out.println();

        int winner = game.play();
            

        System.out.println("\nPlayer " + winner + " wins the game!");
    }
}
