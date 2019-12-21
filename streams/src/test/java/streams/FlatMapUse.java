package streams;

import org.junit.Before;
import org.junit.Test;
import streams.model.Customer;
import streams.model.Order;

import java.util.Arrays;
import java.util.List;

public class FlatMapUse {

    private List<Customer> customers;

    @Before
    public void setup() {
        Customer sheridan = new Customer("Sheridan");
        Customer ivanova = new Customer("Ivanova");
        Customer garibaldi = new Customer("Garibaldi");

        sheridan.addOrder(new Order(1))
                .addOrder(new Order(2))
                .addOrder(new Order(3));
        ivanova.addOrder(new Order(4))
                .addOrder(new Order(5));

        customers = Arrays.asList(sheridan, ivanova, garibaldi);
    }

    @Test
    public void test(){
        System.out.println(customers);
    }
}
