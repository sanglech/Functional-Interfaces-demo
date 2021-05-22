package com.christian;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Employee emp1= new Employee("mark",21);
        Employee emp2= new Employee("john",31);
        Employee emp3= new Employee("christian",41);
        Employee emp4= new Employee("Bob",50);
        Employee emp5= new Employee("mary",15);

        List<Employee> employees= new ArrayList<>();

        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        employees.add(emp4);
        employees.add(emp5);

        printEmployeesByAge(employees,"Employee greater than 30", employee -> employee.getAge()>30);
        printEmployeesByAge(employees,"Employee less than 30", employee -> employee.getAge()<30);

        //System.out.println("Employees over 30");
       // System.out.println("=================");
//        employees.forEach(emp->{
//            if(emp.getAge()>30){
//                System.out.println(emp.getName());
//            }
//        });


//        for(Employee e: employees){
//            if(e.getAge()>30){
//                System.out.println(e.getName());
//            }
//        }


    }

    private static void printEmployeesByAge(List<Employee> employees,
                                            String ageText,
                                            Predicate<Employee> ageCondition){
        System.out.println(ageText);
        System.out.println("=================");

        for(Employee e: employees){
            if(ageCondition.test(e)){
                System.out.println(e.getName());
            }
        }

    }
}
