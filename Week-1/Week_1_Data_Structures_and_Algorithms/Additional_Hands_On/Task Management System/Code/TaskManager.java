package TaskManagementSystem;

public class TaskManager {
	Task head=null;

    public void addTask(int id,String name,String status){
        Task t=new Task();
        t.taskid=id;
        t.taskname=name;
        t.status=status;
        t.next=null;

        if(head==null){
            head=t;
        }
        else {
            Task temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=t;
        }
        System.out.println("Task added.");
    }


    public void searchTask(int id){
        Task temp=head;
        while(temp!=null){
            if(temp.taskid==id){
                temp.display();
                return;
            }
            temp=temp.next;
        }
        System.out.println("Task not found.");
    }

    
    public void showAllTasks(){
        if(head==null) {
            System.out.println("No tasks to show.");
            return;
        }
        Task temp=head;
        while(temp!=null){
            temp.display();
            temp=temp.next;
        }
    }

    public void deleteTask(int id){
        if(head==null){
            System.out.println("No tasks in list.");
            return;
        }

        if(head.taskid==id){
            head=head.next;
            System.out.println("Task deleted.");
            return;
        }

        Task temp=head;
        while(temp.next!=null){
            if(temp.next.taskid==id){
                temp.next=temp.next.next;
                System.out.println("Task deleted.");
                return;
            }
            temp=temp.next;
        }

        System.out.println("Task not found.");
    }
}
