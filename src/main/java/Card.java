public class Card {

    private CardSuit suit;
    private CardRank rank;

    public Card(CardSuit suit, CardRank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public int getRank() {
        return this.rank.getValue();
    }

    public String getSuit() {
        return this.suit.getSuit();
    }

}
