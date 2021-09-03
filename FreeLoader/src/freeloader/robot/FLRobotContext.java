package freeloader.robot;

import java.awt.Robot;
import java.util.ArrayList;

import freeloader.robot.actions.FLRobotAction;

public class FLRobotContext {

		// Reference to the owner
	private FLRobot owner;
	
		// Reference to the Robot
	private Robot robot;
	
		// Robot actions
	public ArrayList<FLRobotAction> actions;
	
	
	public FLRobotContext(FLRobot or, Robot r) {
		actions = new ArrayList<FLRobotAction>();
		owner = or;
		robot = r;
	}
	
	
		// Returns the owner of this context
	public FLRobot getOwner() {
		return owner;
	}
	
		// Returns the robot associated with the owner
	public Robot getRobot() {
		return robot;
	}
}
