package coach;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;


/**
 * Created by Marvin on 16/5/7.
 */
public class TestCar {

    @Test
    public void testCar() throws Exception {
        Person p1 = new Person();
        Person p2 = new Person();
        p1.setHands("hands p1");
        p2.setHands("hands p2");
        p1.intro();
        p2.intro();

    }

    @Test
    public void testHashcode() throws Exception {
        Car a = new Car("a");
        Car b = new Car("b");
        Car c = new Car("c");
        Set<Car> carSet = new HashSet<>();
        carSet.add(a);
        carSet.add(b);
        carSet.add(c);
//        for (Car e : carSet) {
//            System.out.println(e.getEngine());
//        }
        a.setEngine("new a");
        for (Car e : carSet) {
            System.out.println(e.getEngine());
        }
    }
}
