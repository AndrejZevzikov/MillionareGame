import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class Question {

    private String question;
    private Set<Answers> answers;
    private String difficult;

    public boolean isAnswerCorrect(Answers answer){
        return answers.stream()
                .filter(answers1 -> answers1.equals(answer))
                .findAny().get().isCorrect();
    }



}
