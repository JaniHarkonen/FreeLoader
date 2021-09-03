package freeloader.robot;

import java.awt.AWTException;
import java.awt.Robot;

import freeloader.robot.actions.FLRobotAction;

public class FLRobot {
	
		// Container for members that can be passed onto actions
	private FLRobotContext context;

	
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
		for( FLRobotAction act : context.actions )
		act.perform(context);
	}
}
