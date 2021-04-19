package com.mapper.test;

import com.mapper.entities.Employee;
import com.mapper.services.EmployeeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public class EmployeeMapperTest {

    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
    private EmployeeService employeeService = applicationContext.getBean(EmployeeService.class);

    @Test
    public void testSelectOne(){
        Employee employeeQueryCondition = new Employee(null, "bob", 5560.11, null);
        Employee employeeQueryResult = employeeService.getOne(employeeQueryCondition);
        System.out.println(employeeQueryResult);
    }

    @Test
    public void testSelectByPrimaryKey(){
        Integer empId = 3;
        Employee employee = employeeService.getEmployeeById(empId);
        System.out.println(employee);
    }

    @Test
    public void testInsert(){
        Employee employee = new Employee(null, "emp01", 1000.00, 23);
        employeeService.saveEmployee(employee);
    }

    @Test
    public void testSelectByExample(){

        Example example = new Example(Employee.class);

        example.orderBy("empSalary").asc().orderBy("empAge").desc();
        example.setDistinct(true);


        Example.Criteria criteria1 = example.createCriteria();
        Example.Criteria criteria2 = example.createCriteria();

        criteria1.andGreaterThan("empSalary", 3000)
                 .andLessThan("empAge", 25);

        criteria2.andGreaterThan("empSalary", 5000)
                 .andGreaterThan("empAge", 30);

        example.or(criteria2);

        List<Employee> employeeList = employeeService.getEmployeeByExample(example);

        for (Employee emp: employeeList) {
            System.out.println(emp);
        }


    }

}
