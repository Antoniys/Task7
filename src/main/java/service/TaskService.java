package service;

import BD.MyConnection;
import dao.DaoTask;
import entity.Task;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskService extends MyConnection implements DaoTask {
    final static Logger logger = Logger.getLogger(WorkerService.class);
    Connection connection = getConnection();

    @Override
    public List<Task> getAllTask() throws SQLException { //работает
        List<Task> tasks = new ArrayList<>();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select *from task");
            while (resultSet.next()) {
                Task task = new Task();
                task.setId(resultSet.getInt(1));
                task.setTask(resultSet.getString(2));
                task.setId_worker(resultSet.getInt(3));
                tasks.add(task);
                logger.info("Task ( id : " + task.getId() + ", exercise : " + task.getTask() + ", worker id : " +
                        task.getId_worker() + ")");
            }
        } catch (SQLException e) {
            logger.error("Error in method 'getAllTask'! ");
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return tasks;
    }

    @Override
    public void createNewTaskByWorker(Task task) throws SQLException { //работает
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("insert into task (id_task, exercise, id_worker)VALUES (?,?,?)");

            preparedStatement.setInt(1, task.getId());
            preparedStatement.setString(2, task.getTask());
            preparedStatement.setInt(3, task.getId_worker());
            preparedStatement.executeUpdate();

            logger.info("Task ( id : " + task.getId() + ", exercise : " + task.getTask() + ", worker id : " +
                task.getId_worker() + ")");
        } catch (SQLException e) {
            logger.error("Error in method 'createNewTaskByWorker'! ");
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
