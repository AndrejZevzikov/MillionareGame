package enumai;

public enum GameDifficult {

    VERY_EASY("Very Easy", new int[] {1,2,3}),
    EASY("Easy", new int[] {4,5,6}),
    MEDIUM("Medium", new int[] {7,8,9}),
    HARD("Hardy", new int[] {10,11,12}),
    EXTREME("Very Hard", new int[] {13,14,15});

    private final String name;
    private final  int[] questionNumber;

    GameDifficult(String name, int[] questionNumber) {
        this.name = name;
        this.questionNumber = questionNumber;
    }

    public String getName() {
        return name;
    }

    public int[] getQuestionNumber() {
        return questionNumber;
    }
}
