package QA;

import lombok.Data;

import java.util.Objects;

@Data
public class Answers implements Comparable<Answers> {
    private String answer;
    private boolean correct;
    private int audiencePercentages;

    public Answers(String answer, boolean correct) {
        this.answer = answer;
        this.correct = correct;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean isCorrect() {
        return correct;
    }

    @Override
    public int compareTo(Answers answerToCompare) {
        return audiencePercentages - answerToCompare.getAudiencePercentages();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answers answers = (Answers) o;
        return correct == answers.correct && audiencePercentages == answers.audiencePercentages && Objects.equals(answer, answers.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answer, correct, audiencePercentages);
    }
}
