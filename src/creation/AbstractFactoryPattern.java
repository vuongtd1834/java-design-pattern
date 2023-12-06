package creation;

interface Employee {
    void work();
}

class SeniorEmployee implements Employee {

    @Override
    public void work() {
        System.out.println("Ngồi chơi");
    }
}

class MiddleEmployee implements Employee {

    @Override
    public void work() {
        System.out.println("Làm như trâu");
    }
}

interface EmployeeFactory {
    Employee createEmployee();
}

class SeniorEmployeeFactory implements EmployeeFactory {

    @Override
    public Employee createEmployee() {
        return new SeniorEmployee();
    }
}

class MiddleEmployeeFactory implements EmployeeFactory {

    @Override
    public Employee createEmployee() {
        return new MiddleEmployee();
    }
}

class EmployeeAbstractFactory {

    EmployeeFactory employeeFactory;
    Employee employee;

    public EmployeeAbstractFactory(EmployeeFactory employeeFactory) {
        this.employeeFactory = employeeFactory;
        this.employee = employeeFactory.createEmployee();
    }

    public Employee renderEmployee() {
        return  employee;
    }

}

public class AbstractFactoryPattern {
    public static void main(String[] args) {
    EmployeeAbstractFactory employeeAbstractFactory = new EmployeeAbstractFactory(new MiddleEmployeeFactory());
    Employee employee = employeeAbstractFactory.renderEmployee();
    employee.work();
    }
}
