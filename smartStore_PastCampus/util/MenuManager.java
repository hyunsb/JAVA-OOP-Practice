package smartStore_PastCampus.util;

import smartStore_PastCampus.exception.InputFormatException;
import smartStore_PastCampus.exception.InputNumOfEndMenuException;
import smartStore_PastCampus.exception.InputRangeException;
import smartStore_PastCampus.util.view.Input;

public class MenuManager {

    // Suppresses default constructor, ensuring non-instantiability.
    private MenuManager() {

    }

    public static int chooseMenu(String[] menu) {
        while (true) {
            try {
                int inputMenuNumber = Input.chooseMenuNumber(menu);
                validateChoiceMenuNumRange(inputMenuNumber, menu.length);
                if (inputMenuNumber == menu.length) throw new InputNumOfEndMenuException();

                return inputMenuNumber;

            } catch (InputFormatException | InputRangeException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private static void validateChoiceMenuNumRange(int inputNum, int maxNum) throws InputRangeException {
        if (inputNum < 1 || inputNum > maxNum) {
            throw new InputRangeException();
        }
    }
}
