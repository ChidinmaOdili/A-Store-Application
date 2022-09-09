package serviceImpl;

import Utility.FileUtility;
import model.Cashier;
import model.Customer;
import model.Products;
import model.Store;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerServiceImplTest {
    Cashier cashier = new Cashier();
    private List<Products> productList = new ArrayList<>();
    Products product = new Products("Carrot","Bars",4,1);
//    Store store = new Store("Nma");

    List<Products>customerCart = new ArrayList<>();
    CustomerServiceImpl customerService = new CustomerServiceImpl();
    Store store = new Store("Nma");
    Customer customer = new Customer(customerCart, 40);

    @BeforeEach
    void setUp() {



    }



    @Test
    void canBuy() {


        store.addProduct(new Products("Carrot","Bars",40,3));


        var expected = "product added to cart";
        var actual = customerService.canBuy("Carrot", "Bars", 4, store, customer);
        assertEquals(expected , actual);

    }
    @Test
    void canNotBuyWhenProductQuantityIsLessThanQtyBuying(){
        store.addProduct(new Products("Carrot","Bars",40,3));


        var expected = "Sorry  only this quantity Available. Kindly Reorder!!!";
        var actual = customerService.canBuy("Carrot", "Bars", 45, store, customer);
        assertEquals(expected , actual);


    }

    @Test
    void cannotBuyWhenProductIsOutOfStock(){

        var expected = "out of stock";
        var actual = customerService.canBuy("Carrot", "Bars", 45, store, customer);
        assertEquals(expected , actual);


    }
}