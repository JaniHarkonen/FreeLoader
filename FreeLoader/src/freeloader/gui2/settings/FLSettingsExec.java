package freeloader.gui2.settings;

import java.awt.Dimension;

import javax.swing.JPanel;

import freeloader.gui2.FLGUIContext;
import freeloader.gui2.FLGUIUtilities;
import freeloader.gui2.sub.FLSubInputField;
import freeloader.robot.actions.FLActionExec;

public class FLSettingsExec extends FLSettings {

		// INPUT FIELD - File path
	private FLSubInputField ifFilePath;
	
	
	public FLSettingsExec(FLGUIContext c) {
		super(c);
	}
	
	
	@Override
	public JPanel render() {
			// Get values
		FLActionExec act = (FLActionExec) context.get("action");
		String v_path = act.getPath();
		
		JPanel container = createSettingsContainer();
		
		JPanel pane = FLGUIUtilities.createSettingsPane("File");
		ifFilePath = new FLSubInputField(this, "Path:  ");
		ifFilePath.textField.setText(v_path);
		ifFilePath.textField.setMaximumSize(new Dimension(Integer.MAX_VALUE, ifFilePath.textField.getPreferredSize().height));
		pane.add(ifFilePath.render());
		
		container.add(pane);
		return container;
	}
	
	@Override
	public void updateAction() {
		FLActionExec act = (FLActionExec) context.get("action");
		
			// Variables to be saved
		String v_path = ifFilePath.textField.getText();
		
			// Save changes
		act.setPath(v_path);
	}
}
