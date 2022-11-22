package Departments.Department.Repository;

import Departments.Department.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {


    Department findDepartmentById(Integer id) ;

}
