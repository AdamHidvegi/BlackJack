import java.util.ArrayList;

public class Game {

    private ArrayList<Player> players;
    Deck deck;

    public Game() {
        this.players = new ArrayList<Player>();
        deck = new Deck();
    }

    public String whoWins(Dealer dealer, Player player) {
        if (dealer.getSumOfHand() > player.getSumOfHand()) {
//            return String.format("The winner is %s!", dealer.getName());
            return "The winner is me! Sorry, better luck next time!";
        }
        else if (dealer.getSumOfHand() == player.getSumOfHand()) {
            return "It's a draw, my friend. Let's play another one!";
        }
//        return String.format("The winner is %s!", player.getName());
        return "The winner is you! Good job!";
    }

}
