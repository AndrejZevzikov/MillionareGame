package services;

import Meniu.MeniuText;
import QA.Question;
import enumai.GameDifficult;
import enumai.QuestionsEnum;
import helpers.AudienceHelp;
import helpers.FiftyFifty;
import helpers.FriendCall;
import helpers.Helper;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameProcess {

    private QuestionsService questionsService;
    private int questionsCount = 0;
    private int safeAmountOfWinnings = 0;
    private List<Helper> helpers = new ArrayList<>();
    private boolean isAnswerCorrect = true;
    private Question question;

    public GameProcess(QuestionsService questionsService) {
        this.questionsService = questionsService;
        helpers.add(new FiftyFifty());
        helpers.add(new FriendCall());
        helpers.add(new AudienceHelp());
    }

    public void start() {
        setSafeAmountOfWinnings(MeniuText.getSafeMoneyChoice());
        while (isAnswerCorrect && questionsCount < QuestionsEnum.getMaxNumberValue()) {
            printHeaderText();
            questionsCount++;
            question = questionsService.getQuestionByDifficulty(getDifficultByQuestionNumber(questionsCount));
            if (userAnswering()) {
                break;
            }
            questionsService.removeQuestionFromList(question);
        }
        if(isAnswerCorrect && questionsCount == 15){
            System.out.println("Congrats you win 1 000 000!");
        }
    }

    private boolean userAnswering() {
        String userAnswer = "";
        while (userAnswer.equalsIgnoreCase("")|| userAnswer.equalsIgnoreCase("need help")) {
            userAnswer = getUserInputToTheQuestion(question);
            if (userAnswer.equalsIgnoreCase("take money")) {
                System.out.println("Your winning " + QuestionsEnum.getWinningsByQuestionNumber(questionsCount - 1) + " euros");
                return true;
            } else if (userAnswer.equalsIgnoreCase("need help")) {
                useHelpers();
            } else {
                isAnswerCorrect = isAnswerCorrect(question, userAnswer);
                if(!isAnswerCorrect) wrongAnswerText();
            }
        }
        return false;
    } //TODO sita reikes refaktorint atrodo negraziai

    private void wrongAnswerText() {
        int win = safeAmountOfWinnings <= QuestionsEnum.getWinningsByQuestionNumber(questionsCount-1)
        ? safeAmountOfWinnings : 0;
        System.out.println("Wrong, your winnings is: " + win + " euros");
    }

    private String getUserInputToTheQuestion(Question question) {
        Scanner scanner = new Scanner(System.in);
        questionsService.printQuestionAndAnswers(question);
        return scanner.nextLine();
    }


    private void useHelpers() {
        Helper helper = getHelperByName(getHelperNameFromUser());
        questionsService.useHelper(question,helper);
    }

    private String getHelperNameFromUser() {
        String input = "";
        if (countActiveHelpers() == 0) {
            System.out.println("You haven't any helpers");
            return null;
        } else {
            while (!isHelperExistsOrActive(input)) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Witch help you want to use?");
                helpers.stream()
                        .filter(Helper::isActive)
                        .forEach(System.out::println);
                input = scanner.nextLine();
            } return input;
        }
    }

    private Helper getHelperByName(String name){
        return helpers.stream()
                .filter(helper -> helper.getName().equalsIgnoreCase(name))
                .findAny().get();
    }

    private boolean isHelperExistsOrActive(String input) {
        return helpers.stream()
                .filter(Helper::isActive)
                .anyMatch(helper -> helper.getName().equalsIgnoreCase(input));
    }

    private void printHeaderText() {
        System.out.println("*****************************************************");
        System.out.println("Your save amount of money is: " + safeAmountOfWinnings + " euros");
        System.out.println("Your winnings at the moment " + QuestionsEnum.getWinningsByQuestionNumber(questionsCount) + " euros");
        activeHelpersText();
        System.out.println("Key words: TAKE MONEY if you want end gam and take money, NEED HELP if you want use helper");
    }

    private void activeHelpersText() {
        if (countActiveHelpers() == 0) {
            System.out.println("You don't have helpers");
        } else {
            System.out.print("You have helpers: ");
            int i = 0;
            for (Helper helper : helpers) {
                i++;
                if (countActiveHelpers() == i && helper.isActive()) {
                    System.out.println(helper.getName() + ".");
                } else if (helper.isActive()) {
                    System.out.print(helper.getName() + " ,");
                }
            }
        }
    }

    private int countActiveHelpers() {
        return (int) helpers.stream()
                .filter(Helper::isActive)
                .count();
    }

    private GameDifficult getDifficultByQuestionNumber(int questionsCount) {
        for (QuestionsEnum value : QuestionsEnum.values()) {
            if (value.getNumber() == questionsCount){
                return value.getDifficult();
            }
        }
        return null;
    }

    private boolean isAnswerCorrect(Question question, String userAnswer) {
        if (userAnswer.equalsIgnoreCase(question.getCorrectAnswer().getAnswer())) {
            System.out.println("Correct");
            return true;
        }
        return false;
    }

    private void setSafeAmountOfWinnings(int safeAmountOfWinnings) {
        this.safeAmountOfWinnings = safeAmountOfWinnings;
    }
}