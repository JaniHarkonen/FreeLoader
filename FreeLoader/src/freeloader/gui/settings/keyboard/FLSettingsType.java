package freeloader.gui.settings.keyboard;

import javax.swing.JPanel;

import freeloader.gui.FLGUIContext;
import freeloader.gui.FLGUIUtilities;
import freeloader.gui.settings.FLSettings;
import freeloader.gui.sub.FLSubInputField;
import freeloader.robot.actions.FLActionJump;
import freeloader.robot.actions.keyboard.FLActionType;
import freeloader.robot.actions.values.FLInt;

public class FLSettingsType extends FLSettings {

		// INPUT FIELD - Text to type
	private FLSubInputField ifText;
	
	
	public FLSettingsType(FLGUIContext c) {
		super(c);
	}
	
	
	@Override
	public JPanel draw() {
			// Get values
		FLActionType act = (FLActionType) context.get("action");
		String v_text = act.getText();
		
		JPanel container = createSettingsContainer();
		
		JPanel line_line = FLGUIUtilities.createLineContainer();
		ifText = new FLSubInputField(this, "Text to type:  ");
		ifText.textField.setText(v_text);
		line_line.add(ifText.render());
		
		container.add(line_line);
		return container;
	}
	
	@Override
	public void updateAction() {
		FLActionType act = (FLActionType) context.get("action");
		
			// Variables to be saved
		String v_text = ifText.textField.getText();
		
			// Save changes
		act.setText(v_text);
	}
}
