package kimBobHeaven_PastCampus.kiosk.view;

import kimBobHeaven_PastCampus.menu.MenuItem;

import java.util.List;

public class Output {

    private static final String OUTPUT_MENU_SELECT = "\n메뉴를 선택해주세요.";
    private static final String OUTPUT_MENU_DIVISION_LINE = "==================";
    private static final String OUTPUT_MENU_EXIT = "종료";
    private static final String OUTPUT_MENU_FORMAT = "%d. %-3s\n";

    private static final String OUTPUT_SELECT_MENU_FORMAT= "%s 선택하셨습니다.\n";
    private static final String OUTPUT_CHANGE_FORMAT= "잔돈은 %d원 입니다.\n";

    public static void printError(String message){
        System.out.println(message);
        // 프로그램 종료 객체를 추가해야 할까? 지금은 SRP에 위배
        System.exit(0);
    }

    public static void printMenu(List<MenuItem> items){
        prePrintMenu();
        int MenuNum = 1;
        for(MenuItem item : items){
            System.out.printf("%d. %-3s (%d)\n", MenuNum++, item.getName(), item.getPrice());
        }
        postPrintMenu(MenuNum);
    }

    private static void prePrintMenu(){
        System.out.println(OUTPUT_MENU_SELECT);
        System.out.println(OUTPUT_MENU_DIVISION_LINE);
    }

    private static void postPrintMenu(int lastMenuNum){
        System.out.printf(OUTPUT_MENU_FORMAT, lastMenuNum, OUTPUT_MENU_EXIT);
        System.out.println(OUTPUT_MENU_DIVISION_LINE);
    }

    public static void printWarning(String message) {
        System.out.println(message);
    }

    public static void printSelectMenuAndChange(MenuItem menuItem, int customerMoney) {
        System.out.printf(OUTPUT_SELECT_MENU_FORMAT, menuItem.getName());
        System.out.printf(OUTPUT_CHANGE_FORMAT, customerMoney);
    }
}
