package ui;

import EntityManager.Client;
import ui.BaseForm;
import ui.MainForm;

import javax.swing.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

class ClientAddForm extends BaseForm {
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
    private JButton SaveButton;
    private JPanel EditPanel;
    private Client client;

    public ClientAddForm(MainForm mainForm, Client client) {
        super(600, 400);
        this.client = client;

        setContentPane(EditPanel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

//        initFields();
        initBoxes();
        initButtons();

        setVisible(true);
    }

    private void initButtons() {
        SaveButton.addActionListener(e -> {

            String firstName = client.getFirstName();
            if(firstName.isEmpty() || firstName.length() > 50){
                JOptionPane.showMessageDialog(this, "Имя слишком короткое или больше 50 символов", " Ошибка", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String lastName = client.getLastName();
            if(lastName.isEmpty() || lastName.length() > 50){
                JOptionPane.showMessageDialog(this, "Фамилия слишком короткое или больше 50 символов", " Ошибка", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String Patronymic = client.getPatronymic();
            if(Patronymic.isEmpty() || Patronymic.length() > 50){
                JOptionPane.showMessageDialog(this, "Отчество слишком короткое или больше 50 символов", " Ошибка", JOptionPane.ERROR_MESSAGE);
                return;
            }

            GregorianCalendar calendar = new GregorianCalendar();
            calendar.set(Calendar.MONTH, (Integer) birthdayMonth.getSelectedItem());
            calendar.set(Calendar.YEAR, (Integer) birthdayYear.getSelectedItem());
            int days = (int) birthdayDay.getSelectedItem();
            if( days > calendar.getActualMaximum(Calendar.DAY_OF_MONTH)){
                JOptionPane.showMessageDialog(this, "В этом месяце нет такого количества дней", " Ошибка", JOptionPane.ERROR_MESSAGE);
                return;
            }
            calendar.set(Calendar.DAY_OF_MONTH, days);
            Date birthday = calendar.getTime();

            GregorianCalendar calendar2 = new GregorianCalendar();
            calendar2.set(Calendar.MONTH, (Integer) regDateMonth.getSelectedItem());
            calendar2.set(Calendar.YEAR, (Integer) regDateYear.getSelectedItem());
            days = (int) regDateDay.getSelectedItem();
            if( days > calendar2.getActualMaximum(Calendar.DAY_OF_MONTH)){
                JOptionPane.showMessageDialog(this, "В этом месяце нет такого количества дней", " Ошибка", JOptionPane.ERROR_MESSAGE);
                return;
            }
            calendar.set(Calendar.DAY_OF_MONTH, days);
            Date regDate = calendar2.getTime();

            String email = client.getEmail();
            if(email.isEmpty() || email.length() > 50){
                JOptionPane.showMessageDialog(this, "Email слишком короткое или больше 50 символов", " Ошибка", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String phone = client.getPhone();
            if(phone.isEmpty() || phone.length() > 50){
                JOptionPane.showMessageDialog(this, "Номер телефона слишком короткое или больше 50 символов", " Ошибка", JOptionPane.ERROR_MESSAGE);
                return;
            }

            char gender = (char) genderComboBox.getSelectedItem();

            Client client = new Client() // дописать поля клиента 


//            Date birthday = client.getBirthday();


        });
    }

    private void initBoxes() {
        for (int i = 1; i <= 31; i++) {
            regDateDay.addItem(i);
            birthdayDay.addItem(i);
        }
        for (int i = 1940; i <= 2021; i++) {
            birthdayYear.addItem(i);
            regDateYear.addItem(i);
        }
        for (int i = 1; i < 13; i++) {
            birthdayMonth.addItem(i);
            regDateMonth.addItem(i);
        }
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
