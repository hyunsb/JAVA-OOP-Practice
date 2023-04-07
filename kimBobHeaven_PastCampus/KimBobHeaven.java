package kimBobHeaven_PastCampus;

import kimBobHeaven_PastCampus.kiosk.Auth;
import kimBobHeaven_PastCampus.kiosk.Kiosk;
import kimBobHeaven_PastCampus.kiosk.view.Input;
import kimBobHeaven_PastCampus.menu.GenerateMenu;
import kimBobHeaven_PastCampus.menu.Menu;

import java.util.Scanner;

public class KimBobHeaven {

    Kiosk kiosk;

    public KimBobHeaven() {
        open();
        sales();
    }

    private void open(){
        // 메뉴 초기화
        GenerateMenu generateMenu = new GenerateMenu();

        // 키오스크 생성
        Menu menu = new Menu(generateMenu.setMenu());
        Auth auth = new Auth();
        Input input = new Input(new Scanner(System.in), 1, menu.getItems().size());
        kiosk = new Kiosk(input, auth, menu);
    }

    private void sales(){
        kiosk.CheckAdmission();
        kiosk.orderService();
    }
}
