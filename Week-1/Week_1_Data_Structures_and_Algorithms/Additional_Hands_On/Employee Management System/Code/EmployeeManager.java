package EmployeeManagementSystem;

public class EmployeeManager {
	Employee employees[] = new Employee[100];
    int count=0;

    public void addEmployee(Employee emp){
        employees[count]=emp;
        count++;
        System.out.println("Employee added: " + emp.getEmployeeId());
    }

 
    public void searchEmployee(int id){
        boolean f=false;
        for (int i=0;i<count;i++){
            if (employees[i].getEmployeeId()==id){
                employees[i].display();
                f=true;
                break;
            }
        }
        if (!f) {
            System.out.println("Employee not found.");
        }
    }

    
    public void showAllEmployees() {
        for (int i=0;i<count;i++) {
            employees[i].display();
        }
    }

    public void deleteEmployee(int id) {
        boolean f=false;
        for (int i=0;i<count;i++){
            if (employees[i].getEmployeeId()==id){
                for (int j=i;j<count-1;j++){
                    employees[j] = employees[j + 1];
                }
                employees[count-1]=null;
                count--;
                System.out.println("Employee deleted: " + id);
                f=true;
                break;
            }
        }
        if(!f){
            System.out.println("Employee not found.");
        }
    }
}
