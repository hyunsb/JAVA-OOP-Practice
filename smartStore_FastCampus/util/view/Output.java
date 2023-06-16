package smartStore_FastCampus.util.view;

import smartStore_FastCampus.domain.customer.Customer;
import smartStore_FastCampus.domain.customer.Customers;
import smartStore_FastCampus.domain.group.Group;
import smartStore_FastCampus.domain.group.Groups;

import java.util.ArrayList;
import java.util.List;

public class Output {

    public static void printErrorMessage(String message){
        System.out.println(message);
    }

    public static void printGroup(Group group) {
        System.out.printf("%-7s Group Info : [ Time = %2d | Pay = %6d ]\n",
                group.getGroupType(), group.getMinTime(), group.getMinPay());
    }

    public static void printGroups(Groups groups) {
        for (Group group : groups.toList())
            printGroup(group);
    }

    public static void customerList(Customers customers) {
        System.out.println("\n======= Customer Info. =======");

        if (customers.size() == 0) {
            System.out.println("NONE");
            return;
        }

        for (int i = 0; i < customers.size(); i++) {
            System.out.print("NO. " + (i+1) + " > ");
            System.out.println(customers.get(i));
        }
    }

    public static void customerClassifiedList(ArrayList<Customer> customers, Group group){
        System.out.println("\n==============================");
        System.out.printf("Group : %s ( Time : %d, Pay : %d )\n", group.getGroupType(), group.getMinTime(), group.getMinPay());
        System.out.println("==============================");

        if (customers.isEmpty()) {
            System.out.println("NONE");
            return;
        }

        for (int i = 0; i < customers.size(); i++) {
            System.out.printf("No. %-4d > ", i+1);
            System.out.println(customers.get(i));
        }
    }

    public static void customerClassifiedList(ArrayList<ArrayList<Customer>> allCustomers, List<Group> list) {
        for (int i = allCustomers.size()-1; i >= 0; i--) {
            customerClassifiedList(allCustomers.get(i), list.get(i));
        }
    }
}
