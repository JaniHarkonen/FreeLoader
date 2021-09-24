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
import freeloader.robot.actions.FLRobotAction;
import freeloader.robot.actions.mouse.FLActionMouseScroll;

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
	public JPanel render() {
			// Get values
		FLActionMouseScroll act = (FLActionMouseScroll) context.get("action");
		
		
		JPanel container = createSettingsContainer();
		
			// Scroll specs
		JPanel pane_spec = FLGUIUtilities.createSettingsPane("Specs");
		
			// Scroll specs - Scroll direction
		JPanel line_spec_dirs = FLGUIUtilities.createLineContainer();
		
		String[] sdir_choices = {"Up", "Down"};
		ddScrollDirection = new FLSubDropDownMenu(this, "Scroll direction:  ", sdir_choices);
		line_spec_dirs.add(ddScrollDirection.render());
		
			// Scroll specs - Number of notches
		JPanel line_notches = FLGUIUtilities.createLineContainer();
		spNumberOfNotches = new FLSubSpinner(this, "Number of notches:  ", new SpinnerNumberModel(1, 1, MAX_NUMBER_OF_NOTCHES, 1));
		spNumberOfNotches.spinner.setMaximumSize(new Dimension(64, spNumberOfNotches.spinner.getPreferredSize().height));
		line_notches.add(spNumberOfNotches.render());
		
		pane_spec.add(line_spec_dirs);
		FLGUIUtilities.addEmptySpace(pane_spec);
		pane_spec.add(line_notches);
		
			// Scroll behavior
		JPanel pane_bhv = FLGUIUtilities.createSettingsPane("Behavior");
		
			// Scroll behaviour - Number of scrolls in a row
		JPanel line_repeat = FLGUIUtilities.createLineContainer();
		
		spNumberOfScrollsInRow = new FLSubSpinner(this, "Scrolls in a row:  ", new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));
		spNumberOfScrollsInRow.spinner.setMaximumSize(new Dimension(64, spNumberOfScrollsInRow.spinner.getPreferredSize().height));
		line_repeat.add(spNumberOfScrollsInRow.render());
		
		
			// Scroll behaviour - Scroll interval
		JPanel line_intr_scroll = FLGUIUtilities.createLineContainer();
		
		ifScrollInterval = new FLSubInputField(this, "Scroll interval (MS):  ");
		ifScrollIntervalVariance = new FLSubInputField(this, "  VARIANCE:  ");
		ifScrollIntervalVariance.textField.setEnabled(false);
		tglRandomizeScrollInterval = new FLSubTogglerCheckBox(this, "Randomize", ifScrollIntervalVariance.textField, false);
		
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
		FLRobotAction act = (FLRobotAction) context.get("action");
		
			// References
		// FLInt f_some
		
			// Variables to be saved
		// int v_some
		// boolean v_someb
		
			// Save changes
		//act.setMouseButton(v_mb);
		//f_some.setValue(v_some);
		//f_some.setErrorMargin(v_some);
		//f_some.setRandomized(v_someb);
	}
}
