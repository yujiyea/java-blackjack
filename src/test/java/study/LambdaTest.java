package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

class LambdaTest {
    private List<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = List.of(1, 2, 3, 4, 5, 6);
    }

    @Test
    void sumAll() {
        final int result = sumAll(numbers);
        assertThat(result).isEqualTo(21);
    }

    @Test
    void sumAllOverThree() {
        final int result = sumAll(numbers, numbers -> numbers>3);
        assertThat(result).isEqualTo(15);
    }

    @Test
    void sumAllEven() {
        final int result = sumAllEven(numbers);
        assertThat(result).isEqualTo(12);
    }

    private int sumAll(List<Integer> numbers) {
        return sumAll(numbers, number -> true);
    }

    private int sumAllEven(List<Integer> numbers) {
        return sumAll(numbers, number -> number %2==0);
    }

    private int sumAll(List<Integer> numbers, Predicate<Integer> conditional) { //=> sumAll, sumALLEven 둘다 이걸 사용할 수 있음
        return numbers.stream()
                .filter(conditional).reduce(0, Integer::sum);
    }
}

interface Conditional{
    boolean test(int number);
}
