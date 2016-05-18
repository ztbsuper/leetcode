package coach.merchant;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Marvin on 16/5/17.
 */
public class Customer {
    private List<Good> cart = new ArrayList<>();

    public List<Good> getCart() {
        return cart;
    }

    public void cleanCart() {
        cart.clear();
    }


    void pick(List<Good> storage) {
        int i = new Random().nextInt(storage.size());
        cart.add(storage.remove(i));
    }
}
