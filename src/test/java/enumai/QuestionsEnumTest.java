package enumai;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class QuestionsEnumTest {

    @Test
    void TestGetMaxNumberValue() {
        assertThat(QuestionsEnum.getMaxNumberValue()).isEqualTo(15);
    }

    @Test
    void TestGetWinningsByQuestionNumber() {
        assertThat(QuestionsEnum.getWinningsByQuestionNumber(5)).isEqualTo(1000);
    }
}