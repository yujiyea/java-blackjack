package blackjack;

public class Card {
    private final CardNumber number;
    private final CardPattern pattern;

    public Card(CardNumber number, CardPattern pattern) {
        this.number = number;
        this.pattern = pattern;
    }

    public String getNumber() {
        return number.getName();
    }

    public CardPattern getPattern() {
        return pattern;
    }
}
