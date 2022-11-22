package Departments.Department.Service;

import Departments.Department.DepartmentApplication;
import Departments.Department.Entity.Department;
import Departments.Department.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository dRepository;

    public Department saveDepartment(Department department){
        return dRepository.save(department);
    }

    public Department findDepartmentById(Integer id) {
        return dRepository.findDepartmentById(id);
    }


    public void deleteDepartmentById(Integer id) {
         dRepository.deleteById(id);
    }

    public Department updateDepartment(Integer id) {
        Department department = dRepository.findDepartmentById(id);
         department.setId(department.getId());
        department.setAddress(department.getAddress());
        department.setName(department.getName());
        return dRepository.save(department);
    }
}
