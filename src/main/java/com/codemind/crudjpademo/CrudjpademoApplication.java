package com.codemind.crudjpademo;

import com.codemind.crudjpademo.dao.StudentDAO;
import com.codemind.crudjpademo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudjpademoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudjpademoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner->{
			saveStudent(studentDAO);
//			findStudentByFN(studentDAO);
//			readAllStudent(studentDAO);
//			deleteStudentByFirstName(studentDAO);
//			deleteAllTheStudents(studentDAO);
		};
	}

	private void deleteAllTheStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all the students: ");
		System.out.println("Total "+studentDAO.deleteAll()+" Students are deleted");
	}

	private void deleteStudentByFirstName(StudentDAO studentDAO) {
		Student myStudent=studentDAO.findByFirstName("ABC");
		System.out.println("Delete student by their First Name: "+myStudent.getFirstName());
		int rows=0;
		studentDAO.deleteStudent(myStudent.getId());
		System.out.println("Delete the student which id is: "+myStudent.getId());
	}

	private void readAllStudent(StudentDAO studentDAO) {
		System.out.println("Fetching All Students: ");
		List<Student> students=studentDAO.findAllStudent();

		for(Student student:students){
			System.out.println(student);
		}
	}

	private void findStudentByFN(StudentDAO studentDAO) {
		Student myStudent=studentDAO.findByFirstName("Mohammad Faizan");
		myStudent.setEmail("mohammadfaizan@gmail.com");
		studentDAO.updateStudent(myStudent);
		System.out.println(myStudent);
	}

	private void saveStudent(StudentDAO studentDAO) {

		System.out.println("Saving the first student: ");
		Student myStudent=new Student("Abdul Aziz","Jangiwala","abdulaziz@codemind.com");
		Student myStudent1=new Student("Sakib","Singwala","sakib@codemind.com");
		Student myStudent2=new Student("Ammar","Puthawala","ammar@codemind.com");
		Student myStudent3=new Student("Fahil","Dheriwala","fahil@codemind.com");
		studentDAO.save(myStudent);
		studentDAO.save(myStudent1);
		studentDAO.save(myStudent2);
		studentDAO.save(myStudent3);
		System.out.println("Generated Student ID is: "+myStudent.getId());
		System.out.println("Generated Student ID is: "+myStudent1.getId());
		System.out.println("Generated Student ID is: "+myStudent2.getId());
		System.out.println("Generated Student ID is: "+myStudent3.getId());
	}
}
