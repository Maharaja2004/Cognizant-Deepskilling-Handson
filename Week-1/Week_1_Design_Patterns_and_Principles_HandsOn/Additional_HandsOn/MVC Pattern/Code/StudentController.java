package MVCPatternExample;

public class StudentController {

	 private Student student;
	 private StudentView view;
	 
	 public StudentController(Student student,StudentView view) {
		 this.student=student;
		 this.view=view;
		
	 }
	 public void setStudentName(String name) {
		 student.setName(name);
	 }
	 public void setStudentId(String id) {
		 student.setId(id);
	 }
	 public void setStudentgrade(String grade) {
		 student.setgrade(grade);
	 }
	 public void update() {
		 view.displayStudentDetails(student.getName(),student.getId(), student.getgrade());
	 }
}
