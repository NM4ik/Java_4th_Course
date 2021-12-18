package EntityManager;

import java.util.Date;

public class Client {
    private int id;
    private String firstName;
    private String LastName;
    private String Patronymic;
    private Date Birthday;
    private Date RegistrationDate;
    private String Email;
    private String Phone;
    private char GenderCode;

    public Client(int id, String firstName, String lastName, String patronymic, Date birthday, Date registrationDate, String email, String phone, char genderCode) {
        this.id = id;
        this.firstName = firstName;
        this.LastName = lastName;
        this.Patronymic = patronymic;
        this.Birthday = birthday;
        this.RegistrationDate = registrationDate;
        this.Email = email;
        this.Phone = phone;
        this.GenderCode = genderCode;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", Имя='" + firstName + '\'' +
                ", Фамилия='" + LastName + '\'' +
                ", Отчество='" + Patronymic + '\'' +
                ", День рождение=" + Birthday +
                ", Дата регистрации=" + RegistrationDate +
                ", Почта='" + Email + '\'' +
                ", Телефон='" + Phone + '\'' +
                ", Пол=" + GenderCode +
                '}' + '\n';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPatronymic() {
        return Patronymic;
    }

    public void setPatronymic(String patronymic) {
        Patronymic = patronymic;
    }

    public Date getBirthday() {
        return Birthday;
    }

    public void setBirthday(Date birthday) {
        Birthday = birthday;
    }

    public Date getRegistrationDate() {
        return RegistrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        RegistrationDate = registrationDate;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public char getGenderCode() {
        return GenderCode;
    }

    public void setGenderCode(char genderCode) {
        GenderCode = genderCode;
    }
}
