import java.util.Objects;

public class Author {
    private int id;
    private String fio;
    private String birth;
    private String gender;


    public Author(int id, String fio, String birth, String gender) {
        this.id = id;
        this.fio = fio;
        this.birth = birth;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", fio='" + fio + '\'' +
                ", birth='" + birth + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id == author.id && Objects.equals(fio, author.fio) && Objects.equals(birth, author.birth) && Objects.equals(gender, author.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fio, birth, gender);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
