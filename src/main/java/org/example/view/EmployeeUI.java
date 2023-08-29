package org.example.view;


import org.example.controller.AddressController;
import org.example.controller.EmployeeController;
import org.example.model.Employee;
import org.example.model.Qualification;
import org.example.utils.EmployeeTableModel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class EmployeeUI extends JFrame {

    private EmployeeController employeeController;
    private AddressController addressController;
    private JFrame frame;
    private JTable employeeTable;

    private JButton btnSearch;
    private JButton newButton;
    private JButton saveButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton clearButton;
    private JButton printButton;

    //private JSeparator separator;


    public EmployeeUI() throws SQLException {
        this.employeeController = new EmployeeController();
        this.addressController = new AddressController();
        initializeUI();
    }

    private void initializeUI() throws SQLException {

        //JFrame frame = new JFrame();
        frame = new JFrame("Employees Management Sys");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);


        employeeTable = new JTable();

        refreshTable();

        btnSearch = new JButton("SEARCH");
        newButton = new JButton("New");
        saveButton = new JButton("Save");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        clearButton = new JButton("Clear");
        printButton = new JButton("Print");

        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //  search();
            }
        });

        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              //  openAddDialog();
                JLabel qualifLabel = new JLabel("Qualification:");
                JRadioButton jRadioButton = new JRadioButton(String.valueOf(Qualification.LICENCE));
                JRadioButton jRadioButton1 = new JRadioButton(String.valueOf(Qualification.MASTER));
                JRadioButton jRadioButton2 = new JRadioButton("DOCTOR");
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            //    save();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             //   openModificationDialog();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            //    deleteSelectedEmployee();
            }
        });


        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             //   clear();
            }
        });

        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              //  printEmp();
            }
        });


        //separator = new JSeparator(JSeparator.VERTICAL);

        JPanel buttonPanel = new JPanel();

        JLabel searchLabel = new JLabel("SEARCH:");
        JTextField searchTextField = new JTextField(10);
        buttonPanel.add(searchLabel);
        buttonPanel.add(searchTextField);
        buttonPanel.add(newButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(printButton);

        JLabel employeeIdLabel = new JLabel("EmployeeID:");
        JTextField employeeIdTextField = new JTextField(15);
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameTextField = new JTextField(15);
        JLabel ageLabel = new JLabel("Age:");
        JTextField ageTextField = new JTextField(15);
        JLabel bgLabel = new JLabel("BloodGroup:");
        JTextField bgTextField = new JTextField(15);
        JLabel ContactNoLabel = new JLabel("ContactNo:");
        JTextField ContactNoTextField = new JTextField(15);
        JRadioButton maleRadioButton = new JRadioButton("Male");
        JRadioButton femaleRadioButton = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
                genderGroup.add(maleRadioButton);
                genderGroup.add(femaleRadioButton);


        JPanel employeePanel = new JPanel(new GridBagLayout()); // Crée un panneau avec un gestionnaire de disposition GridBagLayout
        GridBagConstraints constraints = new GridBagConstraints(); // Crée des contraintes pour le placement des composants
        constraints.insets = new Insets(5, 5, 5, 5);

        employeePanel.add(employeeIdLabel);
        employeePanel.add(employeeIdTextField);
        employeePanel.add(nameLabel);
        employeePanel.add(nameTextField);
        employeePanel.add(maleRadioButton);
        employeePanel.add(femaleRadioButton);
        employeePanel.add(ageLabel);
        employeePanel.add(ageTextField);
        employeePanel.add(bgLabel);
        employeePanel.add(bgTextField);
        employeePanel.add(ContactNoLabel);
        employeePanel.add(ContactNoTextField);

        constraints.gridx = 0;
        constraints.gridy = 0;
        employeePanel.add(employeeIdLabel, constraints);

        constraints.gridx = 1;
        employeePanel.add(employeeIdTextField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        employeePanel.add(nameLabel, constraints);

        constraints.gridx = 1;
        employeePanel.add(nameTextField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        employeePanel.add(new JLabel("Genre:"), constraints);

        constraints.gridx = 1;
        employeePanel.add(maleRadioButton, constraints);

        constraints.gridx = 2;
        employeePanel.add(femaleRadioButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        employeePanel.add(ageLabel, constraints);

        constraints.gridx = 1;
        employeePanel.add(ageTextField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        employeePanel.add(bgLabel, constraints);

        constraints.gridx = 1;
        employeePanel.add(bgTextField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 5;
        employeePanel.add(ContactNoLabel, constraints);

        constraints.gridx = 1;
        employeePanel.add(ContactNoTextField, constraints);

        constraints.gridwidth = 3;
        constraints.weightx = 3;



//        JLabel qualifLabel = new JLabel("Qualification:");
//        JComboBox<String> roleComboBox = new JComboBox<>(new String[]{"LICENCE", "MASTER", "DOCTOR"});
//        qualifComboBox.setSelectedItem(selectedQualif.getQualification());

        Border empFormBorder = BorderFactory.createLineBorder(Color.black);
        employeePanel.setBorder(empFormBorder);


        Border buttonBorder = BorderFactory.createLineBorder(Color.black);
        buttonPanel.setBorder(buttonBorder);

        Border tableBorder = BorderFactory.createLineBorder(Color.black);
        employeeTable.setBorder(tableBorder);

        frame.setLayout(new BorderLayout(50,50));
        frame.add(employeePanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(new JScrollPane(employeeTable), BorderLayout.SOUTH);

        frame.setVisible(true);
    }

        private void refreshTable () throws SQLException {
            List<Employee> employeeList = employeeController.getAllEmployees();
            EmployeeTableModel model = new EmployeeTableModel(employeeList);
            employeeTable.setModel(model);
        }








}