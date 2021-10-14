package freeloader.gui.settings;

import javax.swing.JPanel;

import freeloader.gui.FLGUIContext;
import freeloader.gui.FLGUIUtilities;
import freeloader.gui.sub.FLSubInputField;
import freeloader.robot.actions.FLActionJump;
import freeloader.robot.actions.values.FLInt;

public class FLSettingsJump extends FLSettings {

		// INPUT FIELD - Action line
	private FLSubInputField ifActionLine;
	
	
	public FLSettingsJump(FLGUIContext c) {
		super(c);
	}
	
	
	@Override
	public JPanel draw() {
			// Get values
		FLActionJump act = (FLActionJump) context.get("action");
		int v_jump = act.getLine().getUnmoddedValue() + 1;
		
		JPanel container = createSettingsContainer();
		
		JPanel line_line = FLGUIUtilities.createLineContainer();
		ifActionLine = new FLSubInputField(this, "Line to jump to:  ");
		ifActionLine.textField.setText(Integer.toString(v_jump));
		line_line.add(ifActionLine.render());
		
		container.add(line_line);
		return container;
	}
	
	@Override
	public void updateAction() {
		FLActionJump act = (FLActionJump) context.get("action");
		
			// References
		FLInt f_jump = act.getLine();
		
			// Variables to be saved
		int v_jump = Integer.parseInt(ifActionLine.textField.getText()) - 1;
		
		if( v_jump < 0 ) return;
		
			// Save changes
		f_jump.setValue(v_jump);
		
		act.updateDescription();
	}
}
