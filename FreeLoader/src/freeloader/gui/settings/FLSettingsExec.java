package freeloader.gui.settings;

import java.awt.Dimension;

import javax.swing.JPanel;

import freeloader.gui.FLGUIContext;
import freeloader.gui.FLGUIUtilities;
import freeloader.gui.sub.FLSubInputField;
import freeloader.robot.actions.FLActionExec;

public class FLSettingsExec extends FLSettings {

		// INPUT FIELD - File path
	private FLSubInputField ifFilePath;
	
	
	public FLSettingsExec(FLGUIContext c) {
		super(c);
	}
	
	
	@Override
	protected JPanel draw() {
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
