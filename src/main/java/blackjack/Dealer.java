package blackjack;

import java.util.List;
import java.util.function.Predicate;

public class Dealer extends User {

    private int winCount;
    private int loseCount;

    public Dealer(List<Card> cardList) {
        this.cardList = cardList;
    }

    @Override
    public List<Card> showCardList(Predicate<String> conditional) {
        return cardList.subList(0,1);
    }

    public void win() {
        winCount++;
    }

    public void lose() {
        loseCount--;
    }

    public int getWinCount() {
        return winCount;
    }

    public int getLoseCount() {
        return loseCount;
    }
}
