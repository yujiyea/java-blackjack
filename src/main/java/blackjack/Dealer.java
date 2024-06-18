package blackjack;

import java.util.List;
import java.util.function.Predicate;

public class Dealer extends User {

    public Dealer(List<Card> cardList) {
        this.cardList = cardList;
    }

    @Override
    public List<Card> showCardList(Predicate<String> conditional) {
        return cardList.subList(0,1);
    }
}
