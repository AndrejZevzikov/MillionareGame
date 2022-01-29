
import java.util.List;
import java.util.Optional;

public class QuestionsService {

    List<Question> questionsList;

    public QuestionsService(List<Question> questionsList) {
        this.questionsList = questionsList;
    }

    private Optional<Question> getQuestionByDifficulty(String difficult) {
        return questionsList.stream()
                .filter(question -> question.getDifficult().equals(difficult))
                .findAny();
    }

    public void printQuestionForUserByDifficult(String difficult) {
        printQuestionAndAnswers(getQuestionByDifficulty(difficult).get());
    }

    private void printQuestionAndAnswers(Question question) {
        int i = 1;
        System.out.println(question.getQuestion());
        for (Answers answer : question.getAnswers()) {
            System.out.println(i + ". " + answer.getAnswer());
            i++;
        }
    }

}
