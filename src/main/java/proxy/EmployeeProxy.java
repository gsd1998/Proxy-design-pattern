package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class EmployeeProxy implements InvocationHandler {

    private IEmployee iEmployee;
    public EmployeeProxy(IEmployee iEmployee) {
        this.iEmployee = iEmployee;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        /** pre processing **/
        System.out.println("Inside pre processing invocation method handler");
        if(method.getName().equalsIgnoreCase("giveHike")) {
            double argumentValue = (double) args[0];
            if (argumentValue < 0) {
                throw new RuntimeException("hike value is in valid");
            }
        }

        /** actual method call **/
        Object invoke = method.invoke(iEmployee, args);

        /** post processing **/
        System.out.println("Inside post processing " + iEmployee.getName() + " " + method.getName());
        return invoke;
    }
}
