package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Employee;
import com.company.repositories.interfaces.IEmployeeRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private final IDB db;

    public EmployeeRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createUser(Employee employee) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO users(name, surname,gender, mail, JobPosition, salary ) VALUES (?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, employee.getName());
            st.setString(2, employee.getSurname());
            st.setBoolean(3, employee.getGender());
            st.setString(4, employee.getMail());
            st.setString(5, employee.getJobPosition());
            st.setInt(6, employee.getSalary());


            boolean executed = st.execute();
            return executed;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Employee getUser(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,surname,gender, mail, JobPosition, salary  FROM users WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Employee employee = new Employee
                        (rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getBoolean("gender"),
                        rs.getString("mail"),
                        rs.getString("JobPosition"),
                        rs.getInt("salary"));



                return employee;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }


    @Override
    public List<Employee> getAllEmployees() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,surname,gender FROM users";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Employee> employees = new ArrayList<>();
            while (rs.next()) {
                Employee employee = new Employee
                                (rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("surname"),
                                rs.getBoolean("gender"),
                                rs.getString("mail"),
                                rs.getString("JobPosition"),
                                rs.getInt("salary"));

                employees.add(employee);
            }

            return employees;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Employee> getAllUsers() {
        return null;
    }
}