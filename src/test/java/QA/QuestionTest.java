package QA;

import builders.QuestionBuilder;
import enumai.GameDifficult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {
    Question question;
    @BeforeEach
    void setUp(){
        question = new QuestionBuilder()
                .setQuestion("Kiek bus du kart du?")
                .setDifficult(GameDifficult.VERY_EASY)
                .setAnswer("4",true)
                .setAnswer("5",false)
                .setAnswer("2",false)
                .setAnswer("6",false)
                .build();
    }

    @Test
    void TestIsAnswerCorrect() {
        assertTrue(question.isAnswerCorrect(new Answers("4",true)));
        assertFalse(question.isAnswerCorrect(new Answers("6",false)));
    }

    @Test
    void testUseFiftyFifty() {
        assertThat(question.getAnswers().size()).isEqualTo(4);
        question.useFiftyFifty();
        assertThat(question.getAnswers().size()).isEqualTo(2);
        assertThat(question.isAnswerCorrect(new Answers("4",true))).isTrue();

    }

}