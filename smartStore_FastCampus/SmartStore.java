package smartStore_FastCampus;

import smartStore_FastCampus.domain.customer.Customers;
import smartStore_FastCampus.domain.group.Groups;
import smartStore_FastCampus.menu.CustomerMenu;
import smartStore_FastCampus.menu.GroupMenu;
import smartStore_FastCampus.menu.MainMenu;
import smartStore_FastCampus.menu.SummaryMenu;
import smartStore_FastCampus.service.CustomerService;
import smartStore_FastCampus.service.GroupService;
import smartStore_FastCampus.service.SummaryService;
import smartStore_FastCampus.util.Console;

import java.util.Objects;

public class SmartStore {

    private static SmartStore smartStore;

    private final MainMenu mainMenu;


    private SmartStore() {
        // inject Dependency
        CustomerService customerService = new CustomerService(Customers.getInstance());
        GroupService groupService = new GroupService(Groups.getInstance());
        SummaryService summaryService = new SummaryService(customerService, groupService);

        CustomerMenu customerMenu = new CustomerMenu(customerService, summaryService);
        GroupMenu groupMenu = new GroupMenu(groupService, summaryService);
        SummaryMenu summaryMenu = new SummaryMenu(summaryService, groupService);

        mainMenu = new MainMenu(groupMenu, customerMenu, summaryMenu);
    }

    public static SmartStore getInstance() {
        if (Objects.isNull(smartStore)) {
            smartStore = new SmartStore();
        }
        return smartStore;
    }

    private void details() {
        System.out.println("\n\n===========================================");
        System.out.println(" Title : SmartStore Customer Classification");
        System.out.println(" Release Date : 23.05.05");
        System.out.println("===========================================\n");
    }

    public void run() {
        details();
        mainMenu.service();
        System.out.println("Program Finished.");
        Console.close();
    }
}
