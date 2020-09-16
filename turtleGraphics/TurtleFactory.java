package turtleGraphics;

import mvc.*;

public class TurtleFactory implements AppFactory {

	public Model makeModel() { return new Turtle(); }

	public String[] getEditCommands() { 
		return new String[] {"Turn","Move","Clear","Pen","Color"}; 
	}

	public Command makeEditCommand(Model model, String type) {
		if (type == "Turn")
			return new TurnCommand(model);
		else if(type == "Move")
			return new MoveCommand(model);
		else if(type == "Clear")
			return new ClearCommand(model);
		else if(type == "Pen")
			return new PenCommand(model);
		else if(type == "Color")
			return new ColorCommand(model);
		return null;
	}

	public String getTitle() {
		return "Turtle Graphics Simulator";
	}

	public String[] getHelp() {
		return new String[] {"The rectangle is the direction the turtle is set to travel.",
				"Use turn to change the direction of the turtle.",
				"Use move to move the turtle in the direction of the heading.",
				"Use clear to clear the drawing.",
				"Use pen to draw or to not draw as you move the turtle.",
				"Use color to change the color of the turtle."};
	}

	public String about() {
		return "Turtle Graphics Simulator version 1.0. Copyright 2020 by NayyarDesigns";
	}


}