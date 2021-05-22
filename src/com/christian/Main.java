package com.christian;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Employee emp1= new Employee("mark",21);
        Employee emp2= new Employee("john",31);
        Employee emp3= new Employee("christian",41);
        Employee emp4= new Employee("Bob",50);
        Employee emp5= new Employee("mary sue",15);

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

        //Supplier
        System.out.println("\nUSING SUPPLIER");
        Random random= new Random();
        Supplier<Integer> randomSupplier= ()-> random.nextInt(1000);
        for(int i=0; i<10;i++){
            System.out.println(randomSupplier.get());
        }

        System.out.println("~~~~~~~~~~~");
        System.out.println("USING TRADITIONAL");
        for(int i=0; i<10;i++){
            System.out.println(random.nextInt(1000));
        }


        //Function example
        Function<Employee,String> getEmpLastName= (Employee emp)->{
            return emp.getName().substring(emp.getName().indexOf(' ')+1);
        };

        Function<Employee,String> getEmpFirstName= (Employee emp)->{
            return emp.getName().substring(0,emp.getName().indexOf(' '));
        };

        //String lastName= getEmpLastName.apply(employees.get(4));
        //System.out.println(lastName);


        String firstName=getName(getEmpFirstName,employees.get(4));
        String lastName=getName(getEmpLastName,employees.get(4));


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


    private static String getName(Function<Employee,String> getName,Employee employee){
        return getName.apply(employee);
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
