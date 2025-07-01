package EmployeeManagementSystem;

public class Employee {
	private int employeeid;
    private String name;
    private String position;
    private double salary;

    public void setEmployeeId(int employeeid){
        this.employeeid=employeeid;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setPosition(String position){
        this.position=position;
    }

    public void setSalary(double salary){
        this.salary=salary;
    }

    public int getEmployeeId(){
        return employeeid;
    }

    public void display(){
        System.out.println("ID: " + employeeid + ", Name: " + name +
                           ", Position: " + position + ", Salary: ₹" + salary);
    }
}
