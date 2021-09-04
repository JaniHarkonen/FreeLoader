package freeloader.robot;

import java.awt.Robot;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import freeloader.robot.actions.FLRobotAction;

public class FLRobotContext {

		// Reference to the owner
	private FLRobot owner;
	
		// Reference to the Robot
	private Robot robot;
	
		// Robot memory
	private Map<String, Object> memory;
	
		// Robot actions
	public ArrayList<FLRobotAction> actions;
	
	
	public FLRobotContext(FLRobot or, Robot r) {
		actions = new ArrayList<FLRobotAction>();
		memory = new HashMap<String, Object>();
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
	
		// Assigns a given object to a memory key
	public void memoryPut(String key, Object o) {
		memory.put(key, o);
	}
	
		// Removes an object from memory given its key
	public void memoryDelete(String key) {
		memory.remove(key);
	}
	
		// Retrieves an object from memory given its key
	public Object memoryGet(String key) {
		return memory.get(key);
	}
}
