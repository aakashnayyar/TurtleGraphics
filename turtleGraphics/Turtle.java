package turtleGraphics;

import java.awt.Color;
import java.util.*;
import mvc.*;

public class Turtle extends Model {
	public static Integer WORLD_SIZE = 250; // height & width of the world (& view)
	public static Integer TURTLE_SIZE = 7;  // diameter of a turtle
	public static Integer CRUMB_SIZE = 5;   // diameter of a point drawn by the turtle

	private Color color;
	private Point point;
	private Heading direction;
	private ArrayList<Point> path;
	private boolean penDown;
	
	public Turtle() {
		penDown = false;
		point = new Point(125, 125, Color.BLACK);
		direction = Heading.N;
		path = new ArrayList<>();
		color = null;
		penDown = false;
	}
	
	public void turn(Heading updatedDirection) {
		direction = updatedDirection; //set direction
		changed();
	}
	
	public void move(int steps) {
		for(int i =0; i<steps; i++) {
			if(penDown) { //add each point to path if pen is down
				Point p = new Point(point.getX(),point.getY(), color);
				path.add(p);
			}
			
			//subtract or add 5 pixels according to direction the turtle is moving
			if(direction == Heading.N) {
				point = new Point(point.getX(), point.getY()-CRUMB_SIZE, point.color);
			}
			else if(direction == Heading.W) {
				point = new Point(point.getX()-CRUMB_SIZE,point.getY(), point.color);
			}
			else if(direction == Heading.S) {
				point = new Point(point.getX(), point.getY()+CRUMB_SIZE, point.color);
			}
			else if(direction == Heading.E) {
				point = new Point(point.getX()+CRUMB_SIZE,point.getY(), point.color);
			}
			
			// if turtle moves off the world loop it around
			if(point.getX() >= WORLD_SIZE) {
				point = new Point(0,point.getY(),Color.BLACK);
			}
			else if(point.getY() >= WORLD_SIZE) {
				point = new Point(point.getX(),0,Color.BLACK);
			}
			else if(point.getX() < 0) {
				point = new Point(WORLD_SIZE, point.getY(),Color.BLACK);
			}
			else if(point.getY() < 0) {
				point = new Point(point.getX(), WORLD_SIZE,Color.BLACK);
			}
			changed();
		}
		
	}
	
	public void clear() {
		path.clear();
		changed();
	}
	
	public void pen() {
		penDown=!penDown;
		changed();
	}
	
	public void setColor(Color color) {
		this.color = color;
		changed();
	}
	
	public Color getColor() {
		return color;
	}
	
	public boolean isPenDown() {
		return penDown;
	}

	public ArrayList<Point> getPath() {
		return path;
	}

	public Point getPoint() {
		return point;
	}
	
	public Heading getDirection() {
		return direction;
	}

}
