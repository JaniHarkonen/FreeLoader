package freeloader.gui.settings.mouse;

import javax.swing.JPanel;

import freeloader.FLAppContext;
import freeloader.robot.actions.FLRobotAction;

public class FLSettingsMouseRelease extends FLSettingsMouse {
	
	public FLSettingsMouseRelease(FLAppContext host) {
		super(host);
	}
	
	public FLSettingsMouseRelease(FLAppContext host, FLRobotAction src) {
		super(host, src);
	}
	

	@Override
	public JPanel getElement() {
		JPanel wrapper = createSettingsWrapper();
		
		wrapper.add(createMouseButtonDropMenu());
		return wrapper;
	}
}
