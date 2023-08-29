package org.example.dao;

import org.example.model.Address;
import org.example.model.Employee;
import org.example.utils.ConnectionUtil;

import java.sql.*;

public class AddressDao {

    private Connection con;

    private PreparedStatement ps;

    public int addAddress(Address address) throws SQLException {

        con = ConnectionUtil.getConnection();
        ps = con.prepareStatement("INSERT INTO `Address` (`street`, `town`) VALUES (?, ?) ");
        ps.setString(1, address.getStreet());
        ps.setString(2, address.getTown());

        int n = ps.executeUpdate();
        // con.close();
        return n;

    }

    public void deleteAddress(int id) throws SQLException {

        con = ConnectionUtil.getConnection();
        ps = con.prepareStatement("DELETE FROM `address` WHERE id = ?");
        ps.setInt(1, id);
        ps.executeUpdate();
        //   con.close();
    }

    public int updateAddress(Address address) throws SQLException {

        con = ConnectionUtil.getConnection();
        ps = con.prepareStatement("UPDATE `address` SET street = ?, town = ? WHERE id = ?");
        ps.setString(1, address.getStreet());
        ps.setString(2, address.getTown());
        ps.executeUpdate();
        int n = ps.executeUpdate();
        con.close();
        return n;

    }

    public Address getAddressById(int id) {

        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Address address = null;

        try {

            String query = "SELECT * FROM address WHERE id = ?";
            statement = con.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                address = new Address();
                address.setId(resultSet.getInt("id"));
                ps.setString(1, address.getStreet());
                ps.setString(2, address.getTown());

                //ps.setInt(10, address.getId());

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return address;
    }
}
