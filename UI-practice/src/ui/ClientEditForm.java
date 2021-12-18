package ui;

import EntityManager.Client;

import javax.swing.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

class ClientEditForm extends BaseForm{
    private JTextField idTextField;
    private JTextField firstNameTextField;
    private JTextField lastNameTextField;
    private JTextField PatrTextField;
    private JComboBox birthdayDay;
    private JComboBox birthdayMonth;
    private JComboBox birthdayYear;
    private JLabel id;
    private JLabel firstName;
    private JLabel LastName;
    private JLabel Patronymic;
    private JLabel Birthday;
    private JLabel RegistrationDate;
    private JComboBox regDateDay;
    private JComboBox regDateMonth;
    private JComboBox regDateYear;
    private JTextField emailTextField;
    private JTextField phoneTextField;
    private JComboBox genderComboBox;
    private JLabel GenderCode;
    private JLabel Phone;
    private JLabel Email;
    private JPanel Actions;
    private JButton GoBackButton;
    private JButton DeleteButton;
    private JButton SaveButton;
    private JPanel EditPanel;
    private Client client;

    public ClientEditForm(MainForm mainForm, Client client){
        super(600, 400);
        this.client = client;

        setContentPane(EditPanel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        initFields();
        initBoxes();
        initButtons();

        setVisible(true);
    }

    private void initButtons() {
        SaveButton.addActionListener(e -> {

        });
    }

    private void initBoxes() {
        GregorianCalendar birthdayCalendar = new GregorianCalendar();
        GregorianCalendar regDateCalendar = new GregorianCalendar();

        birthdayCalendar.setTime(client.getBirthday());
        regDateCalendar.setTime(client.getRegistrationDate());

        for(int i=1; i<=31; i++) {
            regDateDay.addItem(i);
            birthdayDay.addItem(i);
        }
        birthdayDay.setSelectedItem(birthdayCalendar.get(Calendar.DAY_OF_MONTH));
        regDateDay.setSelectedItem(regDateCalendar.get(Calendar.DAY_OF_MONTH));


        for(int i=1940; i<=2021; i++) {
            birthdayYear.addItem(i);
            regDateYear.addItem(i);
        }
        birthdayYear.setSelectedItem(birthdayCalendar.get(Calendar.YEAR));
        regDateYear.setSelectedItem(regDateCalendar.get(Calendar.YEAR));
//

        for(int i = 1; i<13; i++){
            birthdayMonth.addItem(i);
            regDateMonth.addItem(i);
        }
        birthdayMonth.setSelectedItem(birthdayCalendar.get(Calendar.MONTH));
        regDateMonth.setSelectedItem(regDateCalendar.get(Calendar.MONTH));

        genderComboBox.addItem('м');
        genderComboBox.addItem('ж');
        genderComboBox.setSelectedItem(client.getGenderCode());
    }

    private void initFields() {
        idTextField.setEnabled(false);
        idTextField.setText(String.valueOf(client.getId()));
        firstNameTextField.setText(client.getFirstName());
        lastNameTextField.setText(client.getLastName());
        PatrTextField.setText(client.getPatronymic());
        emailTextField.setText(client.getEmail());
        phoneTextField.setText(client.getPhone());
    }

}
