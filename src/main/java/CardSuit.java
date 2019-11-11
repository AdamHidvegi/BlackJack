public enum CardSuit {

    HEARTS("Hearts"),
    SPADES("Spades"),
    CLUBS("Clubs"),
    DIAMONDS("Diamonds");

    private final String value;

    CardSuit(String value) {
        this.value = value;
    }

    public String getSuit() {
        return this.value;
    }

}
