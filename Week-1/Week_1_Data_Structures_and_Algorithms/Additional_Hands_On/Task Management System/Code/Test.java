package TaskManagementSystem;

public class Test {
	public static void main(String[] args){
        TaskManager manager=new TaskManager();

        manager.addTask(1,"Design UI","Pending");
        manager.addTask(2,"Develop Backend","In Progress");
        manager.addTask(3,"Test Application","Pending");

        System.out.println("All Tasks:");
        manager.showAllTasks();

        System.out.println("Search Task ID 2:");
        manager.searchTask(2);

        System.out.println("Delete Task ID 1:");
        manager.deleteTask(1);

        System.out.println("All Tasks After Deletion:");
        manager.showAllTasks();
    }
}
