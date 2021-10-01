package freeloader.gui2.settings;

import javax.swing.JPanel;

import freeloader.gui2.FLGUIContext;
import freeloader.gui2.FLGUIUtilities;
import freeloader.gui2.sub.FLSubInputField;
import freeloader.robot.actions.FLActionWait;
import freeloader.robot.actions.values.FLInt;

public class FLSettingsWait extends FLSettings {

		// INPUT FIELD - Wait duration (MS)
	private FLSubInputField ifWaitDuration;
	
	
	public FLSettingsWait(FLGUIContext c) {
		super(c);
	}
	
	
	@Override
	protected JPanel draw() {
			// Get values
		FLActionWait act = (FLActionWait) context.get("action");
		int v_wait = act.getWaitTime().getUnmoddedValue();
		
		JPanel container = createSettingsContainer();
		
		JPanel pane = FLGUIUtilities.createSettingsPane("Behavior");
		ifWaitDuration = new FLSubInputField(this, "Duration (MS):  ");
		ifWaitDuration.textField.setText(Integer.toString(v_wait));
		pane.add(ifWaitDuration.render());
		
		container.add(pane);
		return container;
	}
	
	@Override
	public void updateAction() {
		FLActionWait act = (FLActionWait) context.get("action");
		
			// References
		FLInt f_wait = act.getWaitTime();
		
			// Variables to be saved
		int v_wait = Integer.parseInt(ifWaitDuration.textField.getText());
		
			// Save changes
		f_wait.setValue(v_wait);
	}
}
