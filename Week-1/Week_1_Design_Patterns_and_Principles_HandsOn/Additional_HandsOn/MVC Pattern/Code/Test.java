package MVCPatternExample;

public class Test {

	public static void main(String[] args) {
		Student s=new Student();
		s.setgrade("A");
		s.setName("Raja");
		s.setId("123");
		
		StudentView v=new StudentView();
		
		StudentController control=new StudentController(s,v);
		control.update();
		control.setStudentgrade("A+");
		control.setStudentName("Maharaja");
		control.update();
	}

}
