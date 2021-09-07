package freeloader;

import java.util.ArrayList;

import javax.swing.JPanel;

import freeloader.gui.FLWindow;
import freeloader.gui.settings.FLSettings;
import freeloader.robot.FLRobot;

public class FLAppContext {

		// Context specifically for GUI elements
	public FLGuiContext guiContext;
	
		// List of available robots
	private ArrayList<FLRobot> availableRobots;

		// Currently open robot
	private FLRobot selectedRobot;
	
		// Window the application context is hosted in
	private FLWindow hostWindow;
	
	
	public FLAppContext(FLWindow host) {
		hostWindow = host;
		guiContext = new FLGuiContext();
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
	
		// Sets the settings for the currently open action
	public void setSelectedActionSettings(FLSettings sets) {
		JPanel jp = (JPanel) guiContext.get("open-settings-panel");
		jp.removeAll();
		jp.add(sets.getElement());
		jp.revalidate();
		jp.repaint();
	}
}
