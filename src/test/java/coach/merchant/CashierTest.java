package coach.merchant;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Marvin on 16/5/17.
 */
public class CashierTest {
    private Cashier cashier;
    private Customer customer;

    @Before
    public void setUp() throws Exception {
        cashier = new Cashier();
        customer = new Customer();
    }

    @Test
    public void should_increment_counter_when_checkout_once() throws Exception {
        Assert.assertEquals(cashier.getCounter(), 0);
        cashier.checkout(customer);
        Assert.assertEquals(cashier.getCounter(), 1);

    }
}