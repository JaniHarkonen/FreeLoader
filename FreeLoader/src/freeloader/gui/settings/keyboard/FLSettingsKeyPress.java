package freeloader.gui.settings.keyboard;

import java.awt.Dimension;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import freeloader.FLAppContext;
import freeloader.robot.actions.FLRobotAction;

public class FLSettingsKeyPress extends FLSettingsKeyboardKey {
	
	public FLSettingsKeyPress(FLAppContext host) {
		super(host);
	}
	
	public FLSettingsKeyPress(FLAppContext host, FLRobotAction src) {
		super(host, src);
	}
	

	@Override
	public JPanel getElement() {
		JPanel wrapper = createSettingsWrapper();
		
			// Click behavior
		JPanel pane_bhv = createSettingsPane("Behavior");
		
		JPanel line_repeat = createLineWrapper();
		JSpinner spin_count = new JSpinner();
		spin_count.setModel(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));
		spin_count.setMaximumSize(new Dimension(64, spin_count.getPreferredSize().height));
		
		line_repeat.add(new JLabel("Presses in a row: "));
		line_repeat.add(spin_count);
		line_repeat.setMaximumSize(new Dimension(Integer.MAX_VALUE, line_repeat.getPreferredSize().height));
		
		JPanel line_intr_press = createLineWrapper();
		line_intr_press.add(createInputField("Press interval (MS):  "));
		line_intr_press.add(createToggleableInputField("  VARIANCE: ", "Randomize", false, false));
		
		JPanel line_randlen = createLineWrapper();
		line_randlen.add(new JCheckBox("Randomize press length"));
		
		pane_bhv.add(line_repeat);
		pane_bhv.add(new JLabel(" "));
		pane_bhv.add(line_intr_press);
		pane_bhv.add(line_randlen);
		pane_bhv.add(new JLabel(" "));
		
		wrapper.add(createKeyDropDownMenu());
		addEmptySpace(wrapper);
		wrapper.add(pane_bhv);
		return wrapper;
	}
}
