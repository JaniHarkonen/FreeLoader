package freeloader.gui.settings;

import javax.swing.JPanel;

import freeloader.robot.actions.FLRobotAction;

public abstract class FLSettings {

		// The action whose settings are in question
	protected FLRobotAction underlyingAction;
	
	
	protected FLSettings() {
		underlyingAction = null;
	}
	
	
		// Returns the JPanel representing the GUI of the settings
		// (TO BE OVERRIDDEN)
	public JPanel getGUIComponent() {
		return null;
	}
	
		// The method to be performed upon changing the settings of the
		// underlying action
		// (TO BE OVERRIDDEN)
	public void updateAction() {
	}
	
		// Sets the underlying action
	public void setAction(FLRobotAction act) {
		underlyingAction = act;
	}
	
		// Returns the underlying action
	public FLRobotAction getAction() {
		return underlyingAction;
	}
}
