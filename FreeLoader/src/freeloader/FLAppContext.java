package freeloader;

import java.util.ArrayList;

import javax.swing.JPanel;

import freeloader.gui.FLWindow;
import freeloader.gui.settings.FLSettings;
import freeloader.robot.FLRobot;

public class FLAppContext {
	
		// List of available robots
	private ArrayList<FLRobot> availableRobots;

		// Currently open robot
	private FLRobot selectedRobot;
	
		// JPanel containing the Settings for the currently open action
	private JPanel selectedActionSettingsPanel;
	
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
	
		// Returns a reference to the JPanel containing the settings
		// of the currently open action
	public JPanel getSelectedActionSettingsPanel() {
		return selectedActionSettingsPanel;
	}
	
		// Sets the settings for the currently open action
	public void setSelectedActionSettings(FLSettings sets) {
		selectedActionSettingsPanel.removeAll();
		selectedActionSettingsPanel.add(sets.getElement());
		selectedActionSettingsPanel.revalidate();
		selectedActionSettingsPanel.repaint();
	}
	
		// Sets the JPanel containing the settings for the currently
		// open action
	public void setSelectedActionSettingsPanel(JPanel jp) {
		selectedActionSettingsPanel = jp;
	}
}
