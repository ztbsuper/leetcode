package coach;

/**
 * Created by Marvin on 16/5/7.
 */
public class Person {
    private String eye;
    private String mouth;
    private String hands;

    public Person() {
        System.out.println("person's constructor");
    }

    public String getMouth() {
        return mouth;
    }

    public void setMouth(String mouth) {
        this.mouth = mouth;
    }

    public String getHands() {
        return hands;
    }

    public void setHands(String hands) {
        this.hands = hands;
    }

    public String getEye() {
        return eye;
    }

    public void setEye(String eye) {
        this.eye = eye;
    }

    public void intro() {
        System.out.println("==========");
        System.out.println(this);
        System.out.println("==========");
    }

    @Override
    public String toString() {
        return "Person{" +
                "eye='" + eye + '\'' +
                ", mouth='" + mouth + '\'' +
                ", hands='" + hands + '\'' +
                '}';
    }
}
