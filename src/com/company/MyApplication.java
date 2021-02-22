package com.company;

import com.company.controllers.EmployeeController;
import com.company.repositories.interfaces.IEmployeeRepository;

import java.util.Scanner;

public class MyApplication {
    private final EmployeeController controller;
    private final Scanner scanner;

    public MyApplication(IEmployeeRepository userRepository) {
        controller = new EmployeeController(userRepository);
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option:");
            System.out.println("1. Get all users");
            System.out.println("2. Get user by id");
            System.out.println("3. Create user");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-3): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllEmployeesMenu();
                } else if (option == 2) {
                    getEmployeeByIdMenu();
                } else if (option == 3) {
                    createEmployeeMenu();
                }


                else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.next(); // to ignore incorrect input
            }

            System.out.println("*************************");

        }
    }

    public void getAllEmployeesMenu() {
        String response = controller.getAllEmployees();
        System.out.println(response);
    }

    public void getEmployeeByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        String response = controller.getEmployee(id);
        System.out.println(response);
    }

    public void createEmployeeMenu() {
        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter surname");
        String surname = scanner.next();
        System.out.println("Please enter gender (male/female)");
        String gender = scanner.next();
        System.out.println("Please enter mail");
        String mail = scanner.next();
        System.out.println("Please enter position of your job");
        String JobPosition= scanner.next();
        System.out.println("Please enter your salary");
        int salary = scanner.nextInt();


        String response = controller.createEmployee(name, surname, gender,mail,JobPosition,salary);
        System.out.println(response);
    }
}