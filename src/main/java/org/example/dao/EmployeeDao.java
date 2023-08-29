package org.example.dao;

import org.example.model.Address;
import org.example.model.Employee;
import org.example.model.Image;
import org.example.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDao{

    private Connection con;
    private AddressDao addressDao;
    private PreparedStatement ps;


    public int addEmployee(Employee employee) throws SQLException {

        con = ConnectionUtil.getConnection();
        ps = con.prepareStatement("INSERT INTO `employee` (`name`,`gender`,`age`,`blood_group`,`contact_no`,`qualifification`,`startDate`,`address`,`image`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ");
        ps.setString(1, employee.getName());
        ps.setString(2, employee.getGender());
        ps.setInt(3, employee.getAge());
        ps.setString(4, employee.getBloodGroup());
        ps.setString(5, employee.getContactNo());
        ps.setString(6, employee.getQualifification());
        ps.setDate(7, (Date) employee.getStartDate());
        ps.setObject(8, employee.getAddress());
        ps.setObject(9, employee.getImage());
        int n = ps.executeUpdate();
       // con.close();
        return n;

    }

    public void deleteEmployee(int id) throws SQLException {

        con = ConnectionUtil.getConnection();
        ps = con.prepareStatement("DELETE FROM `employee` WHERE id = ?");
        ps.setInt(1, id);
        ps.executeUpdate();
     //   con.close();
    }

    public int updateEmployee(Employee employee) throws SQLException {

        con = ConnectionUtil.getConnection();
        ps = con.prepareStatement("UPDATE `contact` SET name = ?, gender = ?, age = ?, blood_group = ?, contact_no = ?, qualifification = ?, startDate = ?, address = ?, image = ? WHERE id = ?");
        ps.setString(1, employee.getName());
        ps.setString(2, employee.getGender());
        ps.setInt(3, employee.getAge());
        ps.setString(4, employee.getBloodGroup());
        ps.setString(5, employee.getContactNo());
        ps.setString(6, employee.getQualifification());
        ps.setDate(7, (Date) employee.getStartDate());
        ps.setObject(8, employee.getAddress());
        ps.setObject(9, employee.getImage());
        ps.setInt(10, employee.getId());
        ps.executeUpdate();
        int n = ps.executeUpdate();
        con.close();
        return n;

    }

    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> empList = new ArrayList<>();
        String query = "SELECT * FROM employee";
        con = ConnectionUtil.getConnection();
        try (PreparedStatement preparedStatement = con.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setGender(resultSet.getString("gender"));
                employee.setBloodGroup(resultSet.getString("bloodGroup"));
                employee.setContactNo(resultSet.getString("contact_no"));
                employee.setQualifification(resultSet.getString("qualification"));
                employee.setStartDate(resultSet.getDate("date"));
                employee.setAddress((Address) resultSet.getObject("address"));
                employee.setImage((Image) resultSet.getObject("image"));
                int id = resultSet.getInt("department_id");
                Address address;
                if( addressDao.getAddressById(id)!= null){
                    address = addressDao.getAddressById(id);
                }else{
                    address = null;
                }
                // Vous devrez charger le département associé ici
                employee.setAddress(address);
                empList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empList;
    }

    public Employee getEmployeeById(int id) {

        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Employee employee = null;

        try {

            String query = "SELECT * FROM employee WHERE id = ?";
            statement = con.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                ps.setString(1, employee.getName());
                ps.setString(2, employee.getGender());
                ps.setInt(3, employee.getAge());
                ps.setString(4, employee.getBloodGroup());
                ps.setString(5, employee.getContactNo());
                ps.setString(6, employee.getQualifification());
                ps.setDate(7, (Date) employee.getStartDate());
                ps.setObject(8, employee.getAddress());
                ps.setObject(9, employee.getImage());
                //ps.setInt(10, employee.getId());

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employee;
    }
}