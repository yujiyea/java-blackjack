package blackjack;

import java.util.Arrays;

public class CardNumber {
    private static final String[] cardNumbers = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};

    public static String from(String value){
        return Arrays.stream(cardNumbers).filter(i-> i.equals(value)).findFirst().orElseThrow(IllegalArgumentException::new);
    }

    public static String[] getCardNumbers() {
        return cardNumbers;
    }


}
