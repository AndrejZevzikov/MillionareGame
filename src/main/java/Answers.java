import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Answers {
    private String answer;
    private boolean correct;

    public String getAnswer() {
        return answer;
    }

    public boolean isCorrect() {
        return correct;
    }
}
