package blackjack;

public class Card {
    private final String number;
    private final CardPattern pattern;

    public Card(String number, CardPattern pattern) {
        this.number = CardNumber.from(number);
        this.pattern = pattern;
    }

    public String getNumber() {
        return number;
    }

    public CardPattern getPattern() {
        return pattern;
    }
}
