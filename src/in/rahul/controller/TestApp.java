package in.rahul.controller;

import java.util.Scanner;
import in.rahul.dto.Student;
import in.rahul.service.RStudentService;
import in.rahul.servicefactory.StudentServiceFactory;

public class TestApp {
	public static void main(String[] args) {
		RStudentService studentService = StudentServiceFactory.getStudentService();
		
		Scanner sc = new Scanner(System.in);
		
		int choice;
		while(true) {
			System.out.println();
			System.out.println("========== STUDENT CRUD APPLICATION MENU ==========");
			System.out.println("1. Insert a new student record into the table");
			System.out.println("2. Read/Search a student record from the table");
			System.out.println("3. Update an existing student record");
			System.out.println("4. Delete a student record from the table");
			System.out.println("5. Exit the application");
			
			System.out.println("Enter your choice from the above options:");
			choice = sc.nextInt();
			
			switch (choice) {

				case 1: {
					System.out.println("Enter the student ID:");
					int id = sc.nextInt();
					
					sc.nextLine(); // consume leftover newline
					
					System.out.println("Enter the name of the student:");
					String name = sc.nextLine();
					
					System.out.println("Enter the age of the student:");
					int age = sc.nextInt();
					sc.nextLine();
					
					System.out.println("Enter the address of the student:");
					String Address = sc.nextLine();
					
					String msg = studentService.addStudent(id, name, age, Address);
					if(msg.equalsIgnoreCase("success")) {
						System.out.println("The student record has been inserted successfully.");
					}else {
						System.out.println("Failed to insert the student record.");
					}
					break;
				}

				case 2: {
					System.out.println("Enter the student ID to search:");
					int id = sc.nextInt();
					Student s1 = studentService.searchStudent(id);
					System.out.println("The student details are shown below:");
					System.out.println(s1.toString());
					break;
				}

				case 3: {
				    System.out.println("Enter the student ID that you want to update:");
				    int id = sc.nextInt();
				    sc.nextLine(); 

				    System.out.println("Enter the updated name of the student:");
				    String name = sc.nextLine();

				    System.out.println("Enter the updated age of the student:");
				    int age = sc.nextInt();
				    sc.nextLine();

				    System.out.println("Enter the updated address of the student:");
				    String address = sc.nextLine();

				    String msg = studentService.updateStudent(id, name, age, address);

				    if (msg.equalsIgnoreCase("success")) {
				        System.out.println("The student record has been updated successfully.");
				    } else {
				        System.out.println("Failed to update the student record.");
				    }
				    break;
				}

				case 4:{
					System.out.println("Please enter the student ID that you want to delete:");
					int id = sc.nextInt();
					String msg = studentService.deleteStudent(id);
					if(msg.equalsIgnoreCase("success")) {
						System.out.println("The student record has been deleted successfully.");
					}else {
						System.out.println("Failed to delete the student record.");
					}
					break;
				}

				case 5:{
					System.out.println("Thank you for using the application. Please visit again!");
					sc.close();
					System.exit(0);
				}

				default:
					throw new IllegalArgumentException("Unexpected value entered: " + choice);
			}
		}
	}
}
