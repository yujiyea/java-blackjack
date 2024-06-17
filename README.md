# java-blackjack

## 기능 목록
- [X] 카드는 숫자와 문양을 갖는다.
  - [ ] ACE는 1 또는 11로 계산한다.
  - [ ] King, Queen, Jack은 각각 10으로 계산한다.
- [X] 덱은 카드 52개 가진다. 
  - [ ] [덱은 숫자와 문양 조합 카드를 13개씩 갖는다.]
- [ ] 덱에서 카드를 랜덤으로 뽑아라 -> dealer.receive() -> deck.draw(random) -> random.nextInt()(바꿔야함)
- [X] 덱에서 랜덤으로 카드를 뽑아서 지우면 덱은 카드 한 장을 잃는다.
- [X] 플레이어와 딜러는 게임 시작 시 두 장의 카드를 받는다.
- [ ] 플레이어의 현재 카드의 합이 21초과인지 여부를 판단한다.
- [ ] 딜러의 현재 카드의 합이 16이하인지 여부를 판단한다.
- [ ] 카드의 합이 21초과일 경우 Burst이다. 
- [ ] 딜러가 Burst일 경우 Burst가 아닌 플레이어가 승리한다.
- [ ] 딜러와 플레이어 모두 Burst일 경우 무승부이다.
- [ ] 플레이어와 딜러의 결과가 동일하면 무승부이다.
- [ ] 플레이어가 딜러보다 높은 수일 경우 플레이어가 승리한다.
- [ ] 딜러가 플레이어보다 높은 수일 경우 딜러가 승리한다.