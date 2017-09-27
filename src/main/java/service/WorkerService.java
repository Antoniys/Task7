package service;

import BD.MyConnection;
import dao.DaoWorker;
import entity.Task;
import entity.Worker;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WorkerService extends MyConnection implements DaoWorker {
    final static Logger logger = Logger.getLogger(WorkerService.class);
    Connection connection = getConnection();

    @Override
    public List<Worker> getAllWorker() throws SQLException { //работает
        List<Worker> workers = new ArrayList<>();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select *from worker");
            while (resultSet.next()) {
                Worker worker = new Worker();
                worker.setId(resultSet.getInt(1));
                worker.setSurname(resultSet.getString(2));
                worker.setName(resultSet.getString(3));
                worker.setPosition(resultSet.getString(4));
                worker.setId_department(resultSet.getInt(5));
                workers.add(worker);
                logger.info("Worker ( id : " + worker.getId() + ", surname : " + worker.getSurname() + ", name : " +
                        worker.getName() + ", position : " + worker.getPosition() + ", department : " + worker.getId_department() + ")");
            }
        } catch (SQLException e) {
            logger.error("Error in method 'getAllWorker'! ");
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return workers;
    }

    @Override
    public List<Task> getTaskByWorker(int id) throws SQLException {  //  работает
        List<Task> tasks = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select * from task WHERE id_worker=? ");
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Task task = new Task();
                task.setId(resultSet.getInt(1));
                task.setTask(resultSet.getString(2));
                task.setId(resultSet.getInt(3));
                tasks.add(task);

                logger.info("Task ( id : " + task.getId() + ", exercise: " + task.getTask() + ")");
            }

        } catch (SQLException e) {
            logger.error("Error in method 'getTaskByWorker'! ");
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return tasks;
    }

    @Override
    public void deleteWorker(int id) throws SQLException {  //работает
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("DELETE from worker WHERE id_worker=? ");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            logger.info("Worker with id " + id + " deleted");
        } catch (SQLException e) {
            logger.error("Error in method 'deleteWorker'! ");
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public void createNewWorker(Worker worker) throws SQLException {  //работает
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("insert into worker (id_worker, surname, name, position, id_department)VALUES (?,?,?,?,?)");

            preparedStatement.setInt(1, worker.getId());
            preparedStatement.setString(2, worker.getSurname());
            preparedStatement.setString(3, worker.getName());
            preparedStatement.setString(4, worker.getPosition());
            preparedStatement.setInt(5, worker.getId_department());

            preparedStatement.executeUpdate();
            logger.info("Worker ( id : " + worker.getId() + ", surname : " + worker.getSurname() + ", name : " +
                    worker.getName() + ", position : " + worker.getPosition() + ", department : " + worker.getId_department() + ")");
        } catch (SQLException e) {
            logger.error("Error in method 'createNewWorker'! ");
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
