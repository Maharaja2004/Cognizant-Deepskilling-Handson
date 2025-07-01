package EmployeeManagementSystem;

public class Test {
	public static void main(String[] args) {
        EmployeeManager manager=new EmployeeManager();

        Employee e1=new Employee();
        e1.setEmployeeId(1);
        e1.setName("Ravi");
        e1.setPosition("Manager");
        e1.setSalary(50000);

        Employee e2=new Employee();
        e2.setEmployeeId(2);
        e2.setName("Kiran");
        e2.setPosition("Developer");
        e2.setSalary(40000);

        manager.addEmployee(e1);
        manager.addEmployee(e2);

        System.out.println("All Employees:");
        manager.showAllEmployees();

        System.out.println("Search Employee with ID 2:");
        manager.searchEmployee(2);

        System.out.println("Delete Employee with ID 1:");
        manager.deleteEmployee(1);

        System.out.println("All Employees after Deletion:");
        manager.showAllEmployees();
    }
}
