package kimBobHeaven_PastCampus.kiosk;

import kimBobHeaven_PastCampus.kiosk.view.Output;


public class Auth {

    public void checkAdmission(int customerMoney, int menuMinPrice){
        if (customerMoney < menuMinPrice)
            Output.printError("돈이 부족하여 김밥천국에 입장이 불가능합니다.");
    }

    public void checkMoneyForNextOrder(int customerMoney, int menuMinPrice){
        if (customerMoney < menuMinPrice)
            Output.printError("더이상 선택할 수 없습니다. 프로그램 종료.\n" +
                                "지금까지 선택하진 식사 주문이 완료되었습니다.");
    }

    public boolean checkPossibleOrder(int costumerMoney, int menuPrice){
        if (costumerMoney >= menuPrice) return true;

        Output.printWarning("돈이 부족하여 메뉴를 선택할 수 없습니다.");
        return false;
    }
}
