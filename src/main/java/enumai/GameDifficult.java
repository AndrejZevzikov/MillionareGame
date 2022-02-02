package enumai;

public enum GameDifficult {

    NONE("None"),
    VERY_EASY("Very Easy"),
    EASY("Easy"),
    MEDIUM("Medium"),
    HARD("Hardy"),
    EXTREME("Very Hard");

    private final String name;

    GameDifficult(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
