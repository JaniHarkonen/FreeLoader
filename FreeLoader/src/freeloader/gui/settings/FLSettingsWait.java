package freeloader.gui.settings;

import javax.swing.JPanel;

import freeloader.FLAppContext;
import freeloader.robot.actions.FLRobotAction;

public class FLSettingsWait extends FLSettings {
	
	public FLSettingsWait(FLAppContext host) {
		super(host);
	}
	
	public FLSettingsWait(FLAppContext host, FLRobotAction src) {
		super(host, src);
	}
	

	@Override
	public JPanel getElement() {
		JPanel wrapper = createSettingsWrapper();
		
		JPanel pane = createSettingsPane("Duration");
		pane.add(createInputField("Wait for (MS):  ", true, 96));
		
		wrapper.add(pane);
		return wrapper;
	}
}
