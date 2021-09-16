package freeloader.gui.settings;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import freeloader.FLAppContext;
import freeloader.robot.actions.FLActionWait;
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
		JPanel inp_time = createInputField("Wait for (MS): ", true, 96);
		JTextField j_inp_time = getTextFieldFromInputField(inp_time);
		j_inp_time.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				updateAction(j_inp_time.getText());
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				updateAction(j_inp_time.getText());
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
			
		});
		pane.add(inp_time);
		
		
		
		wrapper.add(pane);
		return wrapper;
	}
	
	@Override
	public void updateAction(Object o) {
		((FLActionWait) underlyingAction).getWaitTime().setErrorMargin(Integer.parseInt((String) o));
	}
}
