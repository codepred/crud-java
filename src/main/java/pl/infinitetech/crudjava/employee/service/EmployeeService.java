package pl.infinitetech.crudjava.employee.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.infinitetech.crudjava.employee.dto.EmployeeLogin;
import pl.infinitetech.crudjava.employee.dto.EmployeeRequest;
import pl.infinitetech.crudjava.employee.model.EmployeeEntity;
import pl.infinitetech.crudjava.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    private ModelMapper modelMapper;

    public EmployeeEntity addEmployee(EmployeeRequest employeeRequest){
        EmployeeEntity employeeEntity = this.modelMapper.map(employeeRequest, EmployeeEntity.class);
        return employeeRepository.save(employeeEntity);
    }

    public boolean checkPassword(EmployeeLogin employeeLogin){
        EmployeeEntity employeeEntity = employeeRepository.findByEmailAndPassword(employeeLogin.getEmail(),employeeLogin.getPassword());
        if(employeeEntity == null){
            return false;
        }
        return true;
    }

}
