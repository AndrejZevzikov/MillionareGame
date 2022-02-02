package QA;

import lombok.Data;

import enumai.GameDifficult;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Data
public class Question {

    private String question;
    private Set<Answers> answers;
    private GameDifficult difficult;

    public Question(String question, Set<Answers> answers, GameDifficult difficult) {
        this.question = question;
        this.answers = answers;
        this.difficult = difficult;
    }

    public void setDifficult(GameDifficult difficult) {
        for (GameDifficult value : GameDifficult.values()) {
            if (value.equals(difficult)) {
                this.difficult = value;
            }
        }
    }

    public boolean isAnswerCorrect(Answers answer) {
        return answers.stream()
                .filter(answers1 -> answers1.equals(answer))
                .findAny().get().isCorrect();
    }

    public void useFiftyFifty() {
        for (int i = 0; i < 2; i++) {
            for (Answers answer : answers) {
                if (!answer.isCorrect()) {
                    answers.remove(answer);
                    break;
                }
            }
        }
    }

    public void useFriendCall() {
        useAudienceHelp();
        Answers answer = getAnswerForBiggestAudienceVoting();
        if (answer.getAudiencePercentages() > 70) {
            System.out.println("I pretty sure answer is " + answer.getAnswer());
        } else if (answer.getAudiencePercentages() > 50) {
            System.out.println("I not sure by likely answer is: " + answer.getAnswer());
        } else {
            System.out.println("I really don't know but guess answer is: " + answer.getAnswer());
        }
    }

    public void useAudienceHelp() {
        if (getDifficult().equals(GameDifficult.HARD)) {
            setAudienceVotingForHardDifficult();
        } else if (getDifficult().equals(GameDifficult.MEDIUM)) {
            setAudienceVotingForMediumDifficult();
        } else if (getDifficult().equals(GameDifficult.VERY_EASY)) {
            setAudienceVotingForVeryEasyDifficult();
        } else if (getDifficult().equals(GameDifficult.EASY)) {
            setAudienceVotingForEasyDifficult();
        } else if (getDifficult().equals(GameDifficult.EXTREME)) {
            setAudienceVotingForExtremeDifficult();
        }
    } //TODO galbut visas pagalbas perkelti prie pagalbu klases

    private void setAudienceVotingForExtremeDifficult() {
        Random random = new Random();
        int i = 0;
        for (Answers answer : answers) {
            i++;
            if (i == answers.size()) {
                answer.setAudiencePercentages(100 - getAudienceVotingForAllAnswers());
                break;
            }
            answer.setAudiencePercentages(random.nextInt(100 - getAudienceVotingForAllAnswers()));
        }
    }

    private void setAudienceVotingForEasyDifficult() {
        Random random = new Random();
        for (Answers answer : answers) {
            if (!answer.isCorrect()) {
                answer.setAudiencePercentages(random.nextInt((int) ((double) (100 - getAudienceVotingForAllAnswers()) * 0.4)));
            }
        }
        getCorrectAnswer().setAudiencePercentages(100 - getAudienceVotingForAllAnswers());
    }

    private void setAudienceVotingForVeryEasyDifficult() {
        Random random = new Random();
        for (Answers answer : answers) {
            if (!answer.isCorrect()) {
                answer.setAudiencePercentages(random.nextInt(33));
            }
        }
        getCorrectAnswer().setAudiencePercentages(100 - getAudienceVotingForAllAnswers());
    }

    private void setAudienceVotingForMediumDifficult() {
        Random random = new Random();
        for (Answers answer : answers) {
            if (!answer.isCorrect()) {
                answer.setAudiencePercentages(random.nextInt((int) ((double) (100 - getAudienceVotingForAllAnswers()) * 0.5)));
            }
        }
        getCorrectAnswer().setAudiencePercentages(100 - getAudienceVotingForAllAnswers());
    }


    private void setAudienceVotingForHardDifficult() {
        Random random = new Random();
        for (Answers answer : answers) {
            if (!answer.isCorrect()) {
                answer.setAudiencePercentages(random.nextInt((int) ((double) (100 - getAudienceVotingForAllAnswers()) * 0.6)));
            }
        }
        getCorrectAnswer().setAudiencePercentages(100 - getAudienceVotingForAllAnswers());
    }

    public Answers getCorrectAnswer() {
        return answers.stream()
                .filter(Answers::isCorrect)
                .findAny().get();
    }

    private int getAudienceVotingForAllAnswers() {
        int sum = 0;
        for (Answers answer : answers) {
            sum += answer.getAudiencePercentages();
        }
        return sum;
    }

    private Answers getAnswerForBiggestAudienceVoting() {
        return answers.stream()
                .max(Answers::compareTo)
                .get();
    }

    public void printAudienceVotingResults(){
        int i = 1;
        for (Answers answer : answers) {
            System.out.println(i + ". " + answer.getAnswer() + " " + answer.getAudiencePercentages()+"%");
            i++;
        }
    }

}