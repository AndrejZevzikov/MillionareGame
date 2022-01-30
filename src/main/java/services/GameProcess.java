package services;


import Meniu.MeniuText;
import enumai.GameDifficult;

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
        questionsCount++;
        questionsService.printQuestionForUserByDifficult(getDifficultByQuestionNumber(questionsCount));
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

//    private boolean isAnswerCorrect() {
//
//    }

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
