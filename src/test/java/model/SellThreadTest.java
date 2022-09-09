package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import serviceImpl.CashierServiceImpl;
import serviceImpl.CustomerServiceImpl;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SellThreadTest {
    Cashier cashier;
    CashierServiceImpl cashierService;
    SellThread selling;
    CustomerServiceImpl customerService;
    Customer customers;
    //ArrayList<Customer>c
    Store store;
    Products products;



    @BeforeEach
    void setUp() {
        cashier = new Cashier();
        cashierService = new CashierServiceImpl();
        customers = new Customer("chidinma");
        customerService = new CustomerServiceImpl();
        store = new Store("ble");
        products =new Products("Carrot","Bars",1000,1.77);
        customers.getCustomerCart().add(new Products("Banana", "Bars", 4, 1.77));
        selling = new SellThread(cashier,cashierService,customers);
        cashierService.sellProductAndIssueReceipt(customers);

    }

    @Test
    void run() {
        selling.run();
    }
}