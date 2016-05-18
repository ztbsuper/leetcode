package coach.merchant;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Marvin on 16/5/17.
 */
public class Supermarket {
    Cashier[] cashiers = new Cashier[]{new Cashier(), new Cashier(), new Cashier()};
    List<Good> storage = new ArrayList<>();

    public Supermarket() {

        
        int eachStore = 15;
        for (int i = 0; i < eachStore; i++) {
            storage.add(new Good(GoodType.APPLE));
            storage.add(new Good(GoodType.MACBOOK));
            storage.add(new Good(GoodType.COOKIE));
        }
    }

    public static void main(String[] args) {
        Supermarket supermarket = new Supermarket();
        while (supermarket.getStorage().size() > 0) {

            Customer customer = new Customer();

            customer.pick(supermarket.getStorage());

            Cashier[] cashiers = supermarket.getCashiers();

            cashiers[new Random().nextInt(3)].checkout(customer);

        }
        supermarket.printSupermarketInfo();

    }

    public void printSupermarketInfo() {
        System.out.println("==========");
        System.out.println("剩余商品:" + getStorage().size());
        System.out.println("初始收银机0的数量:" + getCashiers()[0].getCounter());
        System.out.println("初始收银机1的数量:" + getCashiers()[1].getCounter());
        System.out.println("初始收银机2的数量:" + getCashiers()[2].getCounter());
    }

    public List<Good> getStorage() {
        return storage;
    }

    public Cashier[] getCashiers() {
        return cashiers;
    }


}
