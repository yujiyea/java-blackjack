package blackjack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @Test
    @DisplayName("플레이어와 딜러는 게임 시작 시 두 장의 카드를 받는다.")
    void user_draws_card() {
        Player player = new Player("jackson");
        Deck deck = new Deck();
        player.receiveCard(deck);
        player.receiveCard(deck);
        assertThat(player.getCardList()).hasSize(2);
    }

    @Test
    @DisplayName("딜러는 항상 자신의 첫번째 카드를 보여준다.")
    void dealer_show_cardList(){
        Dealer dealer = new Dealer(List.of (
                new Card("1", CardPattern.CLOVER),
                new Card("2", CardPattern.HEART)
        ));
        List<Card> cardList = dealer.showCardList(name -> name.equals("딜러"));
        assertThat(cardList).hasSize(1);
    }

    @Test
    @DisplayName("플레이어는 항상 자신의 모든 카드를 보여준다.")
    void player_show_cardList(){
        Player player = new Player(java.util.List.of (
                new Card("1", CardPattern.CLOVER),
                new Card("2", CardPattern.HEART)
        ), "jackson");
        List<Card> cardList = player.showCardList(name -> name.equals("딜러"));
        assertThat(cardList).hasSize(2);
    }

    @Test
    @DisplayName("플레이어의 현재 카드의 합이 21이하인지 여부를 판단한다.")
    void user_card_sum_is_down_to_21() {
        Player player = new Player(java.util.List.of (
            new Card("1", CardPattern.CLOVER),
            new Card("2", CardPattern.HEART)
        ), "jackson");
        Boolean receivable = player.receivable(21);
        assertThat(receivable).isTrue();
    }

    @Test
    @DisplayName("딜러의 현재 카드의 합이 16이하인지 여부를 판단한다.")
    void user_card_sum_is_down_to_16() {
        Dealer dealer = new Dealer(java.util.List.of (
                new Card("10", CardPattern.CLOVER),
                new Card("A", CardPattern.HEART)
        ));
        Boolean receivable = dealer.receivable(16);
        assertThat(receivable).isTrue();
    }

    @ParameterizedTest
    @DisplayName("유저의 카드 합을 더해서 최적의 결과 값을 도출한다.")
    @MethodSource("generateData")
    void user_best_result(User user, int result){
        int bestResult = user.getBestResult();

        assertThat(bestResult).isEqualTo(result);
    }


    static Stream<Arguments> generateData(){
        return Stream.of(
                Arguments.of(new Player(List.of (
                        new Card("10", CardPattern.CLOVER),
                        new Card("5", CardPattern.HEART),
                        new Card("A", CardPattern.CLOVER)
                ), "jackson"), 16),
                Arguments.of(new Player(List.of (
                        new Card("10", CardPattern.CLOVER),
                        new Card("J", CardPattern.HEART),
                        new Card("Q", CardPattern.CLOVER)
                ), "suzy"), 30)
        );
    }
}