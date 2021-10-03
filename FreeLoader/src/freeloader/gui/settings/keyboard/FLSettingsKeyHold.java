package freeloader.gui.settings.keyboard;

import javax.swing.JPanel;

import freeloader.gui.FLGUIContext;
import freeloader.gui.FLGUIUtilities;
import freeloader.gui.sub.FLSubInputField;
import freeloader.gui.sub.FLSubTogglerCheckBox;
import freeloader.robot.actions.keyboard.FLActionKeyHold;
import freeloader.robot.actions.values.FLInt;

public class FLSettingsKeyHold extends FLSettingsKeyboard {
	
		// INPUT FIELD - Hold duration (MS)
	private FLSubInputField ifHoldDuration;
	
		// INPUT FIELD - Hold duration variance (MS)
	private FLSubInputField ifHoldDurationVariance;
	
		// TOGGLER CHECK BOX - Randomize hold duration
	private FLSubTogglerCheckBox tglRandomizeHoldDuration;
	
	
	public FLSettingsKeyHold(FLGUIContext c) {
		super(c);
	}
	

	@Override
	protected JPanel draw() {
			// Get values
		FLActionKeyHold act = (FLActionKeyHold) context.get("action");
		FLInt hdur_f = act.getHoldLength();
		int v_hdur = hdur_f.getUnmoddedValue();
		int v_hdur_var = hdur_f.getErrorMargin();
		boolean v_hdur_isrnd = hdur_f.getRandomized();
		
		JPanel container = createSettingsContainer();
		
		JPanel pane_dur = FLGUIUtilities.createSettingsPane("Hold time");
		JPanel line_hlen = FLGUIUtilities.createLineContainer();
		
			// Create button selection
		createKeyboardKeyMenu();
		
			// Hold duration
		ifHoldDuration = new FLSubInputField(this, "Duration (MS): ");
		ifHoldDuration.textField.setText(Integer.toString(v_hdur));
		
			// Hold duration variance
		ifHoldDurationVariance = new FLSubInputField(this, "Variation (MS): ");
		ifHoldDurationVariance.textField.setText(Integer.toString(v_hdur_var));
		ifHoldDurationVariance.textField.setEnabled(v_hdur_isrnd);
		
			// Randomize hold duration?
		tglRandomizeHoldDuration = new FLSubTogglerCheckBox(this, "Randomize", ifHoldDurationVariance.textField, false);
		
		line_hlen.add(ifHoldDuration.render());
		line_hlen.add(ifHoldDurationVariance.render());
		line_hlen.add(tglRandomizeHoldDuration.render());
		pane_dur.add(line_hlen);
		
		container.add(ddKeyboardKey.render());
		FLGUIUtilities.addEmptySpace(container);
		container.add(pane_dur);
		
		return container;
	}
	
	@Override
	public void updateAction() {
		super.updateAction();
		
		FLActionKeyHold act = (FLActionKeyHold) context.get("action");
		
			// References
		FLInt f_hdur = act.getHoldLength();
		
			// Variables to be saved
		int v_hdur = Integer.parseInt(ifHoldDuration.textField.getText());
		int v_hudr_var = Integer.parseInt(ifHoldDurationVariance.textField.getText());
		boolean v_hdur_isrnd = tglRandomizeHoldDuration.toggler.isSelected();
		
			// Save changes
		f_hdur.setValue(v_hdur);
		f_hdur.setErrorMargin(v_hudr_var);
		f_hdur.setRandomized(v_hdur_isrnd);
	}
}
