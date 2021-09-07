package freeloader.gui.settings.mouse;

import javax.swing.JPanel;

import freeloader.FLAppContext;
import freeloader.robot.actions.FLRobotAction;

public class FLSettingsMouseHold extends FLSettingsMouse {
	
	public FLSettingsMouseHold(FLAppContext host) {
		super(host);
	}
	
	public FLSettingsMouseHold(FLAppContext host, FLRobotAction src) {
		super(host, src);
	}
	

	@Override
	public JPanel getElement() {
		JPanel wrapper = createSettingsWrapper();
		
		JPanel pane_dur = createSettingsPane("Hold time");
		JPanel line_hlen = createLineWrapper();
		JPanel inp_hlen = createInputField("Duration (MS): ");
		JPanel inp_hlen_rand = createToggleableInputField("Variation (MS): ", "Randomize", false, false);
		
		line_hlen.add(inp_hlen);
		line_hlen.add(inp_hlen_rand);
		pane_dur.add(line_hlen);
		
		wrapper.add(createMouseButtonDropMenu());
		addEmptySpace(wrapper);
		wrapper.add(pane_dur);
		return wrapper;
	}
}
