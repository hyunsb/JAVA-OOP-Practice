package kimBobHeaven_PastCampus.kiosk;

import kimBobHeaven_PastCampus.kiosk.view.Input;
import kimBobHeaven_PastCampus.kiosk.view.Output;
import kimBobHeaven_PastCampus.menu.Menu;
import kimBobHeaven_PastCampus.menu.MenuItem;

public class Kiosk {

    private final Input input;
    private final Auth auth;
    private final Menu menu;

    private int customerMoney;

    public Kiosk(Input input, Auth auth, Menu menu){
        this.input = input;
        this.auth = auth;
        this.menu = menu;
    }

    // TODO: 사용자의 현금을 입력받고, 매장 입장 자격을 확인하기
    public void CheckAdmission(){
        customerMoney = input.getCustomerMoney();
        auth.checkAdmission(customerMoney, menu.getMinPrice());
    }

    // TODO: 주문 받기
    // 1. 메뉴판을 출력한다.
    // 2. 사용자로부터 주문번호를 입력받는다.
    public void orderService(){
        Output.printMenu(menu.getItems());

        while (true) {
            int orderNumber = input.getOrderNumber();

            if (orderNumber == menu.getItems().size() + 1) break;

            MenuItem selectMenu = menu.getMenuItem(orderNumber);

            if (auth.checkPossibleOrder(customerMoney, selectMenu.getPrice())){
                customerMoney -= selectMenu.getPrice();
                Output.printSelectMenuAndChange(selectMenu, customerMoney);

                auth.checkMoneyForNextOrder(customerMoney, selectMenu.getPrice());
            }
        }

        Output.printError("프로그램 종료.\n" + "지금까지 선택하신 식사 주문이 완료되었습니다.");
    }
}
