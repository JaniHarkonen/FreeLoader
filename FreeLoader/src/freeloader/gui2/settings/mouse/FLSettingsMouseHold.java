package freeloader.gui2.settings.mouse;

import javax.swing.JPanel;

import freeloader.gui2.FLGUIContext;
import freeloader.gui2.FLGUIUtilities;
import freeloader.gui2.sub.FLSubInputField;
import freeloader.gui2.sub.FLSubTogglerCheckBox;
import freeloader.robot.actions.mouse.FLActionMouseHold;
import freeloader.robot.actions.values.FLInt;

public class FLSettingsMouseHold extends FLSettingsMouse {
	
		// INPUT FIELD - Hold duration (MS)
	private FLSubInputField ifHoldDuration;
	
		// INPUT FIELD - Hold duration variance (MS)
	private FLSubInputField ifHoldDurationVariance;
	
		// TOGGLER CHECK BOX - Randomize hold duration
	private FLSubTogglerCheckBox tglRandomizeHoldDuration;
	
	
	public FLSettingsMouseHold(FLGUIContext c) {
		super(c);
	}
	

	@Override
	public JPanel render() {
			// Get values
		FLActionMouseHold act = (FLActionMouseHold) context.get("action");
		FLInt hdur_f = act.getHoldLength();
		int v_hdur = hdur_f.getUnmoddedValue();
		int v_hdur_var = hdur_f.getErrorMargin();
		boolean v_hdur_isrnd = hdur_f.getRandomized();
		
		JPanel container = createSettingsContainer();
		
		JPanel pane_dur = FLGUIUtilities.createSettingsPane("Hold time");
		JPanel line_hlen = FLGUIUtilities.createLineContainer();
		
			// Create button selection
		createMouseButtonMenu();
		
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
		
		container.add(ddMouseButton.render());
		FLGUIUtilities.addEmptySpace(container);
		container.add(pane_dur);
		
		return container;
	}
	
	@Override
	public void updateAction() {
		super.updateAction();
		
		FLActionMouseHold act = (FLActionMouseHold) context.get("action");
		
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
