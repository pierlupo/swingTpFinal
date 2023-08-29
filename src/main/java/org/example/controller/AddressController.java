package org.example.controller;

import org.example.dao.AddressDao;
import org.example.dao.EmployeeDao;

public class AddressController {

    private AddressDao addressDao;

    public AddressController() {

        this.addressDao = new AddressDao();

    }
}
