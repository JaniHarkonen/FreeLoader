package freeloader.gui.settings;

import javax.swing.JLabel;
import javax.swing.JPanel;

import freeloader.gui.FLGUIComponent;
import freeloader.gui.FLGUIContext;
import freeloader.gui.FLGUIUtilities;
import freeloader.robot.actions.FLRobotAction;

public abstract class FLSettings extends FLGUIComponent {

	protected FLSettings(FLGUIContext c) {
		super(c, false);
	}
	
	
		// Updates the underlying action
		// (TO BE OVERRIDDEN)
	public void updateAction() {
	}
	
	
		// Returns the underlying action
	public FLRobotAction getUnderlyingAction() {
		return (FLRobotAction) context.get("action");
	}
	
	
		// UTILITY: Creates the default wrapper for the settings
	protected JPanel createSettingsContainer() {
		JPanel container = FLGUIUtilities.createSettingsPane("Action: ");
		container.add(new JLabel(" "));
		
		return container;
	}
}
