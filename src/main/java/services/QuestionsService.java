package services;

import QA.Answers;
import QA.Question;
import enumai.GameDifficult;
import helpers.Helper;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class QuestionsService {

    List<Question> questionsList;

    public QuestionsService(List<Question> questionsList) {
        this.questionsList = questionsList;
    }

    public Question getQuestionByDifficulty(GameDifficult difficult) {
        Random random = new Random();
        List<Question> sortedQuestions = questionsList.stream()
                .filter(question -> question.getDifficult().equals(difficult))
                .collect(Collectors.toList());
        return sortedQuestions.get(random.nextInt(sortedQuestions.size()-1));
    }

    public void removeQuestionFromList(Question question) {
        for (Question question1 : questionsList) {
            if (question1.equals(question)) {
                questionsList.remove(question);
                break;
            }
        }
    }

    public void printQuestionAndAnswers(Question question) {
        int i = 1;
        System.out.println(question.getQuestion());
        for (Answers answer : question.getAnswers()) {
            System.out.println(i + ". " + answer.getAnswer());
            i++;
        }
    }

    public void useHelper(Question question, Helper helper) {
        if (helper.getName().equalsIgnoreCase("50/50")) {
            question.useFiftyFifty();
        } else if (helper.getName().equalsIgnoreCase("Friend Call")) {
            question.useFriendCall();
        } else if (helper.getName().equalsIgnoreCase("Audience help")) {
            question.useAudienceHelp();
            question.printAudienceVotingResults();
        }
        helper.setActive(false);
    }
}