package BD;

import entity.Department;
import entity.Task;
import entity.Worker;
import service.DepartmentService;
import service.TaskService;
import service.WorkerService;

import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        WorkerService ws=new WorkerService();
        TaskService ts=new TaskService();
        DepartmentService ds=new DepartmentService();
        List<Worker>workers=ds.getWorkerByDepartment(3);
        for (Worker worker:workers) {
            System.out.println(worker);
        }
        //Test method getTaskByWorker


        // Test method createNewTaskByWorker
     //   ts.createNewTaskByWorker(new Task(7,"by",3));
    }
}
