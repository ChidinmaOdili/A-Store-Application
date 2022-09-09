package serviceImpl;

import model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CashierServiceImplTest {

    Customer customer3 = new Customer("Nma");
    Cashier cashier = new Cashier();
    List<Products> customerCart;
    CashierServiceImpl cashier1;

    @BeforeEach
    void setUp() {
        customerCart = new ArrayList<>();
        cashier1 = new CashierServiceImpl();
    }


    @Test
    void sellProductAndIssueReceipt_Cart_Not_Empty() {

        //Given
        Customer customerTest = new Customer("Nma");
        customerTest.getCustomerCart().add(new Products("Carrot", "Bars", 4, 1.77));
        customerTest.getCustomerCart().add(new Products("Bran", "Bars", 4, 1.77));

        //When
        var expected = "sold";
        var actual = cashier1.sellProductAndIssueReceipt(customerTest);
        assertEquals(expected, actual);

    }

    @Test
    void sellProductAndIssueReceipt_Cart_Is_Empty() {

        //Given
        Customer customerTest = new Customer("Olivia");

        //When
        var expected = "No transaction made";
        var actual = cashier1.sellProductAndIssueReceipt(customerTest);
        assertEquals(expected, actual);

    }


    @Test
    void comparingProductWithCarrot() {

        //Given
        Customer customer = new Customer("Vivian");
        customer.getCustomerCart().add(new Products("carrot", "Bars", 5, 3));

        //when
        var expected = "carrot added to the queue";
        var actual = cashier1.comparingProducts(customer);
        assertEquals(expected, actual);

    }

    @Test
    void comparingProductWithArrowRoot() {
        //Given
        Customer customer = new Customer("Chinaemerem");
        customer.getCustomerCart().add(new Products("Arrowroot", "Bars", 5, 3));

        //when
        var expected = "Arrowroot added to the queue";
        var actual = cashier1.comparingProducts(customer);
        assertEquals(expected, actual);


    }

    @Test
    void comparingProductWithBanana() {
        //Given
        Customer customer = new Customer("Chimudia");
        customer.getCustomerCart().add(new Products("Banana", "Bars", 5, 3));

        //when
        var expected = "Banana added to the queue";
        var actual = cashier1.comparingProducts(customer);
        assertEquals(expected, actual);


    }

    @Test
    void checkingForNullProduct() {
        //Given
        Customer customer = new Customer("Pelumi");
        customer.getCustomerCart().add(new Products("water", "Bars", 5, 3));

        //when
        var expected = "";
        var actual = cashier1.comparingProducts(customer);
        assertEquals(expected, actual);
    }

    @Test
    void addToQueueList() {
        Queue<Customer> fifo = new LinkedList<>();
        var expected = true;
        var actual = cashier1.addToQueueList(customer3,fifo);
        assertEquals(expected, actual);
    }

    @Test
    void notAddToQueueList() {
        Queue<Customer> fifo = new LinkedList<>();
        var expected = fifo;
        var actual = cashier1.getFifo();
        assertEquals(expected, actual);

    }
}