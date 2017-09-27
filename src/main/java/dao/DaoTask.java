package dao;

import entity.Task;

import java.sql.SQLException;
import java.util.List;

public interface DaoTask {

    List<Task> getAllTask() throws SQLException;
    void createNewTaskByWorker(Task task) throws SQLException;

}
