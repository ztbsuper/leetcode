package coach;

/**
 * Created by Marvin on 16/5/7.
 */
public class Car {
    private String engine;
    private String window;
    private String wheel;

    public Car() {

    }

    public Car(String engine) {
        this();
        this.engine = engine;
    }

    public Car(String window, String engine) {
        this(engine);
        this.window = window;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getWindow() {
        return window;
    }

    public void setWindow(String window) {
        this.window = window;
    }

    public String getWheel() {
        return wheel;
    }

    public void setWheel(String wheel) {
        this.wheel = wheel;
    }

    private void runit() {
        System.out.println("run it");
    }

}
