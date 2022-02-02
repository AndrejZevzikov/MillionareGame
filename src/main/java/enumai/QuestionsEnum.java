package enumai;

import java.util.Arrays;
import java.util.Comparator;

public enum QuestionsEnum {
    NUMBER0(0,0, GameDifficult.NONE),
    NUMBER1(1, 100, GameDifficult.VERY_EASY),
    NUMBER2(2, 200, GameDifficult.VERY_EASY),
    NUMBER3(3, 300, GameDifficult.VERY_EASY),
    NUMBER4(4, 500, GameDifficult.EASY),
    NUMBER5(5, 1000, GameDifficult.EASY),
    NUMBER6(6, 2000, GameDifficult.EASY),
    NUMBER7(7, 4000, GameDifficult.MEDIUM),
    NUMBER8(8, 8000, GameDifficult.MEDIUM),
    NUMBER9(9, 16000, GameDifficult.MEDIUM),
    NUMBER10(10, 32000, GameDifficult.HARD),
    NUMBER11(11, 64000, GameDifficult.HARD),
    NUMBER12(12, 125000, GameDifficult.HARD),
    NUMBER13(13, 250000, GameDifficult.EXTREME),
    NUMBER14(14, 500000, GameDifficult.EXTREME),
    NUMBER15(15, 1000000, GameDifficult.EXTREME);

    final int number;
    final int winingMoney;
    final GameDifficult difficult;


    QuestionsEnum(int number, int winingMoney, GameDifficult difficult) {
        this.number = number;
        this.winingMoney = winingMoney;
        this.difficult = difficult;
    }

    public int getNumber() {
        return number;
    }

    public int getWiningMoney() {
        return winingMoney;
    }

    public GameDifficult getDifficult(){
        return difficult;
    }

    public static int getMaxNumberValue(){
        return Arrays.stream(QuestionsEnum.values()).max(Comparator.comparing(QuestionsEnum::getNumber)).get().getNumber();
    }

    public static int getWinningsByQuestionNumber(int number){
        for (QuestionsEnum value : QuestionsEnum.values()) {
            if (value.getNumber() == number){
                return value.getWiningMoney();
            }
        } return 0;
    }
}
