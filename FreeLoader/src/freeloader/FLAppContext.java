package freeloader;

import java.util.ArrayList;

import freeloader.gui.FLWindow;
import freeloader.gui.settings.FLSettings;
import freeloader.robot.FLRobot;

public class FLAppContext {
	
		// List of available robots
	private ArrayList<FLRobot> availableRobots;

		// Currently open robot
	private FLRobot selectedRobot;
	
		// Settings for the currently open action
	private FLSettings selectedActionSettings;
	
		// Window the application context is hosted in
	private FLWindow hostWindow;
	
	
	public FLAppContext(FLWindow host) {
		hostWindow = host;
	}
	
	
		// Returns the available robots
	public ArrayList<FLRobot> getRobots() {
		return availableRobots;
	}
	
		// Sets the available robots
	public void setRobots(ArrayList<FLRobot> bots) {
		availableRobots = bots;
	}
	
		// Returns currently open robot
	public FLRobot getSelectedRobot() {
		return selectedRobot;
	}
	
		// Sets currently open robot
	public void setSelectedRobot(FLRobot bot) {
		selectedRobot = bot;
	}
	
		// Returns a reference to the settings of the currently open action
	public FLSettings getSelectedActionSettings() {
		return selectedActionSettings;
	}
	
		// Sets the settings for the currently open action
	public void setSelectedActionSettings(FLSettings sets) {
		selectedActionSettings = sets;
		hostWindow.redraw(true);
	}
}
