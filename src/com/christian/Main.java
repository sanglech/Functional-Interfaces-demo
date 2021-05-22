package com.christian;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;
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

        printEmployeesByAge(employees, "Employees younger than 25", new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge()<25;
            }
        });


        //Declare int predicate (each line is a code block)
        IntPredicate greaterThan15 = i -> i>15;

        IntPredicate lessThan100= i -> i<100;

        //Need to call test func in predicate for it to run
        System.out.println(greaterThan15.test(10));

        //Can chain predicates and put variable expressions.
        int a=15;
        System.out.println(greaterThan15.and(lessThan100).test(a+40));


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
