package com.luv2code.crud.demo;

import com.luv2code.crud.demo.dao.StudentDAO;
import com.luv2code.crud.demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);
			//createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//queryStudent(studentDAO);
			//queryStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			deleteStudent(studentDAO);
		};
	}

	private void deleteStudent(StudentDAO studentDAO) {

		int studentId = 3;
		System.out.println("Deleting student id " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		Student student = studentDAO.findById(1);
		student.setLastName("Burkhard-Ramirez");
		studentDAO.update(student);
		student = studentDAO.findById(1);
		System.out.println(student);
	}

	private void queryStudentsByLastName(StudentDAO studentDAO) {
		List<Student> results = studentDAO.findByLastName("Burkhard");
		for (Student s : results) {
			System.out.println(s);
		}
	}

	private void queryStudent(StudentDAO studentDAO) {
		System.out.println("Looking for students");
		List<Student> students = studentDAO.findAll();
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating a student");
		Student student = new Student("Matthew", "Burkhard", "matt.burkhard@gmail.com");
		System.out.println("Does it have an id???" + student.getId());
		System.out.println("Saving student");
		studentDAO.save(student);
		int id = student.getId();
		System.out.println("Saved student. ID: " + id);
		System.out.println("Retrieving student of id " + id);
		Student foundStudent = studentDAO.findById(id);
		System.out.println("Found student: " + foundStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// create student object
		System.out.println("Creating several new students");
		Student student1 = new Student("Sophia1", "Ramirez1", "Sophia1.Ramirez@SophiaRamirez.com");
		Student student2 = new Student("Sophia2", "Ramirez2", "Sophia2.Ramirez@SophiaRamirez.com");
		Student student3 = new Student("Sophia3", "Ramirez3", "Sophia3.Ramirez@SophiaRamirez.com");

		// save student object
		System.out.println("Saving several students");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);

		// display id of saved student
		System.out.println("Saved students. Generated IDs: " );
		System.out.println(String.format("%s, %s, %s", student1.getId(), student2.getId(), student3.getId()));
	}

	private void createStudent(StudentDAO studentDAO) {
		// create student object
		System.out.println("Creating a new student");
		Student student = new Student("Sophia", "Ramirez", "Sophia.Ramirez@SophiaRamirez.com");

		// save student object
		System.out.println("Saving a new student");
		studentDAO.save(student);

		// display id of saved student
		System.out.println("Saved student. Generated ID: " + student.getId());
	}

}
