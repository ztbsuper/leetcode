package coach;

import org.junit.Test;

/**
 * Created by Marvin on 16/5/11.
 */
public class TestFunction {

    @Test
    public void testFunction() throws Exception {
        runFunction("ABCD", new Function() {
            @Override
            public void apply(String s) {
                System.out.println(s);
            }
        });
        System.out.println("==");

        runFunction("ABCD", new Function() {
            @Override
            public void apply(String s) {
                System.out.println(s);
                System.out.println(s);
                System.out.println(s);
                System.out.println(s);
            }
        });

    }

    void runFunction(String s, Function f) {
        f.apply(s);
    }

    long runCalFn(int x, int y, CalcFunction fn) {
        return fn.apply(x, y);
    }


    @Test
    public void testCalFunction() throws Exception {
        int x = 10, y = 5;

        runCalFn(x, y, new CalcFunction() {
            @Override
            public long apply(int x, int y) {
                return x + y;
            }
        });


        System.out.println(runCalFn(x, y, new CalcFunction() {
            @Override
            public long apply(int x, int y) {
                return x + y;
            }
        }));


        System.out.println(runCalFn(x, y, new CalcFunction() {
            @Override
            public long apply(int x, int y) {
                return x - y;
            }
        }));

    }

    @Test
    public void testClass() throws Exception {
        Class<Car> carClass = Car.class;
        System.out.println(carClass);

    }


    @Test
    public void testCallback() throws Exception {
        aCallbackFn(new Function() {
            @Override
            public void apply(String s) {
                System.out.println("result is :" + s);
            }
        });
    }

    void aCallbackFn(Function fn) {
        System.out.println("1");
        System.out.println("2");
        String result = "success";
        fn.apply(result);
    }
}
