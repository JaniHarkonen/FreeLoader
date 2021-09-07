package freeloader.gui.settings.keyboard;

import javax.swing.JPanel;

import freeloader.FLAppContext;
import freeloader.robot.actions.FLRobotAction;

public class FLSettingsKeyRelease extends FLSettingsKeyboardKey {
	
	public FLSettingsKeyRelease(FLAppContext host) {
		super(host);
	}
	
	public FLSettingsKeyRelease(FLAppContext host, FLRobotAction src) {
		super(host, src);
	}
	

	@Override
	public JPanel getElement() {
		JPanel wrapper = createSettingsWrapper();
		
		wrapper.add(createKeyDropDownMenu());
		return wrapper;
	}
}
