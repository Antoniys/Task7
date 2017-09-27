package dao;

import entity.Task;
import entity.Worker;

import java.sql.SQLException;
import java.util.List;

public interface DaoWorker {
    List<Worker> getAllWorker() throws SQLException;
    List<Task> getTaskByWorker(int id) throws SQLException;
    void deleteWorker(int id) throws SQLException;
    void createNewWorker(Worker worker) throws SQLException;
}
