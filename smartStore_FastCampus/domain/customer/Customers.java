package smartStore_FastCampus.domain.customer;

import smartStore_FastCampus.util.arrays.MyArray;

import java.util.Objects;

public class Customers extends MyArray<Customer> {

    private static Customers allCustomers;

    public static Customers getInstance() {
        if (Objects.isNull(allCustomers)) {
            allCustomers = new Customers();
        }
        return allCustomers;
    }

    private Customers() {

    }

    public boolean isEmpty(){
        return size == 0;
    }
}
