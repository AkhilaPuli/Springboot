package Departments.Department.Controller;

import Departments.Department.Entity.Department;
import Departments.Department.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable("id") Integer id) {
        return departmentService.findDepartmentById(id);

    }

    @DeleteMapping("/{id}")
    public void deleteDepartmentById(@PathVariable Integer id){
         departmentService.deleteDepartmentById(id);
    }

    @PutMapping("/{id}")
     public Department update(@PathVariable Integer id, @RequestBody Department department){
        departmentService.updateDepartment(id);
        return department;
    }













}
