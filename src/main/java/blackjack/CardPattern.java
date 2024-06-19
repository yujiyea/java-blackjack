package blackjack;

public enum CardPattern {
    HEART("하트"),
    DIAMOND("다이아몬드"),
    CLOVER("클로버"),
    SPADE("스페이드");


    private final String pattern;

    CardPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }
}
