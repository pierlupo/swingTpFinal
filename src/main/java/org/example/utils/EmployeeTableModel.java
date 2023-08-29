package org.example.utils;


import org.example.model.Employee;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class EmployeeTableModel extends AbstractTableModel {
    private List<Employee> employeeList;
    private String[] columnNames = {"ID", "Name","Gender","BloodGroup","ContactNo","Qualification","Address","Image"};

    public EmployeeTableModel(List<Employee> employeeList) {

        this.employeeList = employeeList;
    }

    @Override
    public int getRowCount() {
        return employeeList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return getValueAt(0, columnIndex).getClass();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Employee employee = employeeList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return employee.getId();
            case 1:
                return employee.getName();
            case 2:
                return employee.getGender();
            case 3:
                return employee.getBloodGroup();
            case 4:
                return employee.getContactNo();
            case 5:
                return employee.getQualifification();
            case 6:
                return employee.getAddress();
            case 7:
                return employee.getImage();
            default:
                return null;
        }
    }
}
