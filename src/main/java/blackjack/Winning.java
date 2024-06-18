package blackjack;

import java.util.function.Predicate;

public class Winning {
    public static void checkWinner(Dealer dealer, Player player) {
        int dealerResult = dealer.getBestResult();
        int playerResult = player.getBestResult();

        Predicate<Integer> isDealerWin = result -> result <= 21 && (playerResult > 21 || result > playerResult);

        if (isDealerWin.test(dealerResult)) {
            dealer.win();
            return;
        }
        dealer.lose();
        player.setWinStatus();
    }
}
