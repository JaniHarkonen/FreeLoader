package freeloader.gui2.settings;

import javax.swing.JPanel;

import freeloader.gui2.FLGUIContext;
import freeloader.robot.actions.FLRobotAction;
import freeloader.robot.actions.mouse.FLActionMouseHold;

public class DummySettings extends FLSettings {

		// INPUT FIELD - Hold duration (MS)
	
		// INPUT FIELD - Hold duration variance (MS)
	
		// TOGGLER CHECK BOX - Randomize hold duration
	
		// (swing) LABEL - Swing component
	
	
	public DummySettings(FLGUIContext c) {
		super(c);
	}
	
	
	@Override
	public JPanel draw() {
			// Get values
		FLActionMouseHold act = (FLActionMouseHold) context.get("action");
		
		
		JPanel container = createSettingsContainer();
		
		
		return container;
	}
	
	@Override
	public void updateAction() {
		FLRobotAction act = (FLRobotAction) context.get("action");
		
			// References
		// FLInt f_some
		
			// Variables to be saved
		// int v_some
		// boolean v_someb
		
			// Save changes
		//act.setMouseButton(v_mb);
		//f_some.setValue(v_some);
		//f_some.setErrorMargin(v_some);
		//f_some.setRandomized(v_someb);
	}
}
