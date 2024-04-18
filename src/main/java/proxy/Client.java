package proxy;

import java.io.PrintStream;
import java.lang.reflect.Proxy;

public class Client {

    public static void main(String[] args) {

        ItEmployee itEmployee = new ItEmployee();

        itEmployee.setId(101);
        itEmployee.setName("dev");
        itEmployee.setSalary(30000);

        //itEmployee.giveHike(-5000);//directly invoking the object to give hike
        /** if i am giving a negative value then i have to do some validation
         * before giving the hike => For this I am going to make a
         * proxy of my IEmployee interface
         */

        EmployeeProxy employeeProxyHandler = new EmployeeProxy(itEmployee);

        /** creating a proxy for IEmployee **/
        IEmployee employee = (IEmployee) Proxy.newProxyInstance(ItEmployee.class.getClassLoader(),
                new Class[]{IEmployee.class},
                employeeProxyHandler);

        /** Making method call over the proxy object **/
        employee.giveHike(5000);

        System.out.println(employee.getSalary());
    }
}
