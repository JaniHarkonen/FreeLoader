package freeloader.gui2.settings.mouse;

import javax.swing.JPanel;

import freeloader.gui2.FLGUIContext;
import freeloader.gui2.FLGUIUtilities;
import freeloader.gui2.sub.FLSubInputField;
import freeloader.gui2.sub.FLSubTogglerCheckBox;
import freeloader.robot.actions.mouse.FLActionMouseMove;
import freeloader.robot.actions.values.FLInt;

public class FLSettingsMouseMove extends FLSettingsMouse {

		// INPUT FIELD - X-coordinate
	private FLSubInputField ifLocationX;
	
		// INPUT FIELD - X-coordinate error margin
	private FLSubInputField ifLocationXError;
	
		// TOGGLER CHECK BOX - Randomize X-coordinate
	private FLSubTogglerCheckBox tglRandomizeLocationX;
	
		// TOGGLER CHECK BOX - X-coordinate is relative?
	private FLSubTogglerCheckBox tglRelativeLocationX; 
	
		// INPUT FIELD - Y-coordinate
	private FLSubInputField ifLocationY;
	
		// INPUT FIELD - Y-coordinate error margin
	private FLSubInputField ifLocationYError;
	
		// TOGGLER CHECK BOX - Randomize Y-coordinate
	private FLSubTogglerCheckBox tglRandomizeLocationY;
	
		// TOGGLER CHECK BOX - X-coordinate is relative?
	private FLSubTogglerCheckBox tglRelativeLocationY; 
	
	
	public FLSettingsMouseMove(FLGUIContext c) {
		super(c);
	}
	
	
	@Override
	protected JPanel draw() {
			// Get values
		FLActionMouseMove act = (FLActionMouseMove) context.get("action");
		
		FLInt f_loc_x = act.getLocationX();
		int v_loc_x = f_loc_x.getUnmoddedValue();
		int v_loc_x_err = f_loc_x.getErrorMargin();
		boolean v_loc_x_isrnd = f_loc_x.getRandomized();
		boolean v_loc_x_isrel = f_loc_x.getRelative();
		
		FLInt f_loc_y = act.getLocationY();
		int v_loc_y = f_loc_y.getUnmoddedValue();
		int v_loc_y_err = f_loc_y.getErrorMargin();
		boolean v_loc_y_isrnd = f_loc_y.getRandomized();
		boolean v_loc_y_isrel = f_loc_y.getRelative();
		
		
			// Settings
		JPanel container = createSettingsContainer();
		
		JPanel pane_loc = FLGUIUtilities.createSettingsPane("Location");
		
			// Location X
		JPanel line_loc_x = FLGUIUtilities.createLineContainer();
		ifLocationX = new FLSubInputField(this, "X:  ");
		ifLocationX.textField.setText(Integer.toString(v_loc_x));
		
		ifLocationXError = new FLSubInputField(this, "  ERROR:  ");
		ifLocationXError.textField.setText(Integer.toString(v_loc_x_err));
		
		tglRandomizeLocationX = new FLSubTogglerCheckBox(this, "Randomize", ifLocationXError.textField, false);
		tglRandomizeLocationX.toggler.setSelected(v_loc_x_isrnd);
		
		tglRelativeLocationX = new FLSubTogglerCheckBox(this, "Relative?", v_loc_x_isrel);
		
		line_loc_x.add(ifLocationX.render());
		line_loc_x.add(ifLocationXError.render());
		line_loc_x.add(tglRandomizeLocationX.render());
		line_loc_x.add(tglRelativeLocationX.render());
		
			// Location X
		JPanel line_loc_y = FLGUIUtilities.createLineContainer();
		ifLocationY = new FLSubInputField(this, "Y:  ");
		ifLocationY.textField.setText(Integer.toString(v_loc_y));
		
		ifLocationYError = new FLSubInputField(this, "  ERROR:  ");
		ifLocationYError.textField.setText(Integer.toString(v_loc_y_err));
		
		tglRandomizeLocationY = new FLSubTogglerCheckBox(this, "Randomize", ifLocationYError.textField, false);
		tglRandomizeLocationY.toggler.setSelected(v_loc_y_isrnd);
		
		tglRelativeLocationY = new FLSubTogglerCheckBox(this, "Relative?", v_loc_y_isrel);
		
		line_loc_y.add(ifLocationY.render());
		line_loc_y.add(ifLocationYError.render());
		line_loc_y.add(tglRandomizeLocationY.render());
		line_loc_y.add(tglRelativeLocationY.render());
		
		pane_loc.add(line_loc_x);
		pane_loc.add(line_loc_y);
		
		container.add(pane_loc);
		
		return container;
	}
	
	@Override
	public void updateAction() {
		FLActionMouseMove act = (FLActionMouseMove) context.get("action");
		
			// References
		FLInt f_loc_x = act.getLocationX();
		FLInt f_loc_y = act.getLocationY();
		
			// Variables to be saved
		int v_loc_x = Integer.parseInt(ifLocationX.textField.getText());
		int v_loc_x_err = Integer.parseInt(ifLocationXError.textField.getText());
		boolean v_loc_x_isrnd = tglRandomizeLocationX.toggler.isSelected();
		boolean v_loc_x_isrel = tglRelativeLocationX.toggler.isSelected();
		
		int v_loc_y = Integer.parseInt(ifLocationY.textField.getText());
		int v_loc_y_err = Integer.parseInt(ifLocationYError.textField.getText());
		boolean v_loc_y_isrnd = tglRandomizeLocationY.toggler.isSelected();
		boolean v_loc_y_isrel = tglRelativeLocationY.toggler.isSelected();
		
			// Save changes
		f_loc_x.setValue(v_loc_x);
		f_loc_x.setErrorMargin(v_loc_x_err);
		f_loc_x.setRandomized(v_loc_x_isrnd);
		f_loc_x.setRelative(v_loc_x_isrel);
		
		f_loc_y.setValue(v_loc_y);
		f_loc_y.setErrorMargin(v_loc_y_err);
		f_loc_y.setRandomized(v_loc_y_isrnd);
		f_loc_y.setRelative(v_loc_y_isrel);
	}
}
