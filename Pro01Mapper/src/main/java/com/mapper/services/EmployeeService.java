package com.mapper.services;

import com.mapper.entities.Employee;
import com.mapper.mappers.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;


    public Employee getOne(Employee employeeQueryCondition) {
        return employeeMapper.selectOne(employeeQueryCondition);
    }

    public Employee getEmployeeById(Integer empId) {
        return  employeeMapper.selectByPrimaryKey(empId);
    }


    public void saveEmployee(Employee employee) {
        employeeMapper.insert(employee);
    }

    public List<Employee> getEmployeeByExample(Example example) {
        return employeeMapper.selectByExample(example);
    }
}
