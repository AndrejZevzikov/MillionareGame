
import QA.Question;
import services.GameProcess;
import services.QuestionsService;
import services.ReadFile;
import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        List<Question> veryEasyQuestions = ReadFile.generateQuestionsListFromFile("src/main/resources/VeryEasyQuestions");
        List<Question> easyQuestions = ReadFile.generateQuestionsListFromFile("src/main/resources/EasyQuestions");

        List<Question> allQuestions = Stream.concat(veryEasyQuestions.stream(),easyQuestions.stream())
                .collect(Collectors.toList());

        GameProcess gameProcess = new GameProcess(new QuestionsService(allQuestions));
        gameProcess.start();
    }
}