package enumai;

public enum QuestionsEnum {
    NUMBER1(1, 100),
    NUMBER2(2, 200),
    NUMBER3(3, 300),
    NUMBER4(4, 500),
    NUMBER5(5, 1000),
    NUMBER6(6, 2000),
    NUMBER7(7, 4000),
    NUMBER8(8, 8000),
    NUMBER9(9, 16000),
    NUMBER10(10, 32000),
    NUMBER11(11, 64000),
    NUMBER12(12, 125000),
    NUMBER13(13, 250000),
    NUMBER14(14, 500000),
    NUMBER15(15, 1000000);

    int number;
    int winingMoney;

    QuestionsEnum(int number, int winingMoney) {
        this.number = number;
        this.winingMoney = winingMoney;
    }

    public int getNumber() {
        return number;
    }

    public int getWiningMoney() {
        return winingMoney;
    }

}
