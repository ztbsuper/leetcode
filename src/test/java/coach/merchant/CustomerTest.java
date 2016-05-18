package coach.merchant;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Marvin on 16/5/17.
 */
public class CustomerTest {
    private List<Good> storage;
    private Customer customer;

    @Before
    public void setUp() throws Exception {
        storage = new ArrayList<>();
        storage.add(new Good(GoodType.APPLE));
        storage.add(new Good(GoodType.MACBOOK));
        storage.add(new Good(GoodType.APPLE));
        storage.add(new Good(GoodType.COOKIE));

        customer = new Customer();
    }

    @After
    public void tearDown() throws Exception {
        storage.clear();
        customer = null;
    }

    @Test
    public void should_remove_a_good_when_user_pick_from_storage() throws Exception {
        assertThat(customer.getCart().size(), is(0));
        assertThat(storage.size(), is(4));
        customer.pick(storage);
        assertThat(storage.size(), is(3));
        assertThat(customer.getCart().size(), is(1));
    }

    @Test
    public void should_clean_up_cart_when_user_call_clean_my_cart() throws Exception {
        customer.pick(storage);
        customer.cleanCart();
        Assert.assertEquals(customer.getCart().size(), 0);


    }
}