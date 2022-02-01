
import QA.Question;
import dataPreparation.ListsConnector;
import services.GameProcess;
import services.QuestionsService;
import dataPreparation.ReadFile;
import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        List<Question> allQuestions = ListsConnector.generateFullList(
                ReadFile.generateQuestionsListFromFile("src/main/resources/VeryEasyQuestions"),
                ReadFile.generateQuestionsListFromFile("src/main/resources/EasyQuestions"),
                ReadFile.generateQuestionsListFromFile("src/main/resources/MediumQuestions"),
                ReadFile.generateQuestionsListFromFile("src/main/resources/HardQuestions"),
                ReadFile.generateQuestionsListFromFile("src/main/resources/ExtremeQuestions"));

        GameProcess gameProcess = new GameProcess(new QuestionsService(allQuestions));
        gameProcess.start();
    }
}