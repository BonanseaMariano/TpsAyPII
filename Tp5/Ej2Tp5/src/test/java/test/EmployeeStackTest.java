/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package test;

import arrayStack.ArrayStack;
import employee.BasePlusCommissionEmployee;
import employee.CommissionEmployee;
import employee.Employee;
import employee.SalariedEmployee;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Mariano
 */
public class EmployeeStackTest {

    @Test
    public void testSueldos() {
        ArrayStack<Employee> employeeStack = new ArrayStack<>(3);

        //Add employees to the stack
        employeeStack.push(new BasePlusCommissionEmployee("Mariano", "Bonansea", "1234", 200, 50, 300000));
        employeeStack.push(new SalariedEmployee("Luis", "Caca", "2222", 300000));
        employeeStack.push(new SalariedEmployee("Pepito", "Galletas", "3333", 150000));

        //Stack Full
        assertThrows(IllegalStateException.class, () -> {
            employeeStack.push(new CommissionEmployee("Pepito", "Galletas", "3333", 100, 30));
        });

        while (!employeeStack.isEmpty()) {
            Employee pop = employeeStack.pop();
            System.out.println("Salario de " + pop.getFirstName() + ": $" + pop.earnings());
        }

        assertEquals(null, employeeStack.pop());
    }

}
