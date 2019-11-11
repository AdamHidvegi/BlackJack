import java.util.ArrayList;

public class Player {

//    private String name;
    private ArrayList<Card> playerHand;

    public Player() {
//        this.name = name;
        this.playerHand = new ArrayList<Card>();
    }

//    public String getName() {
//        return this.name;
//    }

    public int checkHand() {
        return this.playerHand.size();
    }

    public void addCardToHand(Card card) {
        this.playerHand.add(card);
    }

//    public int valueOfAce() {
//        int modifiedAce = 0;
//        if (this.getSumOfHand() < 21 && this.playerHand.contains(CardRank.ACE)) {
//            modifiedAce = CardRank.ACE.getSubValue();
//        }
//        return modifiedAce;
//    }

    public int getSumOfHand() {
        int sumOfNumbers = 0;
        for (Card card : this.playerHand) {
            sumOfNumbers += card.getRank();
        }
        return sumOfNumbers;
    }

    public int showFirstCardNumber() {
        return this.playerHand.get(0).getRank();
    }

    public int showSecondCardNumber() {
        return this.playerHand.get(1).getRank();
    }

    public String showFirstCardSuit() {
        return this.playerHand.get(0).getSuit();
    }

    public String showSecondCardSuit() {
        return this.playerHand.get(0).getSuit();
    }

    public String showThirdCardSuit() {
        return this.playerHand.get(2).getSuit();
    }

    public int showThirdCardNumber() {
        return this.playerHand.get(2).getRank();
    }

    public String showFourthCardSuit() {
        return this.playerHand.get(3).getSuit();
    }

    public int showFourthCardNumber() {
        return this.playerHand.get(3).getRank();
    }

}
