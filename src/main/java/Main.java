import java.io.*;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException {

        List<Question> questions = ReadFile.generateQuestionsListFromFile("src/main/resources/EasyQuastions");

        QuestionsService questionsService = new QuestionsService(questions);
        questionsService.printQuestionForUserByDifficult("Medium");

    }
}
