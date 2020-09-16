package turtleGraphics;
import mvc.*;

public class ClearCommand extends Command {
	
	  public ClearCommand(Model model){ 
		  super(model);
	  }
	  
	  public void execute() {
	     Turtle turtle = (Turtle) model;
	     turtle.clear();
	  }
}
