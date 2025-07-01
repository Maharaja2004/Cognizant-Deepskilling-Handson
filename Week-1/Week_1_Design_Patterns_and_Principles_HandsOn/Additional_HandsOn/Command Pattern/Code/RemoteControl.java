package CommandPatternExample;

public class RemoteControl {

	private Command command;
	
	 public void setcommand(Command command) {
		 this.command=command;
	 }
	 public void pressbutton() {
		 command.execute();
	 }
}
