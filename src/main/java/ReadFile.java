import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReadFile {

    public static List<Question> generateQuestionsListFromFile(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        List<Question> questionsList = new ArrayList<>();

        String text = reader.readLine();

        while (text != null) {
            String[] tempArray = text.split(",");
            Set<Answers> answers = new HashSet<>();
            answers.add(new Answers(tempArray[1],true));
            answers.add(new Answers(tempArray[2],false));
            answers.add(new Answers(tempArray[3],false));
            answers.add(new Answers(tempArray[4],false));
            questionsList.add(new Question(tempArray[0],answers,tempArray[5]));
            text = reader.readLine();
        }
        return questionsList;
    }
}
