package com.manytomany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.manytomany.entity.Car;
import com.manytomany.entity.Person;
import com.manytomany.repository.CarRepository;
import com.manytomany.repository.PersonRepository;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class SpringBootJpaManyToManyMappingApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaManyToManyMappingApplication.class, args);
	}

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private CarRepository carRepository;

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		// insertPersonWithCar();

		// Fetching the specific Person along with the cars
		Person person = personRepository.findById(3).get();
		System.out.println("Person details: " + person);
		System.out.println("Car Details: " + person.getCars());

		// Fetching the specific Car long with the person details
		Car car = carRepository.findById(3).get();
		System.out.println("Car Details: " + car);
		System.out.println("Person Details: " + car.getPersons());

	}

	private void insertPersonWithCar() {
		// Adding one person like Mohammed Shammem
		Car car1 = new Car();
		car1.setName("BMW");

		Car car2 = new Car();
		car2.setName("Audi");

		Person person1 = new Person();
		person1.setName("Mohammed Shameem");
		person1.addCar(car1);
		person1.addCar(car2);

		personRepository.save(person1);

		// Adding one person like Adbul Rasheed Shaik
		Car car3 = new Car();
		car3.setName("Ferari");

		// Person-2
		Person person2 = new Person();
		person2.setName("Abdul Rasheed Shaik");
		person2.addCar(car3);

		personRepository.save(person2);
	}

}
