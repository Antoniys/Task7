package entity;

public class Department {
    private int id_department;
    private char name_department;
    private char phone_department;

    public Department() {
    }

    public int getId_department() {
        return id_department;
    }

    public void setId_department(int id_department) {
        this.id_department = id_department;
    }

    public char getName_department() {
        return name_department;
    }

    public void setName_department(char name_department) {
        this.name_department = name_department;
    }

    public char getPhone_department() {
        return phone_department;
    }

    public void setPhone_department(char phone_department) {
        this.phone_department = phone_department;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id_department=" + id_department +
                ", name_department=" + name_department +
                ", phone_department=" + phone_department +
                '}';
    }
}
