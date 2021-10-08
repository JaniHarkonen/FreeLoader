package freeloader.gui.robotmanager;

import freeloader.robot.FLRobot;

/**
 * Container class for a robot and the thread its being ran in
 * by the robot manager.
 * @author Johnny
 *
 */
public class FLRobotManagerEntry {

	/**
	 * Thread the robot is being ran in.
	 */
	public Thread thread;
	
	/**
	 * Robot that is being ran.
	 */
	public FLRobot robot;
	
	
	/**
	 * Constructs a blank manager entry with null thread and robot.
	 */
	public FLRobotManagerEntry() {
		this(null, null);
	}
	
	/**
	 * Constructs a manager entry with a given thread and robot.
	 * @param thread Thread the robot is to be ran in.
	 * @param robot Robot that is to be ran.
	 */
	public FLRobotManagerEntry(Thread thread, FLRobot robot) {
		this.thread = thread;
		this.robot = robot;
	}
}
