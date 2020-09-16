package turtleGraphics;
import mvc.*;

public class MoveCommand extends Command{
	public MoveCommand(Model model) {
		super(model);
	}

	public void execute() {
		 Turtle turtle = (Turtle) model;
		 String distance = Utilities.ask("How far?"); //Asks user for input
		 if(distance == null) { //if cancel then return
			 return;
		 }
		 else {
		     int pixels = 0;
		     try {
		    	 pixels = Integer.valueOf(distance); //convert string to int
		     } catch (NumberFormatException e){
		    	 Utilities.error("Not a proper input.");
		     }
		     if(pixels<0) {
		    	 Utilities.error("Sorry, turtle cannot move backwards.");
		     }
		     else {
		    	 turtle.move(pixels); //call move method
		     }
		 }
	}
	

}
