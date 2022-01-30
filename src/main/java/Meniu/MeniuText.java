package Meniu;

import enumai.QuestionsEnum;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MeniuText {

    public static int getSafeMoneyChoice() {
        int returnValue = 0;
        do {
            System.out.println("Pasirinkite nesudegancia suma");
            try {
                Scanner scanner = new Scanner(System.in);
                returnValue = scanner.nextInt();
            } catch (InputMismatchException e) {
            }
        }
        while (!safeMoneyAmountValidator(returnValue));
        return returnValue;
    }

    private static boolean safeMoneyAmountValidator(int amount) {
        for (QuestionsEnum value : QuestionsEnum.values()) {
            if (value.getWiningMoney() == amount) {
                return true;
            }
        }
        System.out.println("Invalid choice");
        return false;
    }
}