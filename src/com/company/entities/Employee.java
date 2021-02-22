package com.company.entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class Employee {
    private int id;
    private String name;
    private String surname;
    private boolean gender;
    private String mail;
    private String JobPosition;
    private int salary;

    public Employee() {

    }

    public Employee(String name, String surname, boolean gender, String mail, String JobPosition, int salary) {
        this.id=id;
        this.name=name;
        this.surname=surname;
        this.gender=gender;
        this.mail=mail;
        this.JobPosition=JobPosition;
        this.salary=salary;



    }

    public Employee(int id, String name, String surname, boolean gender, String mail, String JobPosition, int salary) {
        setId(id);
        setName(name);
        setSurname(surname);
        setGender(gender);
        setMail(mail);
        setJobPosition(JobPosition);
        setSalary(salary);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setMail(String mail) {this.mail = mail;}

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getJobPosition() {
        return JobPosition;
    }

    public void setJobPosition(String jobPosition) {
        JobPosition = jobPosition;
    }

    public String getMail() {
        return mail;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + this.id +
                ", name='" + this.name + '\'' +
                ", surname='" + this.surname + '\'' +
                ", gender=" + (this.gender ? "Male" : "Female") +
                ", mail = " + this.mail + '\'' +
                ", JobPosition = " + this.JobPosition + '\'' +
                ", salary = " + this.salary + '\'' +

                '}';
    }
}