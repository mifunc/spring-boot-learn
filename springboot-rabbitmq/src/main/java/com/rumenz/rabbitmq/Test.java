package com.rumenz.rabbitmq;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @className: Test
 * @description: TODO 类描述
 * @author: mac
 * @date: 2021/9/10
 **/

public class Test {
    public static void main(String[] args) {
        Employee employee1 = new Employee("松皇","总经理","100000000000");
        Employee employee2 = new Employee("小赵","助理","100000");
        Employee employee3 = new Employee("小智","打杂","20000");
        Employee employee4 = new Employee("小李","打杂","20000");
        ArrayList<Employee> employees = Lists.newArrayList(employee1, employee2, employee3, employee4);
        Map<String, Employee> collect =
                employees.stream().collect(Collectors.groupingBy(Employee::getRank, Collectors.collectingAndThen(Collectors.toList(), value -> value.get(0))));
        employees.stream().collect(Collectors.groupingBy(Employee::getName, Collectors.minBy(Comparator.comparing(Employee::getSalary))));

        System.out.println(collect);
    }
}



@Data
@AllArgsConstructor
class Employee {
    private String name;
    private String rank;
    private String salary;
}