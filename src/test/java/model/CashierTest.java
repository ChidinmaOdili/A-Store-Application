//package model;
//
//import enums.Roles;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class CashierTest {
//    Cashier cashier1;
//    Customer customer;
//    Store store;
//    Products products;
//
//
//    @BeforeEach
//    void setUp() {
//        store = new Store("num");
//        cashier1 = new Cashier("Nancy", Roles.CASHIER);
//
//        customer = new Customer("tola");
//        customer.canBuy("Arrowroot","Cookies",20,store);
//
//        String path = "src/main/java/FoodSales.csv";
//        String line = "";
//
//        try {
//            BufferedReader co = (BufferedReader) new BufferedReader(new FileReader(path));
//
//            while ((line = co.readLine()) != null) {
//                String[] values = line.split(",");
//
//                int productIndex =store.SearchProduct(values[4]);
//                if(store.SearchProduct(values[4] ) >= 0){
//                    Products productInStore = store.getProductList().get(productIndex);
//                    productInStore.setqtyAvailable(productInStore.getQtyAvalaible()+ Integer.parseInt(values[5]));
//
//                }else{
//                    String productName = values[4];
//                    String category = values[3];
//                    int qtyAvailable= Integer.parseInt(values[5]);
//                    double price = Double.parseDouble(values[6]);
//                    //int qtyBuying = Integer.parseInt(values[7]);
//                    products = new Products(productName,category,qtyAvailable,price);
//                    store.getProductList().add(products);
//                }
//            }
//        }catch (FileNotFoundException e) {
//            System.out.println("file not found");
//        }catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    @Test
//    void sellProductAndIssueReceipt() {
//        int actual = cashier1.sellProductAndIssueReceipt(customer, customer.getCustomerCart());
//        assertEquals(1,actual);
//    }
//}