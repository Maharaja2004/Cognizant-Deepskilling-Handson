package TaskManagementSystem;

public class Task {
	int taskid;
    String taskname;
    String status;
    Task next;

    public void display() {
        System.out.println("ID: " + taskid + ", Name: " + taskname + ", Status: " + status);
    }
}
