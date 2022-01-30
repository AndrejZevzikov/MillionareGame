package QA;

import lombok.Data;

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
}
