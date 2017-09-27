package service;

import BD.MyConnection;
import dao.DaoDepartment;
import entity.Worker;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentService extends MyConnection implements DaoDepartment {
    Connection connection = getConnection();
    final static Logger logger = Logger.getLogger(DepartmentService.class);

    @Override
    public List<Worker> getWorkerByDepartment(int id) {     //работает
        List<Worker> workers = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select *from worker where id_department=?");
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Worker worker = new Worker();
                worker.setId(resultSet.getInt(1));
                worker.setSurname(resultSet.getString(2));
                worker.setName(resultSet.getString(3));
                worker.setPosition(resultSet.getString(4));
                worker.setId_department(resultSet.getInt(5));
                workers.add(worker);
            }
        } catch (SQLException e) {
            logger.error("Error in method 'getWorkerByDepartment'! ");
        }
        return workers;
    }
}
