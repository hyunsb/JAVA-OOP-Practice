package smartStore_FastCampus.util;

import smartStore_FastCampus.exception.InputFormatException;
import smartStore_FastCampus.exception.InputNumOfEndMenuException;
import smartStore_FastCampus.exception.InputRangeException;
import smartStore_FastCampus.util.view.Input;

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
