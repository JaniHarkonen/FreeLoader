package freeloader.gui2.settings.mouse;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.SpinnerNumberModel;

import freeloader.gui2.FLGUIContext;
import freeloader.gui2.FLGUIUtilities;
import freeloader.gui2.sub.FLSubDropDownMenu;
import freeloader.gui2.sub.FLSubInputField;
import freeloader.gui2.sub.FLSubSpinner;
import freeloader.gui2.sub.FLSubTogglerCheckBox;
import freeloader.robot.actions.mouse.FLActionMouseScroll;
import freeloader.robot.actions.values.FLInt;

public class FLSettingsMouseScroll extends FLSettingsMouse {
	
		// Maximum number of notches allowed per scroll
	public static final int MAX_NUMBER_OF_NOTCHES = 20;
	

		// DROP-DOWN MENU - Scroll direction
	private FLSubDropDownMenu ddScrollDirection;
	
		// SPINNER - Number of notches
	private FLSubSpinner spNumberOfNotches;
	
		//  SPINNER - Number of scrolls in a row
	private FLSubSpinner spNumberOfScrollsInRow;
	
		// INPUT FIELD - Scroll interval (MS)
	private FLSubInputField ifScrollInterval;
	
		// INPUT FIELD - Scroll interval variance (MS)
	private FLSubInputField ifScrollIntervalVariance;
	
		// TOGGLER CHECK BOX - Randomize scroll interval
	private FLSubTogglerCheckBox tglRandomizeScrollInterval;
	
	
	public FLSettingsMouseScroll(FLGUIContext c) {
		super(c);
	}
	
	
	@Override
	protected JPanel draw() {
			// Get values
		FLActionMouseScroll act = (FLActionMouseScroll) context.get("action");
		int v_sdir = act.getDirection();
		int v_nnotch = act.getNotches().getUnmoddedValue();
		int v_srinrow = act.getRepeat().getUnmoddedValue();
		
		FLInt f_srintr = act.getInterval();
		int v_srintr = f_srintr.getUnmoddedValue();
		int v_srintr_var = f_srintr.getErrorMargin();
		boolean v_srintr_isrnd = f_srintr.getRandomized();
		
		
		JPanel container = createSettingsContainer();
		
			// Scroll specs
		JPanel pane_spec = FLGUIUtilities.createSettingsPane("Specs");
		
			// Scroll specs - Scroll direction
		JPanel line_spec_dirs = FLGUIUtilities.createLineContainer();
		
		String[] sdir_choices = {"Up", "Down"};
		ddScrollDirection = new FLSubDropDownMenu(this, "Scroll direction:  ", sdir_choices);
		ddScrollDirection.dropDownMenu.setSelectedIndex(scrollDirectionToArrayIndex(v_sdir));
		line_spec_dirs.add(ddScrollDirection.render());
		
			// Scroll specs - Number of notches
		JPanel line_notches = FLGUIUtilities.createLineContainer();
		spNumberOfNotches = new FLSubSpinner(this, "Number of notches:  ", new SpinnerNumberModel(Math.max(1, v_nnotch), 1, MAX_NUMBER_OF_NOTCHES, 1));
		spNumberOfNotches.spinner.setMaximumSize(new Dimension(64, spNumberOfNotches.spinner.getPreferredSize().height));
		line_notches.add(spNumberOfNotches.render());
		
		pane_spec.add(line_spec_dirs);
		FLGUIUtilities.addEmptySpace(pane_spec);
		pane_spec.add(line_notches);
		
			// Scroll behavior
		JPanel pane_bhv = FLGUIUtilities.createSettingsPane("Behavior");
		
			// Scroll behaviour - Number of scrolls in a row
		JPanel line_repeat = FLGUIUtilities.createLineContainer();
		
		spNumberOfScrollsInRow = new FLSubSpinner(this, "Scrolls in a row:  ", new SpinnerNumberModel(Math.max(1, v_srinrow), 1, Integer.MAX_VALUE, 1));
		spNumberOfScrollsInRow.spinner.setMaximumSize(new Dimension(64, spNumberOfScrollsInRow.spinner.getPreferredSize().height));
		line_repeat.add(spNumberOfScrollsInRow.render());
		
		
			// Scroll behaviour - Scroll interval
		JPanel line_intr_scroll = FLGUIUtilities.createLineContainer();
		
		ifScrollInterval = new FLSubInputField(this, "Scroll interval (MS):  ");
		ifScrollInterval.textField.setText(Integer.toString(v_srintr));
		ifScrollIntervalVariance = new FLSubInputField(this, "  VARIANCE:  ");
		ifScrollIntervalVariance.textField.setEnabled(false);
		ifScrollIntervalVariance.textField.setText(Integer.toString(v_srintr_var));
		tglRandomizeScrollInterval = new FLSubTogglerCheckBox(this, "Randomize", ifScrollIntervalVariance.textField, false);
		tglRandomizeScrollInterval.toggler.setSelected(v_srintr_isrnd);
		
		line_intr_scroll.add(ifScrollInterval.render());
		line_intr_scroll.add(ifScrollIntervalVariance.render());
		line_intr_scroll.add(tglRandomizeScrollInterval.render());
		
		
		pane_bhv.add(line_repeat);
		FLGUIUtilities.addEmptySpace(pane_bhv);
		pane_bhv.add(line_intr_scroll);
		FLGUIUtilities.addEmptySpace(pane_bhv);
		
		container.add(pane_spec);
		FLGUIUtilities.addEmptySpace(container, 2);
		container.add(pane_bhv);
		
		return container;
	}
	
	@Override
	public void updateAction() {
		FLActionMouseScroll act = (FLActionMouseScroll) context.get("action");
		
			// References
		//int f_sdir = act.getDirection()
		FLInt f_nnotch 	= act.getNotches();
		FLInt f_srinrow = act.getRepeat();
		FLInt f_srintr 	= act.getInterval();
		
			// Variables to be saved
		int v_sdir 			= arrayIndexToScrollDirection(ddScrollDirection.dropDownMenu.getSelectedIndex());
		int v_nnotch 		= (int) spNumberOfNotches.spinner.getValue();
		int v_srinrow 		= (int) spNumberOfScrollsInRow.spinner.getValue();
		int v_srintr 		= Integer.parseInt(ifScrollInterval.textField.getText());
		int v_srintr_var 	= Integer.parseInt(ifScrollIntervalVariance.textField.getText());
		
		boolean v_srintr_isrnd = tglRandomizeScrollInterval.toggler.isSelected();
		
			// Save changes
		act.setDirection(v_sdir);
		f_nnotch.setValue(v_nnotch);
		f_srinrow.setValue(v_srinrow);
		f_srintr.setValue(v_srintr);
		f_srintr.setErrorMargin(v_srintr_var);
		f_srintr.setRandomized(v_srintr_isrnd);
	}
	
	
		// Turns a scroll direction drop-down menu index into either -1 or 1
	private int arrayIndexToScrollDirection(int ind) {
		if( ind == 0 ) return -1;
		if( ind == 1 ) return 1;
		
		return 0;
	}
	
		// Turns a scroll direction (-1 or 1) into a scroll direction drop-down
		// menu index
	private int scrollDirectionToArrayIndex(int sdir) {
		if( sdir == -1 ) return 0;
		if( sdir == 1 ) return 1;
		
		return 0;
	}
}
