package coach.merchant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marvin on 16/5/17.
 */
public class Cashier {
    private int counter = 0;
    private List<Good> sold = new ArrayList<>();

    public int getCounter() {
        return counter;
    }

    private void increment() {
        counter++;
    }

    public void checkout(Customer customer) {
        sold.addAll(customer.getCart());
        customer.cleanCart();
        increment();
    }

}
