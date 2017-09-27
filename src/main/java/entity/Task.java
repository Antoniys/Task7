package entity;

public class Task {
    private int id;
    private String task;
    private int id_worker;

    public Task() {
    }

    public Task(int id, String task, int id_worker) {
        this.id = id;
        this.task = task;
        this.id_worker = id_worker;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public int getId_worker() {
        return id_worker;
    }

    public void setId_worker(int id_worker) {
        this.id_worker = id_worker;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", task='" + task + '\'' +
                ", id_worker=" + id_worker +
                '}';
    }
}
