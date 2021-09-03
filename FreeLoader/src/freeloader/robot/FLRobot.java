package freeloader.robot;

import java.awt.AWTException;
import java.awt.Robot;

import freeloader.robot.actions.FLRobotAction;

public class FLRobot {
	
		// Container for members that can be passed onto actions
	private FLRobotContext context;
	
		// Action line currently being executed
	private int actionLine;

	
	public FLRobot() {
		try
		{
			context = new FLRobotContext(this, new Robot());
		} 
		catch (AWTException e) { e.printStackTrace(); }
	}
	
	public FLRobot(FLRobotContext rc) {
		context = rc;
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
}
