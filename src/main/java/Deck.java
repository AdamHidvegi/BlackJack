import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cards;


    public Deck() {
        this.cards = new ArrayList<Card>();
    }

    public int checkDeck() {
        return this.cards.size();
    }

    public void createDeck() {
        CardRank arrayOfRanks[] = CardRank.values();
        CardSuit arrayOfSuits[] = CardSuit.values();
        for (CardSuit suit : arrayOfSuits) {
            for (CardRank rank : arrayOfRanks) {
                Card card = new Card(suit, rank);
                this.cards.add(card);
            }
        }
    }

    public ArrayList<Card> getDeck() {
        return this.cards;
    }

    public void shuffleDeck() {
        Collections.shuffle(cards);
    }

    public boolean checkRandomCard() {
        Card option1 = this.cards.get(0);
        this.shuffleDeck();
        Card option2 = this.cards.get(0);
        if (option1 == option2) {
            return false;
        }
        return true;
    }

    public void dealCardToPlayer(Player player) {
        Card card1 = this.cards.get(0);
        Card card2 = this.cards.get(1);
        player.addCardToHand(card1);
        player.addCardToHand(card2);
        this.cards.remove(card1);
        this.cards.remove(card2);
    }

    public void dealCardToDealer(Dealer dealer) {
        Card card1 = this.cards.get(0);
        Card card2 = this.cards.get(1);
        dealer.addCardToHand(card1);
        dealer.addCardToHand(card2);
        this.cards.remove(card1);
        this.cards.remove(card2);
    }

//    public void dealCardToDealer() {
//        Card card1 = this.cards.get(0);
//        Card card2 = this.cards.get(1);
//        this.cards.remove(card1);
//        this.cards.remove(card2);
//    }

    public void dealOneCardToDealer(Dealer dealer) {
        Card card = this.cards.get(0);
        this.cards.remove(card);
        dealer.addCardToHand(card);
    }

    public void dealOneCardToPlayer(Player player) {
        Card card = this.cards.get(0);
        this.cards.remove(card);
        player.addCardToHand(card);
    }

}
