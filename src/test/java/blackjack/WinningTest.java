package blackjack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningTest {

    @Test
    @DisplayName("딜러의 카드 합이 21이하이고 플레이어보다 크면 딜러가 승리한다.")
    void dealer_win() {
        Dealer dealer = new Dealer(List.of (
                new Card(CardNumber.THREE, CardPattern.CLOVER),
                new Card(CardNumber.FIVE, CardPattern.HEART)
        ));
        Player player = new Player(java.util.List.of (
                new Card(CardNumber.FOUR, CardPattern.CLOVER),
                new Card(CardNumber.TWO, CardPattern.HEART)
        ), "jackson");
        Winning.checkWinner(dealer, player);
        assertThat(dealer.getWinCount()).isEqualTo(1);
        assertThat(player.getWinStatus()).isFalse();
    }

    @Test
    @DisplayName("딜러의 카드 합이 21초과이면 플레이어가 승리한다.")
    void player_win() {
        Dealer dealer = new Dealer(List.of (
                new Card(CardNumber.JACK, CardPattern.CLOVER),
                new Card(CardNumber.FIVE, CardPattern.HEART),
                new Card(CardNumber.TEN, CardPattern.HEART)
        ));
        Player player = new Player(java.util.List.of (
                new Card(CardNumber.THREE, CardPattern.CLOVER),
                new Card(CardNumber.TWO, CardPattern.HEART)
        ), "jackson");
        Winning.checkWinner(dealer, player);
        assertThat(dealer.getWinCount()).isEqualTo(0);
        assertThat(player.getWinStatus()).isTrue();
    }

    @Test
    @DisplayName("플레이어와 딜러의 카드 합이 동일하면 플레이어가 승리한다.")
    void equals_card_sum_player_win() {
        Dealer dealer = new Dealer(List.of (
                new Card(CardNumber.THREE, CardPattern.CLOVER),
                new Card(CardNumber.TWO, CardPattern.HEART)
        ));
        Player player = new Player(java.util.List.of (
                new Card(CardNumber.THREE, CardPattern.CLOVER),
                new Card(CardNumber.TWO, CardPattern.HEART)
        ), "jackson");
        Winning.checkWinner(dealer, player);
        assertThat(dealer.getWinCount()).isEqualTo(0);
        assertThat(player.getWinStatus()).isTrue();
    }

    @Test
    @DisplayName("플레이어의 카드 합이 21을 초과하고 딜러의 카드합이 21이하이면 딜러가 승리한다.")
    void player_burst_and_dealer_win() {
        Dealer dealer = new Dealer(List.of (
                new Card(CardNumber.THREE, CardPattern.CLOVER),
                new Card(CardNumber.TWO, CardPattern.HEART)
        ));
        Player player = new Player(java.util.List.of (
                new Card(CardNumber.TEN, CardPattern.CLOVER),
                new Card(CardNumber.QUEEN, CardPattern.CLOVER),
                new Card(CardNumber.TWO, CardPattern.HEART)
        ), "jackson");
        Winning.checkWinner(dealer, player);
        assertThat(dealer.getWinCount()).isEqualTo(1);
        assertThat(player.getWinStatus()).isFalse();
    }
}