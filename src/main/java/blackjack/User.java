package blackjack;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public abstract class User {
    protected List<Card> cardList = new ArrayList<>();

    public void receiveCard(Deck deck) {
        Card card = deck.drawCard();
        cardList.add(card);
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public Boolean receivable(int value) {
        List<Integer> sum = getCardListSum();
        return sum.stream().anyMatch(s -> s < value);
    }

    public int getBestResult(){
        List<Integer> cardListSum = getCardListSum();
        cardListSum.sort(Comparator.reverseOrder());
        Optional<Integer> bestSum = cardListSum.stream().filter(sum -> sum <= 21).findFirst();
        if(bestSum.isEmpty()){
            return cardListSum.get(cardListSum.size()-1);
        }
        return bestSum.get();
    }

    private List<Integer> getCardListSum() {
        List<Integer> sum = new ArrayList<>();
        sum.add(0);

        for (Card card : cardList) {
            sum = plusCardNumberOption(sum, card);
        }
        return sum;
    }


    private static List<Integer> plusCardNumberOption(List<Integer> sum, Card card) {
        List<Integer> newSums = new ArrayList<>();
        for (Integer s : sum) {
            if (card.getNumber().equals(CardNumber.from("A"))) {
                newSums.add(s + 1);
                newSums.add(s + 11);
                continue;
            }
            if (card.getNumber().equals(CardNumber.from("J")) ||
                    card.getNumber().equals(CardNumber.from("Q")) ||
                    card.getNumber().equals(CardNumber.from("K"))) {
                newSums.add(s + 10);
                continue;
            }
            newSums.add(s + Integer.parseInt(card.getNumber()));
        }
        return newSums;
    }


    public  abstract  List<Card> showCardList(Predicate<String> conditional);
}
