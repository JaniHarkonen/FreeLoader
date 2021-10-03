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
	
	
		// Runs the robot executing all actions starting from current
		// action line
	public void run() {
		int end = context.actions.size();
		while( actionLine < end )
		{
			context.actions.get(actionLine).perform(context);
			actionLine++;
		}
	}
	
		// Runs the robot starting from the first action
	public void runFromStart() {
		gotoLine(0);
		run();
	}
	
		// Jumps to a given action
	public void gotoLine(int line) {
		actionLine = line;
	}
	
		// Returns the line of the current action
	public int getLine() {
		return actionLine;
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
