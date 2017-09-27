package dao;

import entity.Department;
import entity.Worker;

import java.util.List;

public interface DaoDepartment {
    List<Worker> getWorkerByDepartment(int id);
}
