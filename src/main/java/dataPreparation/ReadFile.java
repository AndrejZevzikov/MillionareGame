package dataPreparation;

import QA.Answers;
import QA.Question;
import enumai.GameDifficult;

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
            answers.add(new Answers(tempArray[1], true));
            answers.add(new Answers(tempArray[2], false));
            answers.add(new Answers(tempArray[3], false));
            answers.add(new Answers(tempArray[4], false));
            questionsList.add(new Question(tempArray[0], answers, generateDifficult(path)));
            text = reader.readLine();
        }
        return questionsList;
    }

    private static GameDifficult generateDifficult(String path) {
        if (path.contains("/VeryEasy")) {
            return GameDifficult.VERY_EASY;
        } else if (path.contains("/Easy")) {
            return GameDifficult.EASY;
        } else if (path.contains("/Medium")) {
            return GameDifficult.MEDIUM;
        } else if (path.contains("/Hard")) {
            return GameDifficult.HARD;
        } else if (path.contains("/Extreme")) {
            return GameDifficult.EXTREME;
        } else {
            return null;
        }
    }
}
