package pl.infinitetech.crudjava.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.infinitetech.crudjava.client.service.UserService;
import pl.infinitetech.crudjava.employee.dto.EmployeeLogin;
import pl.infinitetech.crudjava.employee.dto.EmployeeRequest;
import pl.infinitetech.crudjava.employee.model.EmployeeEntity;
import pl.infinitetech.crudjava.employee.service.EmployeeService;


@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/employee")
    public ResponseEntity<Object> addEmployee(@RequestBody EmployeeRequest employee) {
        EmployeeEntity employeeEntity = employeeService.addEmployee(employee);
        return ResponseEntity.status(200).body(employeeEntity);
    }


    @PostMapping ("/login")
    public ResponseEntity<Object> login(@RequestBody EmployeeLogin employee) {
        Boolean checkPassword = employeeService.checkPassword(employee);
        return ResponseEntity.status(200).body(checkPassword);
    }
}
