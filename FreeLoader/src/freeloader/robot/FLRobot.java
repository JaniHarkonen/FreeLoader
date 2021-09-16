package freeloader.robot;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;

import freeloader.robot.actions.FLRobotAction;

public class FLRobot {
	
		// Container for members that can be passed onto actions
	private FLRobotContext context;
	
		// Action line currently being executed
	private int actionLine;
	
		// Name of the robot
	private String name;

	
	public FLRobot() {
		try
		{
			context = new FLRobotContext(this, new Robot());
		} 
		catch (AWTException e) { e.printStackTrace(); }
		
		actionLine = -1;
		name = "Robot";
	}
	
	
		// Runs the robot executing all actions
	public void run() {
		actionLine = 0;
		
		int end = context.actions.size();
		while( actionLine < end )
		{
			context.actions.get(actionLine).perform(context);
			actionLine++;
		}
	}
	
		// Jumps to a given action
	public void gotoLine(int line) {
		actionLine = line;
	}
	
		// Returns this robot's RobotContext
	public FLRobotContext getRobotContext() {
		return context;
	}
	
		// Sets the name of the robot
	public void setName(String n) {
		name = n;
	}
	
		// Returns the name of the robot
	public String getName() {
		return name;
	}
	
		// Sets the action set of the robot
	public void setActions(ArrayList<FLRobotAction> act) {
		context.actions = act;
	}
}
