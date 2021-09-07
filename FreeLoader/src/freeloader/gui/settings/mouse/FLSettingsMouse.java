package freeloader.gui.settings.mouse;

import javax.swing.JPanel;

import freeloader.FLAppContext;
import freeloader.gui.settings.FLSettings;
import freeloader.robot.actions.FLRobotAction;
import freeloader.robot.actions.mouse.FLMouseButton;

public abstract class FLSettingsMouse extends FLSettings {
	
	public FLSettingsMouse(FLAppContext host) {
		super(host);
	}
	
	public FLSettingsMouse(FLAppContext host, FLRobotAction src) {
		super(host, src);
	}
	

	@Override
	public JPanel getElement() {
		return createSettingsWrapper();
	}
	
	
		// Creates a drop menu for mouse button options
	protected JPanel createMouseButtonDropMenu() {
		return createDropMenu("Mouse button:  ", FLMouseButton.BUTTON_CAPTIONS, 64);
	}
}
