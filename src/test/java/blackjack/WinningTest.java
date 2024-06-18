package blackjack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class WinningTest {

    @Test
    @DisplayName("딜러의 카드 합이 21이하이고 플레이어보다 크면 딜러가 승리한다.")
    void dealer_win() {
        Dealer dealer = new Dealer(List.of (
                new Card("1", CardPattern.CLOVER),
                new Card("5", CardPattern.HEART)
        ));
        Player player = new Player(java.util.List.of (
                new Card("1", CardPattern.CLOVER),
                new Card("2", CardPattern.HEART)
        ), "jackson");
        Winning.checkWinner(dealer, player);
        assertThat(dealer.getWinCount()).isEqualTo(1);
        assertThat(player.getWinStatus()).isFalse();
    }

    @Test
    @DisplayName("딜러의 카드 합이 21초과이면 플레이어가 승리한다.")
    void player_win() {
        Dealer dealer = new Dealer(List.of (
                new Card("5", CardPattern.CLOVER),
                new Card("J", CardPattern.HEART),
                new Card("10", CardPattern.HEART)
        ));
        Player player = new Player(java.util.List.of (
                new Card("1", CardPattern.CLOVER),
                new Card("2", CardPattern.HEART)
        ), "jackson");
        Winning.checkWinner(dealer, player);
        assertThat(dealer.getWinCount()).isEqualTo(0);
        assertThat(player.getWinStatus()).isTrue();
    }
}