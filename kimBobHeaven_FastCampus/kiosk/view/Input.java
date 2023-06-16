package kimBobHeaven_FastCampus.kiosk.view;

import kimBobHeaven_FastCampus.vaildate.InputValidate;

import java.util.Scanner;

public class Input {

    private static final String INPUT_ASK_MONEY = "현금을 얼마 가지고 있나요? ";
    private static final String INPUT_IS_NOT_MONEY = "그건 돈이 아니란다 얘";
    private static final String INPUT_IS_NOT_NUMBER = "그건 번호가 아니란다 얘";
    private static final String INPUT_MENU_ORDER_NUM = "\n메뉴 주문 번호: ";

    private final int minMenuNumber;
    private final int maxMenuNumber;
    private final String inputSelectInRangeNumber;


    private final Scanner scanner;

    public Input(Scanner scanner, int minMenuNumber, int maxMenuNumber){
        this.scanner = scanner;
        this.minMenuNumber = minMenuNumber;
        this.maxMenuNumber = maxMenuNumber+1;
        inputSelectInRangeNumber = "메뉴 선택 오류 "
                + minMenuNumber + " ~ " + maxMenuNumber + " 번 사이의 메뉴를 선택해주세요.";
    }

    // 손님의 돈을 입력받고 반환한다.
    public int getCustomerMoney(){
        System.out.print(INPUT_ASK_MONEY);
        return getCustomerMoneyToInteger(scanner.nextLine());
    }

    private int getCustomerMoneyToInteger(String money){
        if(InputValidate.isInteger(money))
            return Integer.parseInt(money);

        Output.printError(INPUT_IS_NOT_MONEY);
        return 0;
    }

    // 손님의 주문 번호를 입력받고 반환한다.
    public int getOrderNumber(){
        // 1. 주문 번호를 입력받는다.
        int orderNum = 0;

        while (true) {
            System.out.print(INPUT_MENU_ORDER_NUM);
            String StringOrderNumber = scanner.nextLine();

            // 2. 주문 번호가 숫자인지 검증한다. (아닐 시 1로 돌아감)
            if (InputValidate.isInteger(StringOrderNumber))
                orderNum = Integer.parseInt(StringOrderNumber);
            else {
                Output.printWarning(INPUT_IS_NOT_NUMBER);
                continue;
            }

            // 3. 주문 번호가 번위 내의 값인지 검증한다. (아닐 시 1로 돌아감)
            if (checkOrderNumInRange(orderNum)) { break; }
            else Output.printWarning(inputSelectInRangeNumber);
        }

        // 4. 반환
        return orderNum;
    }

    private boolean checkOrderNumInRange(int orderNum){
        return orderNum >= minMenuNumber && orderNum <= maxMenuNumber;
    }
}
