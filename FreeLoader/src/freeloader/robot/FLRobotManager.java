package freeloader.robot;

import java.util.ArrayList;

public class FLRobotManager {

		// List of robots under management
	private ArrayList<FLRobot> robots;
	
	
	public FLRobotManager() {
		robots = new ArrayList<FLRobot>();
	}
	
	
		// Sets the list of robots to manage
	public void setRobots(ArrayList<FLRobot> r) {
		robots = r;
	}
	
		// Returns the list of robots under management
	public ArrayList<FLRobot> getRobots() {
		return robots;
	}
}