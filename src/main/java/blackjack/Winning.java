package blackjack;

import java.util.function.Predicate;

public class Winning {
    public static void checkWinner(Dealer dealer, Player player) {
        int dealerResult = dealer.getBestResult();
        int playerResult = player.getBestResult();

        Predicate<Integer> isDealerBusted = result -> result > 21;
        Predicate<Integer> isDealerWin = result -> !isDealerBusted.test(result) && (result > playerResult);

        if (isDealerWin.test(dealerResult)) {
            dealer.win();
            return;
        }
        dealer.lose();
        player.setWinStatus();
    }
}
