package smartStore_FastCampus.util;

import smartStore_FastCampus.exception.InputEndException;
import smartStore_FastCampus.exception.InputFormatException;
import smartStore_FastCampus.util.view.Message;

import java.util.Objects;
import java.util.Scanner;

public class Console {

    private static Scanner scanner;

    // Suppresses default constructor, ensuring non-instantiability.
    private Console() {
    }

    private static Scanner getInstance() {
        if (Objects.isNull(scanner)) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }

    public static String readLine() {
        return getInstance().nextLine();
    }

    public static String readLineEnd() throws InputFormatException {
        System.out.println("** Press 'end', if you want to exit! **");
        String str = readLine().toUpperCase();
        if (str.equals(Message.END_MSG)) throw new InputEndException();
        return str;
    }

    public static int readLineToInteger() throws InputFormatException {
        return inputValueToInteger(readLine());
    }

    public static int inputValueToInteger(String input) throws InputFormatException {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new InputFormatException();
        }
    }

    public static void close() {
        scanner.close();
    }
}
