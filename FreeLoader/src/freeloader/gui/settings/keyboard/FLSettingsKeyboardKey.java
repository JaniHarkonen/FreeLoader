package freeloader.gui.settings.keyboard;

import javax.swing.JPanel;

import freeloader.FLAppContext;
import freeloader.gui.settings.FLSettings;
import freeloader.robot.actions.FLRobotAction;
import freeloader.robot.actions.mouse.FLMouseButton;

public abstract class FLSettingsKeyboardKey extends FLSettings {
	
	public FLSettingsKeyboardKey(FLAppContext host) {
		super(host);
	}
	
	public FLSettingsKeyboardKey(FLAppContext host, FLRobotAction src) {
		super(host, src);
	}
	

	@Override
	public JPanel getElement() {
		return createSettingsWrapper();
	}
	
	
		// Creates a drop menu for mouse button options
	protected JPanel createKeyDropDownMenu() {
		return createDropMenu("Keyboard key:  ", FLMouseButton.BUTTON_CAPTIONS, 64);
	}
}
