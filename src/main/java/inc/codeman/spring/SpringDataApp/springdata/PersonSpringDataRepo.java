package inc.codeman.spring.SpringDataApp.springdata;

import inc.codeman.spring.SpringDataApp.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonSpringDataRepo extends JpaRepository<Person,Integer> {
    List<Person> findByName(String name);
    List<Person> findByLocation(String location);
    List<Person> findByNameAndLocation(String name, String location);
}
