package freeloader.gui2.settings;

import javax.swing.JLabel;
import javax.swing.JPanel;

import freeloader.gui2.FLGUIComponent;
import freeloader.gui2.FLGUIContext;
import freeloader.gui2.FLGUIUtilities;
import freeloader.robot.actions.FLRobotAction;

public abstract class FLSettings extends FLGUIComponent {

	protected FLSettings(FLGUIContext c) {
		super(c, false);
	}
	
	
		// Updates the underlying action
		// (TO BE OVERRIDDEN)
	public void updateAction() {
	}
	
	
		// UTILITY: Creates the default wrapper for the settings
	protected JPanel createSettingsContainer() {
		JPanel container = FLGUIUtilities.createSettingsPane("Action: ");
		container.add(new JLabel(" "));
		
		return container;
	}
}
