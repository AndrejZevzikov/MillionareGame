
import QA.Question;
import services.GameProcess;
import services.QuestionsService;
import services.ReadFile;

import java.io.*;

import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException {

        List<Question> questions = ReadFile.generateQuestionsListFromFile("src/main/resources/EasyQuastions");
        GameProcess gameProcess = new GameProcess(new QuestionsService(questions));
        gameProcess.start();

        System.out.println(gameProcess.getSafeAmountOfWinnings());





    }
}
