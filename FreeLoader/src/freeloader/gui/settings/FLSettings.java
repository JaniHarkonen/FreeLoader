package freeloader.gui.settings;

import javax.swing.JPanel;

import freeloader.FLAppContext;
import freeloader.gui.window.FLElement;
import freeloader.robot.actions.FLRobotAction;
import freeloader.robot.actions.mouse.FLActionMouseRelease;

public abstract class FLSettings extends FLElement {

		// The action whose settings are in question
	protected FLRobotAction underlyingAction;
	
	
	protected FLSettings(FLAppContext host) {
		super(host);
		
		underlyingAction = null;
	}
	
	
		// Returns the JPanel representing the GUI of the settings
		// (TO BE OVERRIDDEN)
	public JPanel getElement() {
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
	
	
		// Builds a settings object for a given RobotAction
	public static FLSettings buildSettings(FLRobotAction src, FLAppContext host) {
		if( src == null ) return null;
		FLSettings sets = null;
		
		if( src instanceof FLActionMouseRelease ) return new FLSettingsMouseRelease(host);
		
		return sets;
	}
}
