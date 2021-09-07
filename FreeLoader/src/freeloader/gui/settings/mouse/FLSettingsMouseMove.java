package freeloader.gui.settings.mouse;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

import freeloader.FLAppContext;
import freeloader.robot.actions.FLRobotAction;

public class FLSettingsMouseMove extends FLSettingsMouse {
	
	public FLSettingsMouseMove(FLAppContext host) {
		super(host);
	}
	
	public FLSettingsMouseMove(FLAppContext host, FLRobotAction src) {
		super(host, src);
	}
	

	@Override
	public JPanel getElement() {
		JPanel wrapper = createSettingsWrapper();
		
			// Move location
		JPanel pane_loc = createSettingsPane("Location");
		
		JPanel line_loc_x = createLineWrapper();
		line_loc_x.add(createInputField("X:  "));
		line_loc_x.add(createToggleableInputField("  ERROR: ", "Randomize", false, false));
		line_loc_x.add(new JCheckBox("Relative?"));
		
		JPanel line_loc_y = createLineWrapper();
		line_loc_y.add(createInputField("Y:  "));
		line_loc_y.add(createToggleableInputField("  ERROR: ", "Randomize", false, false));
		line_loc_y.add(new JCheckBox("Relative?"));
		
		pane_loc.add(line_loc_x);
		pane_loc.add(line_loc_y);
		
		wrapper.add(pane_loc);
		return wrapper;
	}
}
