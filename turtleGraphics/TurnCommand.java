package turtleGraphics;

import mvc.*;

public class TurnCommand extends Command {
	
	public TurnCommand(Model model) {
		super(model);
	}

	public void execute() {
		Heading heading = null;
		Turtle turtle = (Turtle) model;
		
	    String direction = Utilities.ask("Enter Heading:"); //Asks user for input
	    if(direction == null) {
	    	heading = turtle.getDirection(); // if null leave direction the same
	    }
	    else {
		    direction = direction.toLowerCase().trim();
		    if(direction.equals("north")) {
		    	heading = Heading.N;
		    }
		    else if(direction.equals("south")) {
		    	heading = Heading.S;
		    }
		    else if(direction.equals("east")) {
		    	heading = Heading.E;
		    }
		    else if(direction.equals("west")) {
		    	heading = Heading.W;
		    }
		    else{
		    	heading = turtle.getDirection();
		    	Utilities.error("Direction is not valid");
		    }
	    }
	    
	    turtle.turn(heading);  // call turn 
	}
	
}
