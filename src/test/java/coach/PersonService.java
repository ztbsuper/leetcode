package coach;

import org.assertj.core.util.Lists;

import java.util.List;

/**
 * Created by Marvin on 16/5/8.
 */
public class PersonService {

    public List<Person> print2NewPerson() {
        Person p1 = new Person();
        p1.setHands("2");
        Person p2 = new Person();
        p1.intro();
        List<Person> persons = Lists.newArrayList();
        persons.add(p1);
        persons.add(p2);

        return persons;
    }


}
