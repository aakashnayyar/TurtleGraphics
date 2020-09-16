package turtleGraphics;
import java.util.*;
import mvc.*;
import java.awt.Color;
import java.awt.*;

public class TurtleView extends View{

	public TurtleView(Turtle turtle) {
		super(turtle);
	}
	
	public void paintComponent(Graphics gc) {
		Turtle turtle = (Turtle) model;
		Color oldColor = gc.getColor();
		
		ArrayList<Point> path = turtle.getPath();
		for(Point p: path) {
			gc.setColor(p.getColor());
			gc.fillOval(p.getX(), p.getY(), turtle.CRUMB_SIZE, turtle.CRUMB_SIZE);
		}
		
		gc.setColor(turtle.getPoint().getColor());
		if(turtle.isPenDown()) {
			gc.fillOval(turtle.getPoint().getX(),turtle.getPoint().getY(),turtle.TURTLE_SIZE,turtle.TURTLE_SIZE);
		}
		else {
			gc.drawOval(turtle.getPoint().getX(),turtle.getPoint().getY(),turtle.TURTLE_SIZE,turtle.TURTLE_SIZE);
		}
		
		//head of the turtle
		if(turtle.getDirection() == Heading.N) {
			gc.drawRect(turtle.getPoint().getX(),turtle.getPoint().getY()-2, 7,5);
			
		}
		else if(turtle.getDirection() == Heading.S) {
			gc.drawRect(turtle.getPoint().getX(),turtle.getPoint().getY()+4, 7,5);
			
		}
		else if(turtle.getDirection() == Heading.E) {
			gc.drawRect(turtle.getPoint().getX()+4,turtle.getPoint().getY(), 5,7);
			
		}
		else if(turtle.getDirection() == Heading.W) {
			gc.drawRect(turtle.getPoint().getX()-2,turtle.getPoint().getY(), 5,7);
			
		}
		
		gc.setColor(oldColor);
	}
	
	

}
