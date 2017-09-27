package entity;

public class Worker {
        private int id;
        private String name;
        private String surname;
        private String position;
        private int id_department;

    public Worker() {
    }

    public Worker(int id, String name, String surname, String position, int id_department) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.id_department = id_department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getId_department() {
        return id_department;
    }

    public void setId_department(int id_department) {
        this.id_department = id_department;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", position='" + position + '\'' +
                ", id_department=" + id_department +
                '}';
    }
}
