package inc.codeman.spring.SpringDataApp;

import inc.codeman.spring.SpringDataApp.entity.Person;
import inc.codeman.spring.SpringDataApp.jpa.PersonJPARepository;
import inc.codeman.spring.SpringDataApp.springdata.PersonSpringDataRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.time.Instant;
import java.util.Date;

@SpringBootApplication
public class SpringDataRepoAppApplication implements CommandLineRunner {

	@Autowired
	private PersonSpringDataRepo personSpringDataRepo;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	public static void main(String[] args) {
		SpringApplication.run(SpringDataRepoAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Entity with id 10001 {}",personSpringDataRepo.findById(10001));
		logger.info("Updating the entity with id 10001 ==> {}",personSpringDataRepo.save(new Person(10001,"Mathey","Haryana",Date.from(Instant.now()))));
		logger.info("Inserting new entity {}",personSpringDataRepo.save(new Person("Mass Maha Dev","London",Date.from(Instant.now()))));
		personSpringDataRepo.deleteById(1);
		logger.info("Entity with id 1 is deleted");
		logger.info("All Persons {}",personSpringDataRepo.findAll());
		logger.info("Persons with name Mathey {}",personSpringDataRepo.findByName("Mathey"));
		logger.info("Persons in location Amsterdam {}",personSpringDataRepo.findByLocation("Amsterdam"));
		logger.info("Persons in Amsterdam with name Johny {}",personSpringDataRepo.findByNameAndLocation("Johny","Amsterdam"));
	}
}
