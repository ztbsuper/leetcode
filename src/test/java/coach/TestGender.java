package coach;

import org.junit.Test;

/**
 * Created by Marvin on 16/5/12.
 */
public class TestGender {

    @Test
    public void testGender() throws Exception {
        Class<Gender> genderClass = Gender.class;
        Gender female = Enum.valueOf(Gender.class, "FEMALE");
//
//
//        System.out.println(female);
//        Gender male = Enum.valueOf(Gender.class, "MALE");
//        System.out.println(male);
//        PersonEnum personEnum = Enum.valueOf(PersonEnum.class, "MALE");
//        System.out.println(personEnum);
//
//        Class<PersonEnum> personEnumClass = PersonEnum.class;
//
//        PersonEnum newInstance = personEnumClass.newInstance();
//
//        Set<Person> personSet = new HashSet<>();
//
//
//        String str = "coach.Person";
//        Class<?> aClass = Class.forName(str);
//        Object o = aClass.newInstance(); //  Object o = new Person();
//        System.out.println(o instanceof Person);
        run(run1(), run2());
    }


    int run1() {
        System.out.println("1");
        return 3;
    }

    int run2() {
        System.out.println("2");
        return 4;
    }

    void run(int x, int y) {
        System.out.println("x:" + x + "y:" + y);
    }
}
