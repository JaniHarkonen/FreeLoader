package freeloader.gui.settings.mouse;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import freeloader.FLAppContext;
import freeloader.robot.actions.FLRobotAction;

public class FLSettingsMouseScroll extends FLSettingsMouse {
	
	public FLSettingsMouseScroll(FLAppContext host) {
		super(host);
	}
	
	public FLSettingsMouseScroll(FLAppContext host, FLRobotAction src) {
		super(host, src);
	}
	

	@Override
	public JPanel getElement() {
		JPanel wrapper = createSettingsWrapper();
		
			// Scroll specs
		JPanel pane_spec = createSettingsPane("Specs");
		
		JPanel line_spec_dirs = createLineWrapper();
		JPanel jp_spec_dirs = new JPanel();
		jp_spec_dirs.setLayout(new BoxLayout(jp_spec_dirs, BoxLayout.LINE_AXIS));
		String[] spec_dirs = {"Up", "Down"};
		
		JComboBox spec_cb = new JComboBox(spec_dirs);
		spec_cb.setSelectedIndex(0);
		spec_cb.setMaximumSize(new Dimension(64, spec_cb.getPreferredSize().height));
		
		jp_spec_dirs.add(new JLabel("Scroll direction:  "));
		jp_spec_dirs.add(spec_cb);
		line_spec_dirs.add(jp_spec_dirs);
		
		JPanel line_notches = createLineWrapper();
		JSpinner spin_notches = new JSpinner();
		spin_notches.setModel(new SpinnerNumberModel(1, 1, 20, 1));
		spin_notches.setMaximumSize(new Dimension(64, spin_notches.getPreferredSize().height));
		
		line_notches.add(new JLabel("Number of notches:  "));
		line_notches.add(spin_notches);
		
		pane_spec.add(line_spec_dirs);
		addEmptySpace(pane_spec);
		pane_spec.add(line_notches);
		
			// Scroll behavior
		JPanel pane_bhv = createSettingsPane("Behavior");
		
		JPanel line_repeat = createLineWrapper();
		JSpinner spin_count = new JSpinner();
		spin_count.setModel(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));
		spin_count.setMaximumSize(new Dimension(64, spin_count.getPreferredSize().height));
		
		line_repeat.add(new JLabel("Scrolls in a row: "));
		line_repeat.add(spin_count);
		line_repeat.setMaximumSize(new Dimension(Integer.MAX_VALUE, line_repeat.getPreferredSize().height));
		
		JPanel line_intr_scroll = createLineWrapper();
		line_intr_scroll.add(createInputField("Scroll interval (MS):  "));
		line_intr_scroll.add(createToggleableInputField("  VARIANCE: ", "Randomize", false, false));
		
		pane_bhv.add(line_repeat);
		addEmptySpace(pane_bhv);
		pane_bhv.add(line_intr_scroll);
		addEmptySpace(pane_bhv);
		
		wrapper.add(pane_spec);
		addEmptySpace(wrapper, 2);
		wrapper.add(pane_bhv);
		return wrapper;
	}
}
