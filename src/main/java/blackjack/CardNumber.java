package blackjack;

public enum CardNumber {
    ACE("A"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10"),
    QUEEN("Q"),
    JACK("J"),
    KING("K");

    private final String name;

    CardNumber(String value) {
        this.name = value;
    }

    public String getName() {
        return name;
    }
}
