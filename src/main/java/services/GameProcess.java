package services;

import Meniu.MeniuText;
import QA.Question;
import enumai.GameDifficult;
import enumai.QuestionsEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameProcess {

    private QuestionsService questionsService;
    private int questionsCount = 0;
    private int safeAmountOfWinnings = 0;
    private boolean fiftyFifty = true;
    private boolean friendCall = true;
    private boolean audienceHelp = true;

    public GameProcess(QuestionsService questionsService) {
        this.questionsService = questionsService;
    }

    public void start(){
        setSafeAmountOfWinnings(MeniuText.getSafeMoneyChoice());
        boolean resumeGame = true;
        while (resumeGame && questionsCount < QuestionsEnum.getMaxNumberValue()) {
            System.out.println("*****************************************************");
            System.out.println("Your winnings at the moment " + QuestionsEnum.getWinningsByQuestionNumber(questionsCount) + " euros");
            activeHelpersText();
            questionsCount++;
            Question question = questionsService.getQuestionByDifficulty(getDifficultByQuestionNumber(questionsCount)).get();
            questionsService.printQuestionAndAnswers(question);
            resumeGame = isAnswerCorrect(question);
            questionsService.removeQuestionFromList(question);
        }
    }

    private void activeHelpersText() {
        List<String> helpers = new ArrayList<>();
        if (fiftyFifty) {
            helpers.add("50/50");
        }
        if (friendCall) {
            helpers.add("Friend call");
        }
        if (audienceHelp) {
            helpers.add("Audience help");
        }

        if (helpers.size() == 0) {
            System.out.println("You don't have helpers");
        } else {
            System.out.print("You have helpers: ");
            int i = 0;
            for (String helper : helpers) {
                i++;
                if (helpers.size() == i) {
                    System.out.print(helper + ".");
                } else {
                    System.out.print(helper + " ,");
                }
            }
        }
        System.out.println();
    }

    private GameDifficult getDifficultByQuestionNumber(int questionsCount){
        for (GameDifficult value : GameDifficult.values()) {
            for (int i : value.getQuestionNumber()) {
                if (i == questionsCount){
                    return value;
                }
            }
        } return null;
    }

    private boolean isAnswerCorrect(Question question) {
        Scanner scanner = new Scanner(System.in);
        String userAnswer = scanner.next();
        if(userAnswer.equalsIgnoreCase(question.getCorrectAnswer().getAnswer())){
            System.out.println("Correct");
            return true;
        }
        System.out.println("Wrong");
        return false;
    }

    public void setSafeAmountOfWinnings(int safeAmountOfWinnings) {
        this.safeAmountOfWinnings = safeAmountOfWinnings;
    }

    public void setFiftyFifty(boolean fiftyFifty) {
        this.fiftyFifty = fiftyFifty;
    }

    public void setFriendCall(boolean friendCall) {
        this.friendCall = friendCall;
    }

    public void setAudienceHelp(boolean audienceHelp) {
        this.audienceHelp = audienceHelp;
    }

    public int getSafeAmountOfWinnings() {
        return safeAmountOfWinnings;
    }

    public boolean isFiftyFifty() {
        return fiftyFifty;
    }

    public boolean isFriendCall() {
        return friendCall;
    }

    public boolean isAudienceHelp() {
        return audienceHelp;
    }
}