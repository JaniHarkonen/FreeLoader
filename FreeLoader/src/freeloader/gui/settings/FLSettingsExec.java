package freeloader.gui.settings;

import javax.swing.JPanel;

import freeloader.FLAppContext;
import freeloader.robot.actions.FLRobotAction;

public class FLSettingsExec extends FLSettings {
	
	public FLSettingsExec(FLAppContext host) {
		super(host);
	}
	
	public FLSettingsExec(FLAppContext host, FLRobotAction src) {
		super(host, src);
	}
	

	@Override
	public JPanel getElement() {
		JPanel wrapper = createSettingsWrapper();
		
		JPanel pane = createSettingsPane("Path");
		pane.add(createInputField("Filepath:  "));
		
		wrapper.add(pane);
		return wrapper;
	}
}
